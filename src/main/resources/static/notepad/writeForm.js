$(document).ready(function() {
    $('.summernote_create').summernote({
        height: 300,
        lang: 'ko-KR' // 한국어 설정
    });

    // 오늘 날짜 자동으로 들어가게 설정
    // UTC와 한국 시차(+9시간) 구해서 날짜 객체 생성
    const offset = new Date().getTimezoneOffset() * 60 * 1000;
    const today = new Date(Date.now() - offset);

    $(".datepicker").val(today.toISOString().substring(0,10).replaceAll('-','.'));
    console.log($(".datepicker").val());

    /* 기본으로 반선택/원생선택 select  숨기기 */
    $("#selectClass").hide();
    $("#selectKid").hide();
    $("#liferecord").hide();

    /* 알림 범위 select 선택 결과에 따라 하위 select 표시 */
    $("#selectScope").change(function() {
        var value= $(this).val();
        $("#selectClass").hide();
        $("#selectKid").hide();
        $("#liferecord").hide();
        $("#liferecord input[type='radio']").prop("required", false);
        
        console.log("value: " + value);
        
        if (value == "1") {
            $("#selectClass").show();
            $("#liferecord").hide();
            $("#liferecord input[type='radio']").prop("required", false);
        } else if (value == "2") { // 원생이 선택될 경우, 생활기록이 같이 표시되도록 설정
            $("#selectKid").show();
            $("#liferecord").show();
            $("#liferecord input[type='radio']").prop("required", true);
        }
    });
});