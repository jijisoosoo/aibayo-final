$(document).ready(function() {

    // modify에서 기존 classList 받아와서 체크하기
    if($('#checked_class_div')){
        var originClass = $('.origin_class').map(function() {
                return this.id;
        }).get();

        console.log(originClass);

        if(originClass.includes('0')){
            $("input[class='form-check-input']").prop("checked", true);
        }else{
            $("input[class='form-check-input']").each(function() {
                if (originClass.includes(this.id)) {
                    $(this).prop("checked", true);
                }
            });
        }

        checkCnt();
    }

    // checkbox 전체 선택 + 체크된 개수 표시
    $("#checkAll").click(function() {
        if($("#checkAll").is(":checked")) $("input[class='form-check-input']").prop("checked", true);
        else $("input[class='form-check-input']").prop("checked", false);
    });

    $(".form-check-input").click(function() {
        checkCnt();
    });

    // startDate 오늘 이후로 설정 + endDate보다 뒤일 시 endDate = null
    $('.startDate').on('change', function () {
        var startDate = new Date($('.startDate').val()).setHours(0, 0, 0, 0);
        // console.log(startDate);
        var today = new Date().setHours(0, 0, 0, 0);
        // console.log(today);
        if(startDate <= today){
            Swal.fire({
                text: "오늘 이후의 일정만 추가할 수 있습니다.",
                icon: "warning",
                confirmButtonColor: "#dc3545",
                confirmButtonText: "확인",

            }).then((result) => {
                $('.startDate').val(null);
            });
        }

        var endDate = new Date($('.endDate').val()).setHours(0, 0, 0, 0);
        // console.log(endDate);
        if(endDate < startDate){
            $('.endDate').val(null);
        }
    });

    // endDate 오늘 이후로 설정
    $('.endDate').on('change', function () {
        var endDate = new Date($('.endDate').val()).setHours(0, 0, 0, 0);
        // console.log(endDate);
        var startDate = new Date($('.startDate').val()).setHours(0, 0, 0, 0);
        // console.log(startDate);
        if(endDate < startDate){
            Swal.fire({
                text: "종료일은 시작일 이후로 설정할 수 있습니다.",
                icon: "warning",
                confirmButtonColor: "#dc3545",
                confirmButtonText: "확인",

            }).then((result) => {
                $('.endDate').val(null);
            });
        }
    });

    $(document).on('click', '.button-submit', function () {

        if(!$('.startDate').val()){
            Swal.fire({
                text: "시작일을 입력해주세요.",
                icon: "warning",
                confirmButtonColor: "#dc3545",
                confirmButtonText: "확인",

            }).then((result) => {
                $('.startDate').focus();
            });
        }else if($('.form-check-input:checked').length === 0){
            Swal.fire({
                text: "1개 이상의 반을 선택해 주세요.",
                icon: "warning",
                confirmButtonColor: "#dc3545",
                confirmButtonText: "확인",

            }).then((result) => {
                $('.form-check-input').focus();
            });
        }else if(!$('.default-wrapper').val()){
            Swal.fire({
                text: "제목을 입력해주세요.",
                icon: "warning",
                confirmButtonColor: "#dc3545",
                confirmButtonText: "확인",

            }).then((result) => {
                $('.default-wrapper').focus();
            });
        }else if(!$('.calendar-textarea').val()){
            Swal.fire({
                text: "내용을 입력해주세요.",
                icon: "warning",
                confirmButtonColor: "#dc3545",
                confirmButtonText: "확인",

            }).then((result) => {
                $('.calendar-textarea').focus();
            });
        }else{
            var startDate = $('.startDate').val()
                    .replace('.','-').replace('.','-')
                + 'T00:00';
            // console.log(startDate);

            var endDate = $('.endDate').val();
            if(endDate === ''){
                endDate = startDate;
            }else{
                endDate = endDate.replace('.','-').replace('.','-') + 'T00:00'
            }
            // console.log(endDate);

            var classList = $('.form-check-input:checked').map(function() {
                if(this.id !== 'checkAll')
                    return this.id;
            }).get();

            if(classList.length === $("input[class='form-check-input']").length - 1){
                var classList = []; // 배열 초기화 (비우기)
                classList.push(0);
            }

            // 추가 수정 구분해서 처리
            if(!$('#checked_class_div').length){    // 추가

                let param = {
                    startDate: startDate,
                    endDate: endDate,
                    classList : classList,
                    boardTitle : $('.default-wrapper').val(),
                    boardContents : $('.calendar-textarea').val()
                };
                console.log("param:" + JSON.stringify(param));

                let url = "/schedule/admin/addSchedule";
                commonAjax(url, 'POST', param);

            }else{  // 수정

                // boardNo 추가
                var boardNo = $('#board_no_div').data('value');

                // scheduleNo 추가
                var scheduleNo = $('#schedule_no_div').data('value');

                // originClassList param에 추가
                var originClassList = [];
                if ($('#checked_class_div').length) {
                    $('.origin_class').each(function () {
                        originClassList.push(this.id);
                    });
                }

                let param = {
                    boardNo: boardNo,
                    scheduleNo: scheduleNo,
                    startDate: startDate,
                    endDate: endDate,
                    originClassList: originClassList,
                    classList : classList,
                    boardTitle : $('.default-wrapper').val(),
                    boardContents : $('.calendar-textarea').val()
                };
                console.log("param:" + JSON.stringify(param));

                let url = "/schedule/admin/modifySchedule";
                commonAjax(url, 'POST', param);
            }
        }
    });
});

