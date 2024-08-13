$(document).ready(function() {

    // 선택한 날짜가 유지되도록
    var selectedValue;

    var calendarEl = document.getElementById('calendar');

    var eventsData = getEvents();

    var calendar = new FullCalendar.Calendar(calendarEl, {
        googleCalendarApiKey: "AIzaSyAKURukCy6rYdcfKAFsNYhY6wpn7XLzRqA",
        height: "700px",
        expandRows: true,
        locale: 'ko',
        events:
            {
                googleCalendarId : 'ko.south_korea#holiday@group.v.calendar.google.com',
                backgroundColor: 'red'
            }
        ,

        themeSystem: 'bootstrap5',
        headerToolbar: {
            left: 'prev',
            // center: 'title today',
            center: 'title',
            right: 'next'
            // right: 'dayGridMonth'
        },
        dayMaxEvents: true,
        buttonText: {
            today: '이번달',
            month: '월간',
            week: '주간',
            day: '일간',
            list: '목록'
        },

        // 선택한 날짜 출력
        dateClick: function(dateInfo) {
            //날짜 선택
            selectedValue = dateInfo.dateStr;

            // 모든 상태 div 숨기기
            $('.single-schedule').hide();

            // 선택된 값에 따라 해당 div 보이기
            $('.' + selectedValue).show();
            var selectedValueStr = selectedValue.replace('-','년 ').replace('-','월 ').concat('일');
            document.getElementById("selectedDate").innerHTML = selectedValueStr;
        },

        // 날짜별 일정 출력
        datesSet: function (dateInfo) {
            // 처음 calendar 로드 시 모든 div 숨기고
            $('.single-schedule').hide();

            // 오늘 날짜 설정
            var initialSelectedValue = calendar.getDate().toISOString().substring(0, 10);
            var initialSelectedValueStr = initialSelectedValue.replace('-','년 ').replace('-','월 ').concat('일');

            if (selectedValue) {    // 선택한 날짜가 있는 경우
                $('.' + selectedValue).show();
                var selectedValueStr = selectedValue.replace('-','년 ').replace('-','월 ').concat('일');
                document.getElementById("selectedDate").innerHTML = selectedValueStr;
            }else if(initialSelectedValue) {    //선택한 날짜가 없는 경우 오늘 날짜의 일정 출력
                $('.' + initialSelectedValue).show();
                document.getElementById("selectedDate").innerHTML = initialSelectedValueStr;
            }

            // 달력에 표시 중인 달 확인
            var currentDate = dateInfo.view.currentStart;
            var currentMonth = currentDate.getMonth() + 1;
            console.log("현재 표시중인 일: " + currentDate);
            console.log("현재 표시중인 달: " + currentMonth);

            // datesRender 이벤트가 발생할 때 버튼 스타일을 변경하고 보이도록 설정
            $('.fc-toolbar button').each(function() {
                $(this).removeClass('btn-primary')
                    .addClass('btn-ab');
            });

            // 'dayGridMonth' 버튼을 비활성화
            var dayGridMonthButton = document.querySelector('.fc-dayGridMonth-button');
            if (dayGridMonthButton) {
                dayGridMonthButton.classList.add('disabled');
            }
        },


        events: eventsData
        // events: [
        //     {
        //         title: '학부모 심폐소생술 교육',
        //         start: '2024-07-15',
        //         classNo: 0,
        //         contents: '유치원 3층 대강당에서 학부모 심폐소생술 교육을 실시합니다.',
        //         location: ''
        //     },
        //     {
        //         title: '여름 피크닉',
        //         start: '2024-07-15',
        //         classNo: 0,
        //         contents: '종로 3가 탑골공원으로 현장학습 진행 예정입니다.',
        //         location: ''
        //     },
        //     {
        //         title: '화채 만들기',
        //         start: '2024-07-16',
        //         end: '2024-07-19',
        //         classNo: 0,
        //         contents: '각 반마다 화채 만들기 실습이 있을 예정입니다.',
        //         location: ''
        //     }
        // ]
    });

    calendar.render();

});

function getEvents() {
    const scheduleElements = document.querySelectorAll('.schedule_values');
    const events = [];

    scheduleElements.forEach(element => {
        const event = {
            title: element.getAttribute('data-board-title'),
            start: element.getAttribute('data-schedule-start-date').split('T')[0], // 날짜만 추출
            end: element.getAttribute('data-schedule-end-date') ? element.getAttribute('data-schedule-end-date').split('T')[0] : null, // 종료 날짜가 있을 경우에만 추가
            classNo: parseInt(element.getAttribute('data-class-no'), 10),
            contents: element.getAttribute('data-board-contents'),
            location: '' // location 값이 없으므로 빈 문자열로 설정
        };
        events.push(event);
    });

    return events;
}
