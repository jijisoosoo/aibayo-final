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
                let target = $(this).closest('.kid_item_btns');

                let url = "/kid/modifyOk";

                let param = {
                    parentKidAcceptNo : target.data('parent-kid-accept-no')
                }
                // console.log(`param : ${JSON.stringify(param)}`);

                target.closest('.kid_item_parent').remove();

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
                let target = $(this).closest('.kid_item_btns');

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

function afterSuccess(response) {
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
