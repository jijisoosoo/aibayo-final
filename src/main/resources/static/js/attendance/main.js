document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        themeSystem: 'bootstrap5',
        initialView: 'dayGridMonth',
        locale: 'ko',
        googleCalendarApiKey: 'AIzaSyAgH-X2n7hFaaKAo5h8_mBWcKbaV-G2hnk',
        events: {
            googleCalendarId: 'ko.south_korea#holiday@group.v.calendar.google.com',
            className: 'kr-holiday',
            textColor: 'red'
        },

        buttonText: {
            today: '이번달',
            month: '월간',
            week: '주간',
            day: '일간',
            list: '목록'
        },

        dateClick: function(info) {
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

            window.location.href = '/attendance/admin/' + command;
        }
    });
    calendar.render();
});