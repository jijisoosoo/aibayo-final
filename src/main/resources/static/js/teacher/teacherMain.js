$(document).ready(function() {
    initStatus();
    changeByStatus();

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

    // 선택된 옵션에 selected 속성 추가
    $('#selectClass option').each(function() {
        if ($(this).val() === classNo) {
            $(this).prop('selected', true);
        } else {
            $(this).prop('selected', false);
        }
    });




}
