$(document).ready(function () {
    // Summernote 에디터 초기화
    $('.summernote').summernote({
        height: 500,
        lang: 'ko-KR'
    });

    // 폼 데이터 초기화
    let modifyForm = $('#modifyForm');

    // 폼 데이터에서 초기값을 가져와서 설정
    function initializeForm() {
        $('#title').val(modifyForm.data('board-title'));
        $('#content').summernote('code', modifyForm.data('board-contents'));

        // 데이터 값을 문자열 비교로 설정
        $('#primary').prop('checked', modifyForm.data('announce-primary') === '1');
        $('#comment').prop('checked', modifyForm.data('can-comment') === '1');

        // 디버깅을 위해 로그 출력
        console.log("Primary checked: " + $('#primary').prop('checked')); // true 또는 false
        console.log("Comment checked: " + $('#comment').prop('checked')); // true 또는 false
    }
    // 초기화 함수 호출
    initializeForm();

    // 수정 버튼 클릭 이벤트 리스너
    $('#modifyBtn').on('click', function (event) {
        console.log("수정 버튼 클릭");
        event.preventDefault(); // 기본 폼 제출 방지

        Swal.fire({
            title: "정말로 수정하시겠습니까?",
            showCancelButton: true,
            confirmButtonText: "네",
            cancelButtonText: "아니오",
            customClass: {
                confirmButton: 'btn-ab btn-ab-swal'
            }
        }).then((result) => {
            if (result.isConfirmed) {
                // 폼 데이터 설정 함수 호출
                setData(modifyForm);

                // 폼 데이터 수집
                let param = {
                    boardNo: modifyForm.data('board-no'),
                    announceNo: modifyForm.data('announce-no'),
                    boardTitle: modifyForm.data('board-title'),
                    boardContents: modifyForm.data('board-contents'),
                    announcePrimary: modifyForm.data('announce-primary'),
                    canComment: modifyForm.data('can-comment'),
                    announceType: modifyForm.data('announce-type')
                };

                console.log('param: ' + JSON.stringify(param));

                // AJAX 요청 URL
                let url = '/announce/modifyOk';

                // AJAX 요청 함수 호출
                commonAjax(url, 'PUT', param);
            }
        });
    });
});

function afterSuccess(response) {
    Swal.fire({
        title: "수정 완료",
        text: "창을 닫으면 상세 화면으로 돌아갑니다.",
        icon: "success",
        customClass: {
            confirmButton: 'btn-ab btn-ab-swal'
        }
    }).then((result) => {
        let announceNo = $('#modifyForm').data('announce-no');
        window.location.href = window.location.origin + '/announce/admin/' + announceNo;
    });
}

function setBoardContent(selector) {
    selector.data('board-contents', $('.summernote').summernote('code'));
}

function setData(modifyForm) {
    // 제목 설정
    modifyForm.data('board-title', $('#title').val());

    // 내용 설정
    setBoardContent(modifyForm);

    // 중요 공지 설정
    modifyForm.data('announce-primary', $('#primary').prop('checked') ? '1' : '0');

    // 댓글 허용 설정
    modifyForm.data('can-comment', $('#comment').prop('checked') ? '1' : '0');

    // 말머리 설정
    modifyForm.data('announce-type', $('.category').val());

    // 디버깅을 위해 로그 출력
    console.log("Set Data - Primary: " + modifyForm.data('announce-primary'));
    console.log("Set Data - Comment: " + modifyForm.data('can-comment'));
}
    //토글버튼 로그 출력
    $(document).ready(function () {
        $('#primary').on('click', function () {
            console.log('Primary checked: ' + $(this).prop('checked')?'1': '0');
        });
    });