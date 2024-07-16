$(document).ready(function() {

    // modal 전체 선택
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