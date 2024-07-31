$(document).ready(function () {
    $('#modifyKidName').on('click', function () {
        function modifyInfo(result) {
            console.log("원생명 변경 함수")
        }

       alertConfirmModify(modifyInfo);
    });

   $('#modifyKidBirth').on('click', function () {
       function modifyInfo(result) {
           console.log("원생생일 변경 함수")
       }

       alertConfirmModify(modifyInfo);
   });

   $('.remove_relation').on('click', function () {
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
               $(this).closest('.info_item').remove();
               // 관계 값 등 받아서 추가 로직
               // 관계 타입은 th:data에 설정하면 될 듯
           }
       });
   });

   $('#addClassModal').on('show.bs.modal', function (e) {
       let selectedClasses = [];

        $('.class_item').each(function () {
            selectedClasses.push($(this).data('class-no'));
        });

        console.log(`소속 반: ${selectedClasses}`);

        for (let classNo of selectedClasses) {
            $('#classCheck' + classNo).attr('checked', 'true');
            $('#classCheck' + classNo).attr('disabled', 'true');
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

});

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
        modifyInfo(result);
    });
}