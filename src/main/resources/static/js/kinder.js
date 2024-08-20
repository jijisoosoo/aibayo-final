$(document).ready(function() {
    console.log('kinder.js');
    $('#selectkinder').on('change', function () {

        let kinderNo = $('#selectkinder').val();

        let param = {
            kinderNo : kinderNo
        };
    });

    let url = '/kinder/list';
    commonAjax(url, 'GET');

});

// afterSuccess 정의 및 호출
function afterSuccess(response) {
    console.log(`response : ${JSON.stringify(response)}`)
    for(let selectkinder of JSON.stringify(response) ){
        console.log(`selectkinder : ${selectkinder}`);
        let tag =
            ` <option th:each="kinders : ${allKinder}"
                th:object="${kinders}" th:value="*{kinderNo}"
                th:text="*{kinderName}">유치원 이름</option>`


    }




    console.log(`response:${JSON.stringify(response)}`)

}
