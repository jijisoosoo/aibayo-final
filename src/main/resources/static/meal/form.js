// 체크박스 체크 되어 있을 경우에만 div 표시
function toggleDivs() {
    $('input[type="checkbox"]').each(function() {
        var checkboxId = $(this).attr('id');
        var number = checkboxId.match(/\d+/)[0];
        var divId = '#mealItemDiv' + number;
        if ($(this).is(':checked')) {
            $(divId).show();
        } else {
            $(divId).hide();
        }
    });
}

$(document).ready(function(){
    $('.meal_item_box_form').hide();

    // 페이지 로드 시 초기 상태 확인
    toggleDivs();

    // 체크박스 상태 변경 시
    $('input[type="checkbox"]').change(function() {
        toggleDivs();
    });

    // 오늘 날짜 자동으로 들어가게 설정
    // UTC와 한국 시차(+9시간) 구해서 날짜 객체 생성
    const offset = new Date().getTimezoneOffset() * 60 * 1000;
    const today = new Date(Date.now() - offset);

    $('.datepicker').val(today.toISOString().substring(0,10).replaceAll('-','.'));
    console.log($('.datepicker').val());


    // + 클릭 시 메뉴명 input 추가
    $('.menu_input_plus').on('click', function() {
        console.log("메뉴 추가");

        var parentElement = $(this).closest('.meal_menu_box_form');
        var parentId = parentElement.attr('id');

        if (parentId) {
            var newMenuInputForm = $('<div class="menu_input_form">' +
                '<input type="text" class="form-control menu_input_text" name="mealMenu1" placeholder="메뉴명을 입력해주세요.">' +
                '<div class="btn menu_input_close" title="메뉴 삭제">x</div>' +
                '</div>');
            $('#' + parentId).append(newMenuInputForm);
        } else {
            console.warn('Parent element does not have an ID');
        }
    });


    // x 클릭 시 메뉴명 input 삭제
    $(document).on('click', '.menu_input_close', function() {
        console.log("메뉴 삭제");
        $(this).closest('.menu_input_form').remove();
    });


    // 파일 등록 시 이미지 미리보기
    $('[id^=mealPic]').on('change', function(event) {
        var files = event.target.files;
        // var previewId = $(this).attr('id') + 'Preview';
        var label = $(this).closest('label');
        label.find('img').remove(); // 이전 미리보기 삭제
        label.find('svg').hide(); // SVG 숨기기

        if (files.length > 0) {
            var file = files[0];
            var reader = new FileReader();

            reader.onload = function(e) {
                if (file.type.startsWith('image/')) {
                    label.append('<img src="' + e.target.result + '" alt="사진 미리보기" ' +
                        ' class="modal_meal_img">');
                } else {
                    label.append('<p>' + file.name + '</p>');
                }
            };

            reader.readAsDataURL(file);
        } else { // 파일을 등록하지 않았을 경우, 원래 img/svg 표시
            label.append('<img src="' + "http://via.placeholder.com/330x300" + '" alt="사진 미리보기" ' +
                ' class="modal_meal_img">');
            label.find('svg').show();
        }
    });
});