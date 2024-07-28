$(document).ready(function() {
    $('.kids_list_box').hide();

    // 초기 로드 시 체크된 라디오 버튼에 해당하는 div를 표시
    var initialSelectedValue = $('input[name="kidsStatusRd"]:checked').val();
    if (initialSelectedValue) {
        $('#kidsStatus' + initialSelectedValue + 'Div').show();
    }
    

    $('input[name="kidsStatusRd"]').on('change', function() {
        var selectedValue = $('input[name="kidsStatusRd"]:checked').val();
        
        // 모든 상태 div 숨기기
        $('.kids_list_box').hide();
        
        // 선택된 값에 따라 해당 div 보이기
        $('#kidsStatus' + selectedValue + 'Div').show();
    });
});