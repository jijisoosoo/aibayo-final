$(document).ready(function() {

    // checkbox 전체 선택
    $("#checkAll").click(function() {
        if($("#checkAll").is(":checked")) $("input[class='form-check-input']").prop("checked", true);
        else $("input[class='form-check-input']").prop("checked", false);
    });

    $("input[class=chk]").click(function() {
        var total = $("input[class='form-check-input']").length;
        var checked = $("input[class='form-check-input']:checked").length;

        if(total != checked) $("#checkAll").prop("checked", false);
        else $("#checkAll").prop("checked", true);
    });

});

// textarea 사이즈 자동조절
function autoResize(textarea) {
    textarea.style.height = 'auto';
    textarea.style.height = textarea.scrollHeight + 'px';
}

function cntword(maxByte) {
    var obj = $("input[class=calendar-textarea]");
    var strValue = obj.value;
    var strLen = strValue.length;
    var totalByte = 0;
    var cnt = 0;
    var oneChar = "";

    for (var i = 0; i < strLen; i++) {
        oneChar = strValue.charAt(i);
        if (escape(oneChar).length > 4) {
            totalByte += 2;
        } else {
            totalByte++;
        }

        // 입력한 문자 길이보다 넘치면 잘라내기 위해 저장
        if (totalByte <= maxByte) {
            cnt = maxByte;
        }
    }
    $('#textcnt').val("(" + cnt + " / " + maxByte + ")");
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