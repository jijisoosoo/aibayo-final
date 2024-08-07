let calendar;
let events = [];

let startDate = null;
let endDate = null;

$(document).ready(function() {
    let calendarEl = document.getElementById('calendar');

    calendar = new FullCalendar.Calendar(calendarEl, {
        googleCalendarApiKey: 'AIzaSyCP6SR1SXMeU1HuXRVzKjMWpzZmlwCBvfE',
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
        }
    });

    calendar.render();

});

function afterSuccess(response) {
    // console.log(`response: ${JSON.stringify(response)}`);

    // api 연동하여 해당 달의 공휴일 불러오기


    let title = "식단 조회하기";


    $.each(response, function (index, meal) {
        events.push({
            title : title,
            start : meal.mealDate,
            mealNo : meal.mealNo
        });

    });

    // console.log(`events: ${JSON.stringify(events)}`);
    // calendar.removeAllEvents();

    let calendarId = "8ba78b243a9cc492f02ecf15ce54f7db5f2a554d4ccabefcdcc799b7292b5611@group.calendar.google.com"
    let url=`https://www.googleapis.com/calendar/v3/calendars/${calendarId}/events`

    $.ajax({
        url: url,
        data: {
            'timeMin': startDate,
            'timeMax': endDate,
            'singleEvents': true,
            // 'orderBy': 'startTime',
        },
        success: function (response) {
            console.log(`api response: ${response}`);
        }
    });


    // calendar.addEventSource(events);
}

function loadEvents(dateInfo) {
    // 달력에 표시 중인 달 확인
    let currentStartDate = dateInfo.view.currentStart;
    let currentEndDate = dateInfo.view.currentEnd;
    // let currentMonth = currentStartDate.getMonth() + 1;
    // console.log("현재 표시중인 시작일: " + currentStartDate);
    // console.log("현재 표시중인 말일: " + currentEndDate);
    // console.log("현재 표시중인 달: " + currentMonth);

    startDate = moment(currentStartDate).format('YYYY-MM-DD');
    endDate = moment(currentEndDate).subtract(1, 'days').format('YYYY-MM-DD');

    let url = "/meal/getByMonth";

    let param = {
        startDate : startDate,
        endDate : endDate,
        kinderNo: $('#calendar').data('kinder-no')
    }
    console.log(`param: ${JSON.stringify(param)}`);

    commonAjax(url, 'POST', param);
}


// function fetchHolidays(startDate, endDate) {
//     return new Promise(function(resolve, reject) {
//         $.ajax({
//             url: '/calendars/ko.south_korea#holiday@group.v.calendar.google.com/events',
//             data: {
//                 'timeMin': startDate,
//                 'timeMax': endDate,
//                 'singleEvents': true,
//                 // 'orderBy': 'startTime',
//                 'calendarId': 'AIzaSyCP6SR1SXMeU1HuXRVzKjMWpzZmlwCBvfE'
//             },
//             success: function(response) {
//                 resolve(response.items);
//             },
//             error: function(error) {
//                 reject(error);
//             }
//         });
//     });
// }

// function initClient() {
//     gapi.client.init({
//         'apiKey': 'AIzaSyCP6SR1SXMeU1HuXRVzKjMWpzZmlwCBvfE'
//     }).then(function() {
//
//         fetchHolidays(startDate, endDate).then(function(returnedEvents) {
//             // timeMin = startDate.toISOString();
//             // timeMax = endDate.toISOString();
//             console.log('Updated timeMin:', startDate);
//             console.log('Updated timeMax:', endDate);
//
//             // FullCalendar에 이벤트 추가
//             events.add(...returnedEvents);
//         });
//     }).catch(function(error) {
//         console.log('Error initializing Google API client: ', error);
//     });
// }