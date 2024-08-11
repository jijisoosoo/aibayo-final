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
    // console.log($('.datepicker').val());


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


    // 파일 등록 시 이미지 미리보기 및 형식 검증
    $('[id^=mealPic]').on('change', function(event) {
        let files = event.target.files;
        // var previewId = $(this).attr('id') + 'Preview';
        let label = $(this).closest('label');
        label.find('img').remove(); // 이전 미리보기 삭제
        label.find('svg').hide(); // SVG 숨기기

        if (files.length > 0) {
            let file = files[0];
            let reader = new FileReader();
            const maxSizeInMB = 10; // 최대 파일 크기 제한 (MB 단위)
            const maxSizeInBytes = maxSizeInMB * 1024 * 1024; // 바이트 단위로 변환

            reader.onload = function(e) {
                console.log(`file type: ${file.type}`);
                if (file.type.startsWith('image/')) {
                    // 용량 확인
                    let fileSize = file.size; // 파일 크기 (바이트 단위)
                    if (fileSize > maxSizeInBytes) {
                        Swal.fire({
                            icon: "error",
                            title: "업로드 실패",
                            text: "10MB 이하의 사진만 등록 가능합니다.",
                        });
                        event.target.value = ""; // 파일 선택 취소
                        label.find('svg').show();
                        return false;
                    }

                    label.append('<img src="' + e.target.result + '" alt="사진 미리보기" ' +
                        ' class="modal_meal_img">');
                } else { // 이미지 파일이 아닐 경우
                    Swal.fire({
                        icon: "error",
                        title: "업로드 실패",
                        text: "이미지 파일만 선택할 수 있습니다.",
                    });
                    event.target.value = ""; // 파일 선택 취소
                    label.find('svg').show();
                    // label.append('<p>' + file.name + '</p>');
                }
            };

            reader.readAsDataURL(file);
        } else { // 파일을 등록하지 않았을 경우, 원래 img/svg 표시
            let url = window.location.href;
            console.log(url);

            if (url.includes('/meal/admin/write')) {
                label.find('svg').show();
            } else if (url.includes('/meal/admin/modify')) {
                label.append('<img src="' + "http://via.placeholder.com/330x300" + '" alt="사진 미리보기" ' +
                    ' class="modal_meal_img">');
            }

        }
    });

    // writeForm 등록 클릭
    $('#writeMealBtn').on('click', function () {
        // console.log(`등록 버튼 클릭`);

        initMsg();

        // 식단상세 빈 값 체크
        let checkedMealTypes = [];
        $('input[id^="mealType"]:checked').each(function () {
            checkedMealTypes.push($(this).val());
        });
        // console.log(`checkedMealTypes : ${checkedMealTypes}`);
        // console.log(`length: ${checkedMealTypes.length}`);

        if (checkedMealTypes.length < 1) {
            $('.meal_time_checkbox').siblings('.msg').show();
            return false;
        }

        let datepicker = $('#mealDate').val().trim();

        if (datepicker === '') {
            $('.meal_datepicker').siblings('.msg').show();
            return false;
        }

        let mealDate = moment(datepicker).format('YYYY-MM-DD');
        // console.log(`mealDate: ${mealDate}`);

        for (let num of checkedMealTypes) { // 상세 빈 값 확인
            // console.dir($('#mealPic'+ num));
            let mealPic = $('#mealPic' + num);

            if (mealPic.val().trim() === '') { // 사진 빈 값 확인
                // console.log(`사진 미등록`);

                let picBox = mealPic.closest('.modal_meal_img_box');
                picBox.find('.msg').show();
                // console.log(`scrollTop: ${mealPic.offset().top}`);
                // console.dir(mealPic);
                // console.log(`${JSON.stringify(mealPic.offset())}`);
                // console.log(`${JSON.stringify(picBox.offset())}`);

                picBox[0].scrollIntoView({ behavior: 'smooth' });

                return false;
            }

            // // 사진 형식 확인
            // if (!fileCheck(mealPic[0])) {
            //     return false;
            // }

            let menuBox = $('#meal_menu_box_form' + num);
            let target = menuBox.find('.menu_input_text');
            let menu = Array.from(target).map(target => target.value).join('::');
            // console.log(`menu: ${menu}`);

            if (menu.replaceAll('::', '') === '') {
                menuBox.find('.msg').show();
                menuBox.find('input').first().focus();
                return false;
            }
        }
    });
});

function fileCheck(obj) {
    console.dir(obj);
    console.log(`value: ${obj.value}`);
    let pathPoint = obj.value.lastIndexOf('.');
    let filePoint = obj.value.substring(pathPoint+1,obj.length);
    let fileType = filePoint.toLowerCase();
    if(fileType === 'jpg' || fileType === 'gif' || fileType === 'png' ||
        fileType === 'jpeg' || fileType === 'bmp') {

        // 정상적인 이미지 확장자 파일일 경우 로직 처리
        // 용량 확인
        return true;

    } else {
        // swal로 바꿀것
        alert('이미지 파일만 선택할 수 있습니다.');

        let parentObj  = obj.parentNode
        let node = parentObj.replaceChild(obj.cloneNode(true),obj);

        return false;
    }
    if(fileType === 'bmp') {
        let upload = confirm('BMP 파일은 웹상에서 사용하기엔 적절한 이미지 포맷이 아닙니다.\n그래도 계속 하시겠습니까?');
        if(!upload) return false;
    }
}