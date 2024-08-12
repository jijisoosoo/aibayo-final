$(document).ready(function(){
    $('#time').timepicker({
        timeFormat: 'h:mm p',
        interval: 30,
        minTime: '12:00 pm',
        maxTime: '18:00 pm',
        defaultTime: '12 :00 pm',
        dynamic: false,
        dropdown: true,
        scrollbar: true
    });
});