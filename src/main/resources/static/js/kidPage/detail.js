$(document).ready(function () {
    $('#modifyKidName').on('click', function () {
        function modifyInfo(result) {
            // console.log("원생명 변경 함수")
            let param = {
                kidNo : $('#kidProfile').data('kid-no'),
                kidName : $('#kidName').val().trim()
            }

            // console.log(`param: ${JSON.stringify(param)}`);

            let url = "/kid/modifyOk"

            commonAjax(url, 'PUT', param);
        }

       alertConfirmModify(modifyInfo);
    });

   $('#modifyKidBirth').on('click', function () {
       function modifyInfo(result) {
           // console.log("원생생일 변경 함수")
           let param = {
               kidNo : $('#kidProfile').data('kid-no'),
               kidBirth : moment($('#kidBirth').val()).format('YYYY-MM-DD')
           }

           // console.log(`param: ${JSON.stringify(param)}`);

           let url = "/kid/modifyOk"

           commonAjax(url, 'PUT', param);
       }

       alertConfirmModify(modifyInfo);
   });

   $(document).on('click', '.remove_relation', function () {
       Swal.fire({
           title: "정말로 삭제하시겠습니까?",
           text: "삭제 후 복구할 수 없습니다.",
           icon: "warning",
           showCancelButton: true,
           confirmButtonColor: "#dc3545",
           confirmButtonText: "삭제",
           cancelButtonText: "취소"

       }).then((result) => {
           if (result.isConfirmed) {
               let $this = $(this);

               // console.log("accept_log 삭제");
               let param = {
                   acceptNo : $this.closest('.info_item').data('accept-no')
               }

               let url = "/kid/deleteOk"

               commonAjax(url, 'DELETE', param);

               // item이 하나만 남을 경우 삭제 버튼 비표시
               let itemBox = $this.closest('.info_content_box');
               // console.dir(itemBox);

               let itemCount = itemBox.find('.info_item').length - 1;
               // console.log(`itemCount: ${itemCount}`);

               $this.closest('.info_item').remove();

               if (itemCount === 1) {
                   let singleItem = itemBox.find('.info_item');
                   singleItem.find('.close_box').remove();
               }
           }
       });
   });

    $('#dischargeKid').on('click', function () {
        Swal.fire({
            title: "정말로 퇴소시키겠습니까?",
            text: "퇴소 후 취소할 수 없습니다.",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#dc3545",
            confirmButtonText: "퇴소",
            cancelButtonText: "취소"

        }).then((result) => {
            if (result.isConfirmed) {
                let url = "/kid/deleteOk"

                // 모든 관계 제거
                $('.info_item').each(function () {
                    let param = {
                        acceptNo : $(this).data('accept-no')
                    }
                    console.log(`remove_relation param: ${JSON.stringify(param)}`);

                    commonAjax(url, 'DELETE', param);
                });

                let param = {
                    kidNo : $('#kidProfile').data('kid-no')
                }
                console.log(`kidNo param: ${JSON.stringify(param)}`)

                commonAjax(url, 'DELETE', param);

            }
        });
    });

   $('#addClassModal').on('show.bs.modal', function (e) {
       let selectedClasses = [];

        $('.class_item').each(function () {
            selectedClasses.push($(this).data('class-no'));
        });

        // console.log(`소속 반: ${selectedClasses}`);

        for (let classNo of selectedClasses) {
            $('#classCheck' + classNo).prop('checked', true);
            $('#classCheck' + classNo).prop('disabled', true);
        }

   });

   $('#addClassModal').on('hidden.bs.modal', function () {
       $('.modal_class_item').each(function () {
          let modalCheck = $(this).find('input[id^="classCheck"]');

           if (modalCheck.is(':checked') && !modalCheck.is(':disabled')) {
               modalCheck.prop('checked', false);
           }
       });
   });

   $('#modalAddClassBtn').on('click', function () {
       function modifyInfo(result) {
           // console.log("반추가 모달 추가 버튼 클릭");

           let modifyClassList = [];

           $('.modal_class_item').each(function () {
               let modalCheck = $(this).find('input[id^="classCheck"]');

               if (modalCheck.is(':checked') && !modalCheck.is(':disabled')) {
                   modifyClassList.push(modalCheck.val())
               }
           });

           let url = "/kid/modifyOk"

           for (let classNo of modifyClassList) {
               let param = {
                   kidNo : $('#kidProfile').data('kid-no'),
                   classNo : classNo
               }

               // console.log(`param: ${JSON.stringify(param)}`);

               commonAjax(url, 'POST', param);
           }
       }

       alertConfirmModify(modifyInfo);
   });

});

function afterSuccess(response, method) {
    if (method === 'PUT') {
        if (response.kidName != null || response.kidBirth != null) {
            $('#kidName').val(response.kidName);
            $('#kidBirth').val(moment(response.kidBirth).format('YYYY.MM.DD'));
        }
    }

    if (method === 'POST') {
        $('#parentKidDiv').replaceWith($(response).find('#parentKidDiv'));
        $('#classKidDiv').replaceWith($(response).find('#classKidDiv'));

        $('#closeParentModal').click();
        $('#closeClassModal').click();
    }

    if (method === 'DELETE' && response.dischargeFlag === '1') {
        Swal.fire({
            title: "퇴소 완료",
            text: "창을 닫으면 목록 화면으로 돌아갑니다.",
            icon: "success",
            customClass: {
                confirmButton: 'btn-ab btn-ab-swal'
            }
        }).then((result) => {
            window.location.href = window.location.origin + '/kid/list';
        })
    }
}

function alertConfirmModify(modifyInfo) {
    Swal.fire({
        title: "정말로 수정하시겠습니까?",
        showCancelButton: true,
        confirmButtonText: "네",
        cancelButtonText: "아니오",
        customClass: {
            confirmButton: 'btn-ab btn-ab-swal'
        }
    }).then((result) => {
        if (result.isConfirmed) {
             modifyInfo(result);
        }
    });
}