// textarea 사이즈 자동조절
function autoResize(textarea) {
    textarea.style.height = 'auto';
    textarea.style.height = textarea.scrollHeight + 'px';
}

// textarea 글자수 제한
function chkword(obj, maxWord) {

    var strValue = obj.value;
    var strLen = strValue.length;
    var totalByte = 0;
    var len = 0;
    var oneChar = "";
    var str2 = "";

    for (var i = 0; i < strLen; i++) {
        oneChar = strValue.charAt(i);
        if (escape(oneChar).length > 4) {
            totalByte += 2;
        } else {
            totalByte++;
        }

        // 입력한 문자 길이보다 넘치면 잘라내기 위해 저장
        if (totalByte <= maxWord) {
            // len = i + 1;
            len = maxWord;
        }
    }

    // 넘어가는 글자는 자른다.
    if (strLen > maxWord) {
        alert(maxWord + "자를 초과 입력 할 수 없습니다.");
        str2 = strValue.substr(0, len);
        obj.value = str2;
        strLen = maxWord
        chkword(obj, maxWord);
    }

    $('#textcnt').html("( " + strLen + " / " + maxWord + " )");
}

// 체크 개수 세기
function checkCnt(){
    var checked = $("input[class='form-check-input']:checked").length;

    if($("#checkAll").is(":checked")){
        checked--
    }

    if ($("input[class='form-check-input']").length - 1 != checked){
        $("input[id='checkAll']").prop("checked", false)
    }

    document.getElementById('checkboxCnt').innerText
        = '(' + checked + '개)';
}

function afterSuccess(response) {
    // 추가 수정 구분해서 처리
    if(!$('#checked_class_div')){
        Swal.fire({
            title: "수정 완료",
            text: "창을 닫으면 일정표 화면으로 돌아갑니다.",
            icon: "success",
            customClass: {
                confirmButton: 'btn-ab btn-ab-swal'
            }
        }).then((result) => {
            window.location.href = window.location.origin + '/schedule/admin/scheduleMain';
        });

    }else{
        Swal.fire({
            title: "추가 완료",
            text: "창을 닫으면 일정표 화면으로 돌아갑니다.",
            icon: "success",
            customClass: {
                confirmButton: 'btn-ab btn-ab-swal'
            }
        }).then((result) => {
            window.location.href = window.location.origin + '/schedule/admin/scheduleMain';
        });
    }
}