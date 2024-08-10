$(document).ready(function () {
    let modifyForm = $('#modifyCommentForm');
    function initializeForm() {
        $('#modifiedComment').val(modifyForm.data('comment-content'));
    }
    initializeForm();

    // 수정 버튼 클릭 이벤트 리스너
    $('#saveBtn').on('click', function (event) {
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

                // 폼 데이터 수집
                let param = {
                    commentNo : modifyForm.data('comment-no'),
                    commentContent :$('#modifiedComment').val(),
                    isComment : true
                };

                console.log('param: ' + JSON.stringify(param));

                // AJAX 요청 URL
                let url = '/announce/comment/modifyOk';

                // AJAX 요청 함수 호출
                commonAjax(url, 'PUT', param);
            }
        });
    });
});

function afterSuccess(response,method) {
    console.log("comment modify")
    if(method === 'PUT' && response. comment)
        Swal.fire({
            title: " 완료",
            text: "창을 닫으면 이전 화면으로 돌아갑니다. (댓글)",
            icon: "success",
            customClass: {
                confirmButton: 'btn-ab btn-ab-swal'

            }

        }).then((result) => {let announceNo =$('#detail').data('announce-no');
            console.log("announceNo : {}", announceNo);
            window.location.href = window.location.origin + '/announce/user/'+announceNo;
        });
}
