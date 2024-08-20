$(document).ready(function(){
    // Timepicker 초기화
    $('#time').timepicker({
        timeFormat: 'h:mm p',
        interval: 30,
        minTime: '12',
        maxTime: '18',
        defaultTime: '12',
        dynamic: false,
        dropdown: true,
        scrollbar: true
    });

    console.log("타임피커가 초기화되었습니다!!!!");

    $('#writeBtn').on('click', function(event) {
        event.preventDefault(); // 기본 폼 제출 방지
        // 유효성 검사와 데이터 준비
        const returnHomeData = {
            orderType: 1,
            runDate: $('input[name="date"]:checked').val(),
            orderSpecific: $('#orderSpecific').val(),
            rhTime: convertTo24HourFormat($('#time').val()),
            rhType: $('#type').val(),
            rhMainParentName: $('#mainName').val(),
            rhMainParentTel: $('#mainTel').val(),
            rhMinorParentName: $('#minorName').val(),
            rhMinorParentTel: $('#minorTel').val(),
        };

        // 검증 로직
        if (returnHomeData.rhType === '선택') {
            alert("귀가 방법 선택은 필수 사항입니다.");
            $('#type').focus();
            return false;
        }
        if (returnHomeData.rhMinorParentName.length === 0) {
            alert("비상 연락처는 필수로 입력해야 합니다.");
            $('#minorName').focus();
            return false;
        }
        if ((returnHomeData.rhMinorParentTel.length !== 10 && returnHomeData.rhMinorParentTel.length !== 11) || !/^\d+$/.test(returnHomeData.rhMinorParentTel)) {
            alert("잘못된 연락처입니다. 특수문자를 제외한 숫자만 입력해 주세요.");
            $('#minorTel').val('');
            $('#minorTel').focus();
            return false;
        }

        // AJAX 요청 보내기
        console.log("returnHomeData {}", returnHomeData);
        // console.log(`returnHomeData:${JSON.stringify(returnHomeData)}`);

        let url = '/returnhome/writeOk';
        commonAjax(url, 'POST', returnHomeData);
    });


    // 시간 포맷 변환 함수
    function convertTo24HourFormat(timeStr) {
        const [time, period] = timeStr.split(' ');
        let [hours, minutes] = time.split(':').map(Number);

        if (period === 'PM' && hours !== 12) {
            hours += 12;
        } else if (period === 'AM' && hours === 12) {
            hours = 0;
        }

        hours = hours.toString().padStart(2, '0');
        minutes = minutes.toString().padStart(2, '0');

        return `${hours}:${minutes}`;
    }
});




$(document).ready(function () {
    $('.deleteBtn').on('click', function () {
       console.log("삭제버튼 클릭됨");
        Swal.fire({
            title: "정말로 삭제하시겠습니까?",
            text: "삭제한 공지사항은 복구할 수 없습니다.",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#dc3545",
            confirmButtonText: "삭제",
            cancelButtonText: "취소"
        }).then((result) => {
            if (result.isConfirmed) {
                let orderNo = $(this).data('orderNo'); // 삭제할 항목의 boardNo를 가져옵니다.

                let param = {
                    orderNo: orderNo
                };

                console.log(`param: ${JSON.stringify(param)}`);

                let url = "/returnhome/delete";

                // AJAX 요청을 보내는 함수 호출
                commonAjax(url, 'DELETE', param);
            }
        });
    });
});

function afterSuccess(response,method) {
    console.log("returnHome_afterSuccess")

    if(method === 'POST'){
        Swal.fire({
            title: "등록 완료",
            text: "창을 닫으면 목록 화면으로 돌아갑니다.",
            icon: "success",
            customClass: {
                confirmButton: 'btn-ab btn-ab-swal'
            }
    }).then((result) => {
        window.location.href = '/returnhome/user/card'; // 성공 시 이동할 페이지
        });
    }


    if(method === 'DELETE'){
        Swal.fire({
            title: "삭제 완료",
            text: "창을 닫으면 목록 화면으로 돌아갑니다.",
            icon: "success",
            customClass: {
                confirmButton: 'btn-ab btn-ab-swal'
            }
        }).then((result) => {
            window.location.href = window.location.origin + 'returnhome/user/card';
        });
    }

}
