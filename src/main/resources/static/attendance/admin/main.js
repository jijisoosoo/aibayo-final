document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        navLinks: false,
        dateClick: function (info) {
        var today = new Date();
        var clickedDate = new Date(info.dateStr);
        var cmd = '';

        if (clickedDate.toDateString() === today.toDateString()) {
            cmd = 'detailToday';
        } else if (clickedDate < today) {
            cmd = 'detailBefore';
        } else {
            cmd = 'detailAfter';
        }

        window.location.href = 'attendance.do?cmd=' + cmd + '&date=' + info.dateStr + '&classNo=1&attendanceInsertStatus=0';
    }
    });
    calendar.render();
});