$(document).ready(function() {
    let calendarEl = document.getElementById('calendar');

    let calendar = new FullCalendar.Calendar(calendarEl, {
        themeSystem: 'bootstrap5',
        headerToolbar: {
            left: '',
            center: 'prev title today next',
            right: ''
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
        eventClick: function (info) {
            let date = new Date(info.event.start);
            date.setHours(date.getHours() + 9);  // 9시간을 추가(KST)
            let formattedDate = date.toISOString().split('T')[0];
            console.log("formattedDate: " + formattedDate);

            // // 상세조회에 필요한 값들 세팅
            // $("#meal_date").val(formattedDate);
            // $("#kinder_no").val("${kinderNo}");
            // // event 객체 생성 시 설정한 사용자 정의 속성 불러오기
            // $("#meal_no_for_detail").val(info.event.extendedProps.mealNo);
            //
            // $("#detailForm").submit();

            // 모달의 내용을 설정합니다.
            $('#mealDetailLabel').text("2024년 07월 14일 식단표");
            console.log(info.event.title);

            // 모달 팝업
            $('#mealDetail').modal('show');

        },
        locale: 'ko',
        datesSet: function (dateInfo) {
            // 달력에 표시 중인 달 확인
            let currentStartDate = dateInfo.view.currentStart;
            let currentEndDate = dateInfo.view.currentEnd;
            let currentMonth = currentStartDate.getMonth() + 1;
            console.log("현재 표시중인 시작일: " + currentStartDate);
            console.log("현재 표시중인 말일: " + currentEndDate);
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

            // 현재 표시 중인 달 기준으로
        },
        events: [
            {
                title: '식단 조회하기',
                start: '2024-07-14',
                mealNo: 0
            }
        ]
    });

    calendar.render();

});