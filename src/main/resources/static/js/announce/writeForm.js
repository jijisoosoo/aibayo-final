$(document).ready(function () {
    $('.summernote').summernote({
        height: 500,
        lang: 'ko-KR'
    });

    $('input[type="radio"]').change(function () {
        setDisplay();
    });

    $('.form-select').change(function () {
        updateAnnWriteScope();
    });

    $('#writeBtn').on('click', function (event) {
        console.log("작성버튼 클릭");
        event.preventDefault(); // 기본 폼 제출 방지

        console.log("Form submitted");

        const announceType = $('select[name="announceType"]').val();
        const title = $('#title').val();
        const content = $('#content').val();
        const canComment = $('#comment').is(':checked');
        console.log("canComment: " + canComment);
        const isPrimary = $('#primary').is(':checked');
        console.log("isPrimary: " + isPrimary);
        const boardType = 1;
        const writer = 2; //나중에 실제값으로 받아와야함
        const kinderNo = 1; //나중에 실제값으로 받아와야함

        // 데이터 객체 생성
        const announceData = {
            announceType: parseInt(announceType),
            boardTitle: title,
            boardContents: content,
            canComment: canComment ? "1" : "0",
            announcePrimary: isPrimary ? "1" : "0",
            boardType: boardType,
            writer: writer,
            kinderNo: kinderNo
        };

        console.log("announceData: ", announceData);

        // 서버로 데이터 전송
        fetch('/announce/writeOk', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(announceData),
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                alert('공지사항이 작성되었습니다.');
                window.location.href = '/announce/admin/card'; // 성공 시 이동할 페이지
            })
            .catch((error) => {
                console.error('Error:', error);
                alert('공지사항 작성 중 오류가 발생했습니다.');
            });
    });
});