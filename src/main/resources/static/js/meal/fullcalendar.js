let calendar;

let startDate = null;
let endDate = null;

const delimiter = "::";

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
            let mealNo = JSON.stringify(info.event.extendedProps.mealNo);

            if (classNames.includes('google-cal')) {
                return;
            }

            let param = {
                mealNo : mealNo,
                isDetail : true
            }
            // console.log(`param: ${JSON.stringify(param)}`);

            let url = `/meal/detail`;

            commonAjax(url, 'POST', param);

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

    $(document).on('hidden.bs.modal', '#mealDetail', function () {
        $('#mealDetail').remove();
    });

});

function afterSuccess(response) {
    // console.log(`response: ${response}`);
    // console.log(`response: ${JSON.stringify(response)}`);

    // 전체조회일 경우
    if (response.detail == null) {
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

    if (response.detail) {
        // console.log(`상세조회 모달 세팅..`);
        // console.log(`response: ${JSON.stringify(response)}`);

        let roleNo = $('#calendar').data('role-no');
        // console.log(`roleNo: ${roleNo}`);

        // 모달의 내용 세팅
        let modalDetailTag = `<div class="modal fade fixed-width-modal" id="mealDetail"
         tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable">
            <div class="modal-content">

                <div class="modal-header">
                    <h1 class="modal-title modal_header_title" id="mealDetailLabel"></h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>


                <div class="modal-body modal_body">

                    <div class="modal_meals_box">

`;

        // detail 수만큼 추가
        for (let detail of response.mealDetails) {
            // console.log(`detail: ${JSON.stringify(detail)}`);

            let menuNames = detail.mealMenu.replaceAll(delimiter, `<br>`);
            // console.log(`menuNames: ${menuNames}`);

            modalDetailTag += `<div class="modal_meal_item_box">

                            <div class="modal_meal_title_box">
                                <div class="modal_meal_title">${detail.mealTypeName}</div>
                            </div>


<!--                            <div class="modal_meal_img_box">-->
<!--                                <img class="modal_meal_img" src="http://via.placeholder.com/330x300">-->
<!--                            </div>-->
                            
                            <div class="modal_meal_img_box">
                                <img class="modal_meal_img" src="${detail.mealPic}">
                            </div>

                            <div class="modal_meal_menu_box">
                                <div class="modal_meal_menu">
                                    ${menuNames}
                                </div>
                            </div>

                        </div>

                    
`;
        }

        // admin/user에 따라 버튼 다르게 표시
        modalDetailTag += `</div>

                </div>


                <div class="modal-footer modal_meal_detail_footer">
                    <div class="modal_btns_box">

                `;

        if (roleNo <= 2) {
            modalDetailTag += `<a class="btn btn-ab modal_btn_box" href="/meal/admin/modify/${response.mealNo}" alt="수정">
                            <div class="modal_btn_text">수정</div>
                        </a>


                        <div class="btn btn-danger modal_btn_box">
                            <div class="modal_btn_text">삭제</div>
                        </div>

`
        }

        if (roleNo === 3) {
            modalDetailTag += `<div class="btn btn-ab modal_btn_box">
                            <div class="modal_btn_text" data-bs-dismiss="modal" aria-label="Close">닫기</div>
                        </div>`
        }

        modalDetailTag += `</div>
                </div>

            </div>
        </div>
    </div>`

        // 기존 html에 추가
        $('.calendar_box').after(modalDetailTag);

        // 모달 팝업
        $('#mealDetail').modal('show');

        // 이미지 로드 실패 시 placeholder로 대체
        $('.modal_meal_img').on('error', function () {
            // console.log("이미지 못읽음");
            $(this).attr('src', 'http://via.placeholder.com/330x300');
        });
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
