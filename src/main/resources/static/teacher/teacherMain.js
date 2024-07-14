$(document).ready(function() {
    $('.row-selected-teacher').hide();
    console.log("done");
    // 초기 로드 시 체크된 라디오 버튼에 해당하는 div를 표시
    var initialSelectedValue = $('input[name="teacherStatusRd"]:checked').val();
    if (initialSelectedValue) {
        $('#teacherStatus' + initialSelectedValue + 'Div').show();
        console.log("done");
    }


    $('input[name="teacherStatusRd"]').on('change', function() {
        var selectedValue = $('input[name="teacherStatusRd"]:checked').val();
        console.log(selectedValue);

        // 모든 상태 div 숨기기
        $('.row-selected-teacher').hide();

        // 선택된 값에 따라 해당 div 보이기
        $('#teacherStatus' + selectedValue + 'Div').show();
    });
});