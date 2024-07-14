document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        googleCalendarApiKey: "AIzaSyAKURukCy6rYdcfKAFsNYhY6wpn7XLzRqA",
        initialView: 'dayGridMonth',
        navLinks: false,
        headerToolbar: {
            left: 'prev',
            center: 'title',
            right: 'next'
        },

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


            eventSources :[
                {
                    googleCalendarId : '98c47f0c7451cb19bde6641ac44c20dcf4b9a03a83b7c8490d5c830024f1fbb1@group.calendar.google.com'
                    , color: 'white'   // an option!
                    , textColor: 'red' // an option!
                }
            ],

                // window.location.href = 'schedule.do?cmd=' + cmd + '&date=' + info.dateStr + '&classNo=1&attendanceInsertStatus=0';
                window.location.href = '/schedule/admin/' + command;
        }
    });
    calendar.render();
});