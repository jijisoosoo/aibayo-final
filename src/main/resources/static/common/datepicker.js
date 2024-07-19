$(document).ready(function(){
    $('.datepicker').datepicker({
        format: 'yyyy.mm.dd',
        autoclose: true,
        language: 'ko',
        orientation: 'bottom',
        todayHighlight: true,
    }).on('changeDate', function(e) {
        var date = e.date;
        var dateText = moment(date).format('YYYY-MM-DD HH:mm:ss');

        // 날짜 검색 function이 있을 경우에만 AJAX 요청을 실행합니다.
        if (typeof findByRegDate === "function") {
            findByRegDate(dateText);
        }
    });
});