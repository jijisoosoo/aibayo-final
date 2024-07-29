$(document).ready(function() {
    initStatus();

    changeByStatus();

    $('#selectClass').on('change', function () {
        let classNo = $('#selectClass').val();
        // console.log(`반 변경: ${classNo}`);

        let param = {
            classNo : classNo
        };

        // console.log(`param: ${JSON.stringify(param)}`);

        let url = "/kid/searchByClass"

        commonAjax(url, 'POST', param);
    });
});

function afterSuccess(response) {
    $('.kid_status_box').replaceWith($(response).find('.kid_status_box'));
    $('#kidsStatus1Div').replaceWith($(response).find('#kidsStatus1Div'));
    $('#kidsStatus0Div').replaceWith($(response).find('#kidsStatus0Div'));
    $('#kidsStatus2Div').replaceWith($(response).find('#kidsStatus2Div'));

    initStatus();

    changeByStatus();
}

function initStatus() {
    $('.kids_list_box').hide();

    // 초기 로드 시 체크된 라디오 버튼에 해당하는 div를 표시
    var initialSelectedValue = $('input[name="kidsStatusRd"]:checked').val();
    if (initialSelectedValue) {
        $('#kidsStatus' + initialSelectedValue + 'Div').show();
    }
}

function changeByStatus() {
    $('input[name="kidsStatusRd"]').on('change', function() {
        var selectedValue = $('input[name="kidsStatusRd"]:checked').val();

        // 모든 상태 div 숨기기
        $('.kids_list_box').hide();

        // 선택된 값에 따라 해당 div 보이기
        $('#kidsStatus' + selectedValue + 'Div').show();
    });
}