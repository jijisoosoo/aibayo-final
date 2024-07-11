$(document).ready(function () {
    $('.summernote').summernote({
        height: 500,
        // 학원가서 사이즈 조절하기
        lang: 'ko-KR'
    });

    $('input[type="radio"]').change(function () {
        setDisplay();
    });

    $('.form-select').change(function () {
        updateAnnWriteScope();
    });
});
