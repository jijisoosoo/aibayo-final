$(document).ready(function() {
    $('.summernote').summernote({
        height: 300,
        lang: 'ko-KR' // 한국어 설정
    });

    $('.summernote').summernote('code', '이것은 내용<br>오늘의 알림장 내용<br>원생 개인에 대한 정보<br>오늘 한 활동에 대한 내용')
});