document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        navLinks: false,
        dateClick: function (info) {
        var today = new Date();
        var clickedDate = new Date(info.dateStr);

        var command = '';

        if (clickedDate.toDateString() === today.toDateString()) {
            command = 'detailToday';
        } else if (clickedDate < today) {
            command = 'detailBefore';
        } else {
            command = 'detailAfter';
        }

        // window.location.href = 'attendance.do?cmd=' + cmd + '&date=' + info.dateStr + '&classNo=1&attendanceInsertStatus=0';
        window.location.href = '/attendance/admin/' + command;
    }
    });
    calendar.render();
});