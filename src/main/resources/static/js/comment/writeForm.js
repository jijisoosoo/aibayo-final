$(document).ready(function (){
    $('#writeBtn').on('click', function (event) {
        console.log("작성버튼 클릭");
        event.preventDefault(); // 기본 폼 제출 방지

        console.log("Form submitted");
        const commentContent= $('#commentContent').val();
        const commentWriter = 2; //나중에 실제값으로 받아와야함
        const kinderNo = 1; //나중에 실제값으로 받아와야함
        const announceNo = $('#detail').data('announce-no');
        const boardNo= $('#boardNo').val();
        const commentClass = 0;
        const commentDeleteFlag = '0';
        const invisibleFlag = '0';


        // 데이터 객체 생성
        const commentData  = {
            commentContent : commentContent,
            commentWriter : commentWriter,
            kinderNo : kinderNo,
            announceNo: announceNo,
            boardNo : boardNo,
            commentClass : commentClass,
            commentDeleteFlag : commentDeleteFlag,
            invisibleFlag : invisibleFlag,

        };

        console.log("commentData: ", commentData);

        // 서버로 데이터 전송
        fetch('/announce/comment/writeOk',{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(commentData),
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                alert('댓글이 작성되었습니다.');
                window.location.href = '/announce/user/'+announceNo; // 성공 시 이동할 페이지
            })
            .catch((error) => {
                console.error('Error:', error);
                alert('댓글 작성 중 오류가 발생했습니다.');
            });
    });
    $('.deleteComment').on('click', function (event) {
        console.log("댓글 삭제 버튼 클릭");
            Swal.fire({
                title: "정말로 삭제하시겠습니까?",
                text: "삭제한 댓글은 복구할 수 없습니다.",
                icon: "warning",
                showCancelButton: true,
                confirmButtonColor: "#dc3545",
                confirmButtonText: "삭제",
                cancelButtonText: "취소"
            }).then((result) => {
                if (result.isConfirmed) {
                    let commentNo = $(this).closest('.AAA').find('input').val(); // 삭제할 항목의 comment 가져옵니다.

                    let param = {
                        commentNo: commentNo
                    };

                    console.log(`param: ${JSON.stringify(param)}`);

                    let url = "/announce/comment/delete";

                    // AJAX 요청을 보내는 함수 호출
                    commonAjax(url, 'DELETE', param);
                }
            });
        });
});

function afterSuccess(response,method) {

    if(method === 'DELETE' && response.invisibleFlag === '1')
        Swal.fire({
            title: "삭제 완료",
            text: "창을 닫으면 이전 화면으로 돌아갑니다. (댓글)",
            icon: "success",
            customClass: {
                confirmButton: 'btn-ab btn-ab-swal'

            }

        }).then((result) => {
            let announceNo =$('#detail').data('announce-no');
            console.log("announceNo : {}", announceNo);
            window.location.href = window.location.origin + '/announce/user/'+announceNo;
        });
}

