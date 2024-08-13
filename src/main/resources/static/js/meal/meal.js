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
                    <h1 class="modal-title modal_header_title" id="mealDetailLabel">
                        ${moment(response.mealDate).format('yyyy년 M월 D일')} 식단표
                    </h1>
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

                            
                            <div class="modal_meal_img_box">
                                <img class="modal_meal_img" src="${detail.mealPic}" alt="식단 사진" />
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