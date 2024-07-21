function findByRegDate(parameter) {
    console.log('dateText: ' + parameter.dateText);

    $.ajax({
        url: '/notepad/user/searchDate', // 서버에서 데이터를 가져올 URL 지정
        type: 'POST',
        data:  JSON.stringify({
            kidNo : parameter.kidNo,
            boardRegDate: parameter.dateText
        }),
        contentType: 'application/json',
        success: function(response) {
            // 성공적으로 데이터를 받으면 처리
            // 받은 데이터를 HTML로 변환하여 특정 class 덮어쓰기
            $('.class_90').replaceWith($(response).find('.class_90'));
            $('.pagination').replaceWith($(response).find('.pagination'));
        },
        error: function(xhr, status, error) {
            // 오류가 발생하면 처리합니다.
            console.error("AJAX 요청 오류:", status, error);
        }
    });

}
