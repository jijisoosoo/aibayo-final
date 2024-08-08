let calendar;

let startDate = null;
let endDate = null;

$(document).ready(function() {
    let calendarEl = document.getElementById('calendar');

    calendar = new FullCalendar.Calendar(calendarEl, {
        googleCalendarApiKey: 'AIzaSyCP6SR1SXMeU1HuXRVzKjMWpzZmlwCBvfE',
        events: {
            googleCalendarId: 'ko.south_korea#holiday@group.v.calendar.google.com',
            backgroundColor: 'transparent',
            color: 'transparent',
            textColor: 'red',
            className: 'google-cal',
            eventDataTransform: function(eventData) {
                // URL 속성 제거
                delete eventData.url;
                return eventData;
            }
        },
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
            let classNames = JSON.stringify(info.el.fcSeg.eventRange.ui.classNames);

            if (classNames.includes('google-cal')) {
                return;
            }

            // let date = new Date(info.event.start);
            // date.setHours(date.getHours() + 9);  // 9시간을 추가(KST)
            // let formattedDate = date.toISOString().split('T')[0];
            // console.log("formattedDate: " + formattedDate);

            // // 상세조회에 필요한 값들 세팅
            // $("#meal_date").val(formattedDate);
            // $("#kinder_no").val("${kinderNo}");
            // // event 객체 생성 시 설정한 사용자 정의 속성 불러오기
            // $("#meal_no_for_detail").val(info.event.extendedProps.mealNo);
            //
            // $("#detailForm").submit();

            // 모달의 내용 세팅
            $('#mealDetailLabel').text("2024년 07월 14일 식단표");
            console.log(info.event.title);

            // 모달 팝업
            $('#mealDetail').modal('show');

        },
        locale: 'ko',
        datesSet: function (dateInfo) {
            // datesRender 이벤트가 발생할 때 버튼 스타일을 변경하고 보이도록 설정
            $('.fc-toolbar button').each(function() {
                $(this).removeClass('btn-primary')
                    .addClass('btn-ab');
            });

            // 'dayGridMonth' 버튼을 비활성화
            let dayGridMonthButton = document.querySelector('.fc-dayGridMonth-button');
            if (dayGridMonthButton) {
                dayGridMonthButton.classList.add('disabled');
            }

            // 현재 표시 중인 달 기준으로 식단표 목록 조회하여 event에 추가
            loadEvents(dateInfo);

            //
        },
        eventOrder: "className,-start,-id",
        loading: function (isLoading) {
            if (isLoading) {
                $('#calendar').addClass('loading-cal');
                $('#loading-spinner').show();
            } else {
                $('#loading-spinner').hide();
                $('#calendar').removeClass('loading-cal');
            }
        },
        eventDidMount: function(info) {
            let classNames = JSON.stringify(info.el.fcSeg.eventRange.ui.classNames);
            // console.log(`info: ${JSON.stringify(info)}`);
            // console.log(`info.el.fcSeg.eventRange.ui.classNames: ${JSON.stringify(classNames)}`);

            // console.log(`className includes 'google-cal' ? ${classNames.includes('google-cal')}`);
            if (classNames.includes('google-cal')) {
                let aTag = info.el.querySelector('a');
                if (aTag) {
                    aTag.href = 'javascript:void(0);';  // href 속성을 무효화
                    aTag.onclick = function(e) { e.preventDefault(); }; // 클릭 이벤트를 무효화
                }
            }

            // console.log(`info.event: ${JSON.stringify(info.event)}`);
            // console.log(`info.event.url: ${JSON.stringify(info.event.url)}`);
            // console.log(`info.event.extendedProps.mealNo: ${JSON.stringify(info.event.extendedProps.mealNo)}`);
        }
    });

    calendar.render();

});

function afterSuccess(response) {
    // 전체조회일 경우
    if (response.isDetail == null) {
        // console.log(`response: ${JSON.stringify(response)}`);
        calendar.removeAllEvents();

        let events = [];
        let title = "식단 조회하기";


        $.each(response, function (index, meal) {
            events.push({
                title: title,
                start: meal.mealDate,
                mealNo: meal.mealNo
            });

        });

        // console.log(`events: ${JSON.stringify(events)}`);
        calendar.addEventSource(events);
    }
}

function loadEvents(dateInfo) {
    // console.log(`dateInfo: ${JSON.stringify(dateInfo)}`);
    // console.log(`dateInfo.view: ${JSON.stringify(dateInfo.view)}`);
    // console.log(`dateInfo.view.activeStart: ${JSON.stringify(dateInfo.view.activeStart)}`)
    // console.log(`dateInfo.view.activeEnd: ${JSON.stringify(dateInfo.view.activeEnd)}`)

    // 달력에 표시 중인 달 확인
    let activeStartDate = dateInfo.view.activeStart;
    let activeEndDate = dateInfo.view.activeEnd;

    // let currentStartDate = dateInfo.view.currentStart;
    // let currentEndDate = dateInfo.view.currentEnd;
    // let currentMonth = currentStartDate.getMonth() + 1;
    // console.log("현재 표시중인 시작일: " + currentStartDate);
    // console.log("현재 표시중인 말일: " + currentEndDate);
    // console.log("현재 표시중인 달: " + currentMonth);

    startDate = moment(activeStartDate).format('YYYY-MM-DD');
    endDate = moment(activeEndDate).subtract(1, 'd').format('YYYY-MM-DD');

    let url = "/meal/getByMonth";

    let param = {
        startDate : startDate,
        endDate : endDate,
        kinderNo: $('#calendar').data('kinder-no')
    }
    // console.log(`param: ${JSON.stringify(param)}`);

    commonAjax(url, 'POST', param);
}
