$(document).ready(function() {
    initStatus();
    changeByStatus();
    ifResultNull();

    // 반에 따라 list 보여주기
    $(document).on('change', '#selectClass', function () {
        let classNo = $('#selectClass').val();
        console.log("반 변경:" + classNo);

        let param = {
            classNo: classNo
        };

        console.log("param:" + JSON.stringify(param));

        let url = "/teacher/listByClass";

        commonAjax(url, 'POST', param);

    });

    $(document).on('click', '#waitAccept', function () {
        Swal.fire({
            title: "정말로 승인하시겠습니까?",
            showCancelButton: true,
            confirmButtonText: "네",
            cancelButtonText: "아니오",
            customClass: {
                confirmButton: 'btn-ab btn-ab-swal'
            }
        }).then((result) => {
            if (result.isConfirmed) {
                let target = $(this).closest('.profile_wait');
                let url = "/teacher/modifyOk";

                let param = {
                    id : parseInt($('.profile_wait').attr('id')),
                    teacherKinderAcceptNo : $('.profile_wait').data('teacher-kinder-accept-no')
                }
                console.log(`param : ${JSON.stringify(param)}`);

                target.closest('.profile_wait').remove();

                commonAjax(url, 'PUT', param);
            }
        });
    });

    $(document).on('click', '#waitReject', function () {
        Swal.fire({
            title: "정말로 삭제하시겠습니까?",
            showCancelButton: true,
            confirmButtonColor: "#dc3545",
            confirmButtonText: "네",
            cancelButtonText: "아니오"
        }).then((result) => {
            if (result.isConfirmed) {
                let target = $(this).closest('.wait_buttons');

                let url = "/kid/deleteOk";

                let param = {
                    parentKidAcceptNo : target.data('parent-kid-accept-no')
                }
                // console.log(`param : ${JSON.stringify(param)}`);

                target.closest('.kid_item_parent').remove();

                commonAjax(url, 'DELETE', param);
            }
        });
    });


    // 초대중 처리
    $(document).on('click', '#inviteDelete', function () {
        Swal.fire({
            title: "정말로 취소하시겠습니까?",
            showCancelButton: true,
            confirmButtonColor: "#dc3545",
            confirmButtonText: "네",
            cancelButtonText: "아니오"
        }).then((result) => {
            if (result.isConfirmed) {
                let target = $(this).closest('.kid_item_btns');

                let url = "/inviteCode/deleteOk";

                let param = {
                    inviteId: target.data('invite-id'),
                    acceptNo : target.data('invite-code-accept-no')
                }
                // console.log(`param : ${JSON.stringify(param)}`);

                target.closest('.kid_item_parent').remove();

                commonAjax(url, 'DELETE', param);
            }
        });
    });

    $(document).on('click', '#inviteResend', function () {
        Swal.fire({
            title: "초대 메일을 재전송 하시겠습니까?",
            showCancelButton: true,
            confirmButtonText: "네",
            cancelButtonText: "아니오",
            customClass: {
                confirmButton: 'btn-ab btn-ab-swal'
            }
        }).then((result) => {
            if (result.isConfirmed) {
                let target = $(this).closest('.kid_item_btns');

                let url = "/inviteCode/resendMail";

                let param = {
                    inviteId: target.data('invite-id'),
                    acceptNo : target.data('invite-code-accept-no')
                }
                console.log(`param : ${JSON.stringify(param)}`);

                Swal.fire({
                    title: '전송 중...',
                    text: '초대 메일을 전송하고 있습니다.',
                    allowOutsideClick: false,
                    didOpen: () => {
                        Swal.showLoading();
                    }
                });

                commonAjax(url, 'PUT', param);
            }
        });
    });



});



function initStatus() {
    $('.row-selected-teacher').hide();

    // 초기 로드 시 체크된 라디오 버튼에 해당하는 div를 표시
    var initialSelectedValue = $('input[name="teacherStatusRd"]:checked').val();
    if (initialSelectedValue) {
        $('#teacherStatus' + initialSelectedValue + 'Div').show();
    }
}

function changeByStatus(){
    $('input[name="teacherStatusRd"]').on('change', function() {
        var selectedValue = $('input[name="teacherStatusRd"]:checked').val();

        // 모든 상태 div 숨기기
        $('.row-selected-teacher').hide();

        // 선택된 값에 따라 해당 div 보이기
        $('#teacherStatus' + selectedValue + 'Div').show();

        // ifResultNull();
    });
}

function afterSuccess(response, method) {
    // classNo 유지
    let classNo = $('#selectClass').val();

    $('#teacherStatus1Div').replaceWith($(response).find('#teacherStatus1Div'));
    $('#teacherStatus0Div').replaceWith($(response).find('#teacherStatus0Div'));
    $('#teacherStatus2Div').replaceWith($(response).find('#teacherStatus2Div'));

    initStatus();
    changeByStatus();

    // dropdown - 선택된 옵션에 selected 속성 추가
    $('#selectClass option').each(function() {
        if ($(this).val() === classNo) {
            $(this).prop('selected', true);
        } else {
            $(this).prop('selected', false);
        }
    });

    ifResultNull();

    // 승인대기 상태변경
    if (response.teacherKinderAcceptNo != null) {
        let count = $('.carousel_wait').find('.profile_wait').length;

        let countBanner = `승인 대기 ${count} 명`;
        let countBox = `${count}`

        let targetBanner = $('label[for="teacherStatus0"]');
        let targetBox = $('#teacherStatus0Div').find('.n-2');

        targetBanner.text(countBanner);
        targetBox.text(countBox);
    }

    // // 초대중 업데이트
    // if (response.inviteId != null) {
    //     // console.log(`inviteId: ${response.inviteId}`);
    //     if (method === 'PUT') { // 초대메일 재전송 했을 경우에만
    //         Swal.close();
    //
    //         Swal.fire({
    //             title: "전송 완료",
    //             text: "초대 메일이 성공적으로 전송되었습니다.",
    //             icon: "success",
    //             customClass: {
    //                 confirmButton: 'btn-ab btn-ab-swal'
    //             }
    //         })
    //     }
    //
    //     let count = $('#kidsStatus2Div').find('.kid_item_parent').length;
    //
    //     let countBanner = `초대 중 ${count}명`;
    //     let countBox = `초대 중인 학부모 ${count}명`
    //
    //     let targetBanner = $('label[for="kidsStatus2"]');
    //     let targetBox = $('#kidsStatus2Div').find('.count_text');
    //
    //     targetBanner.text(countBanner);
    //     targetBox.text(countBox);
    // }
}

function ifResultNull(){

    // 모든 상태 div 숨기기
    $('.ifResultNull').hide();

    // 선택된 값에 따라 해당 div 보이기

    console.log($('#teacherStatus1Div .profile').find().prevObject.length);
    console.log($('#teacherStatus0Div .profile').find().prevObject.length);
    console.log($('#teacherStatus2Div .profile').find().prevObject.length);

    if($('#teacherStatus1Div .profile').find().prevObject.length == 0){
        $('#teacherStatus1Div .ifResultNull').show();
    }
    if($('#teacherStatus0Div .profile_wait').find().prevObject.length == 0){
        $('#teacherStatus0Div .ifResultNull').show();
    }
    if($('#teacherStatus2Div .profile_wait').find().prevObject.length == 0){
        $('#teacherStatus2Div .ifResultNull').show();
    }
}
