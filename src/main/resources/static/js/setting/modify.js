// $(document).ready(function() {
//
//     let modifyForm = $('#modifyForm');
//
//     // 폼 데이터에서 초기값을 가져와서 설정
//     function initializeForm() {
//         $('#title').val(modifyForm.data('board-title'));
//         $('#content').summernote('code', modifyForm.data('board-contents'));
//
//         // 문자열 '1' 또는 '0'을 기반으로 체크박스의 상태 설정
//         $('#primary').prop('checked', modifyForm.data('announce-primary'));
//         $('#comment').prop('checked', modifyForm.data('can-comment'));
//
//         // 디버깅을 위해 로그 출력
//     }
//
//     // 초기화 함수 호출
//     initializeForm();
//
//
//     $('#open').timepicker({
//         timeFormat: 'h:mm p',
//         interval: 10,
//         minTime: '6',
//         maxTime: '10',
//         defaultTime: '9',  // 기본 시간은 9로 설정
//         dynamic: false,
//         dropdown: true,
//         scrollbar: true
//     }).on('selectTime', function() {
//         var openTime = $(this).val(); // 선택된 시간 값
//         console.log('오픈 시간 : ' + openTime);
//     });
//
//     // 타임피커 초기화 후 value 설정
//     var openTimeFromServer = $('#open').attr('th:value');
//     if (openTimeFromServer) {
//         $('#open').timepicker('setTime', openTimeFromServer);
//     }
//
//     // 'close' 타임피커 초기화
//     $('#close').timepicker({
//         timeFormat: 'h:mm p',
//         interval: 10,
//         minTime: '13:00pm',
//         maxTime: '22:00pm',
//         defaultTime: '18:00pm',  // 기본 시간은 18로 설정
//         dynamic: false,
//         dropdown: true,
//         scrollbar: true
//     }).on('selectTime', function() {
//         var closeTime = $(this).val(); // 선택된 시간 값
//         console.log('하원 시간: ' + closeTime);
//     });
//
//     // 타임피커 초기화 후 value 설정
//     var closeTimeFromServer = $('#close').attr('th:value');
//     if (closeTimeFromServer) {
//         $('#close').timepicker('setTime', closeTimeFromServer);
//     }
//
//     $('#addBtn').on('click', function(event) {
//         console.log('저장버튼 클릭됨');
//         event.preventDefault(); // 기본 폼 제출 방지
//
//         // 시간 문자열에서 AM/PM 제거 및 24시간 형식으로 변환
//         function convertTo24Hour(time) {
//             let [hours, minutes, period] = time.split(/[: ]/);
//
//             // AM/PM 변환
//             if (period === 'PM' && hours !== '12') {
//                 hours = parseInt(hours, 10) + 12;
//             } else if (period === 'AM' && hours === '12') {
//                 hours = '00';
//             }
//
//             // 두 자리로 포맷팅
//             if (hours.length === 1) {
//                 hours = '0' + hours;
//             }
//
//             // 두 자리로 포맷팅
//             if (minutes.length === 1) {
//                 minutes = '0' + minutes;
//             }
//
//             return `${hours}:${minutes}`;
//         }
//
//         const kinderPostCode = $('#sample6_postcode').val();
//         const addr = $('#sample6_address').val();
//         const detailAddrRaw = $('#sample6_detailAddress').val();
//         const detailAddr = detailAddrRaw ? ' ' + detailAddrRaw : ''; // 공백 추가
//
//         const kinderNameRaw = $('#kinderName').val().trim(); // 공백 제거
//         const kinderName = kinderNameRaw.replace(/\s+/g, ''); // 모든 공백 제거
//
//         const locNo = $('#locNo').val();
//         const midNo = $('#midNo').val();
//         const endNo = $('#endNo').val();
//         const principalName = $('#principalName').text();
//
//         const openTimeRaw = $('#open').val();
//         const closeTimeRaw = $('#close').val();
//
//         const kinderOpenTime = convertTo24Hour(openTimeRaw); // 24시간 형식으로 변환
//         const kinderCloseTime = convertTo24Hour(closeTimeRaw); // 24시간 형식으로 변환
//
//         const sggList = $('#sample6_sigunguCode').val();
//         const sidoList = sggList.substring(0, 2);
//
//         const id = $('#principalId').data('id');
//         // 값 체크
//         if (kinderPostCode.length === 0) {
//             console.log("우편번호 입력 누락");
//             alert("우편번호를 입력해주세요.");
//             $('#sample6_postcode').focus();
//             return false;
//         }
//         if (detailAddr.length === 0) {
//             console.log("상세 주소 입력 누락");
//             if (!confirm("상세 주소 입력이 되지 않았습니다. 이대로 진행하시겠습니까?")) {
//                 $('#sample6_detailAddress').focus();
//                 return false;
//             }
//         }
//         if (kinderName.length === 0) {
//             console.log("유치원 이름 입력 누락");
//             alert("유치원 이름을 입력해주세요.");
//             $('#kinderName').focus();
//             return false;
//         }
//         if (/[a-zA-Z]/.test(kinderName)) {
//             console.log("유치원 이름 형식 오류");
//             alert("유치원 이름은 한글만 입력할 수 있습니다.");
//             $('#kinderName').focus();
//             return false;
//         }
//
//         // 전화번호 형식 체크
//         if (!/^\d+$/.test(midNo) || !/^\d+$/.test(endNo)) {
//             console.log("전화번호 입력 오류");
//             alert("전화번호는 숫자만 입력할 수 있습니다.");
//             if (!/^\d+$/.test(midNo)) {
//                 $('#midNo').focus();
//                 return false;
//             }
//             if (!/^\d+$/.test(endNo)) {
//                 $('#endNo').focus();
//                 return false;
//             }
//         }
//         if (midNo.length === 0) {
//             console.log("미들넘버 입력 누락");
//             alert("전화번호의 중간 번호를 입력해주세요.");
//             $('#midNo').focus();
//             return false;
//         }
//         if (midNo.length !== 3 && midNo.length !== 4) {
//             console.log("미들넘버 길이 오류");
//             alert("올바른 형식의 번호를 입력해주세요.");
//             $('#midNo').focus();
//             return false;
//         }
//         if (endNo.length === 0) {
//             console.log("엔드넘버 입력 누락");
//             alert("전화번호의 끝 번호를 입력해주세요.");
//             $('#endNo').focus();
//             return false;
//         }
//         if (endNo.length !== 4) {
//             console.log("엔드넘버 길이 오류");
//             alert("올바른 형식의 번호를 입력해주세요.");
//             $('#endNo').focus();
//             return false;
//         }
//
//         const kinderData = {
//             kinderPostCode: kinderPostCode,
//             kinderAddr: addr + detailAddr,
//             kinderName: kinderName,
//             kinderTel: locNo + midNo + endNo,
//             principalName: principalName,
//             kinderOpenTime: kinderOpenTime,
//             kinderCloseTime: kinderCloseTime,
//             sggList:sggList,
//             sidoList:sidoList,
//             id:id
//         };
//
//         console.log('kinderData:', kinderData); // 객체 출력으로 데이터 확인
//         let url = '/setting/addOk';
//
//         // commonAjax 호출 시 afterSuccess를 인자로 전달
//         commonAjax(url, 'POST', kinderData, afterSuccess);
//     });
//
//     // 주소 검색 함수 전역 범위로 이동
//     window.sample6_execDaumPostcode = function() {
//         new daum.Postcode({
//             oncomplete: function(data) {
//                 var addr = '';
//                 var extraAddr = '';
//
//                 if (data.userSelectedType === 'R') {
//                     addr = data.roadAddress;
//                 } else {
//                     addr = data.jibunAddress;
//                 }
//
//                 if (data.userSelectedType === 'R') {
//                     if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
//                         extraAddr += data.bname;
//                     }
//                     if (data.buildingName !== '' && data.apartment === 'Y') {
//                         extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
//                     }
//                     if (extraAddr !== '') {
//                         extraAddr = ' (' + extraAddr + ')';
//                     }
//
//                 } else {
//                     document.getElementById("sample6_extraAddress").value = '';
//                 }
//
//                 document.getElementById('sample6_postcode').value = data.zonecode;
//                 document.getElementById("sample6_address").value = addr;
//                 document.getElementById("sample6_detailAddress").focus();
//
//                 // sigunguCode를 폼에 추가
//                 document.getElementById('sample6_sigunguCode').value = data.sigunguCode || ''; // sigunguCode가 있을 때만 설정
//             }
//         }).open();
//     };
// });
//
//
// // afterSuccess 정의 및 호출
// function afterSuccess(response) {
//     console.log("유치원 수정");
//     Swal.fire({
//         title: " 완료",
//         text: "창을 닫으면 메인 화면으로 돌아갑니다.",
//         icon: "success",
//         customClass: {
//             confirmButton: 'btn-ab btn-ab-swal'
//         }
//     }).then((result) => {
//         window.location.href = '/main/admin'; // 성공 시 이동할 페이지
//     });
// }

$(document).ready(function() {
    $('#open').timepicker({
        timeFormat: 'h:mm p',
        interval: 10,
        minTime: '6',
        maxTime: '10',
        dynamic: false,
        dropdown: true,
        scrollbar: true
    }).on('selectTime', function() {
        var openTime = $(this).val();
        console.log('오픈 시간 : ' + openTime);
    });

    $('#close').timepicker({
        timeFormat: 'h:mm p',
        interval: 10,
        minTime: '13:00pm',
        maxTime: '22:00pm',
        dynamic: false,
        dropdown: true,
        scrollbar: true
    }).on('selectTime', function() {
        var closeTime = $(this).val();
        console.log('하원 시간: ' + closeTime);
    });

    function convertTo12HourFormat(time24) {
        var [hours, minutes] = time24.split(':');
        var period = 'AM';

        hours = parseInt(hours, 10);
        if (hours >= 12) {
            period = 'PM';
            if (hours > 12) {
                hours -= 12;
            }
        } else if (hours === 0) {
            hours = 12;
        }

        hours = hours < 10 ? '0' + hours : hours;
        minutes = minutes < 10 ? '0' + minutes : minutes;

        return `${hours}:${minutes} ${period}`; // 공백 추가
    }

    // Open time
    var openTimeFromServer = $('#open').attr('data-time');
    if (openTimeFromServer) {
        var formattedOpenTime = convertTo12HourFormat(openTimeFromServer);
        $('#open').val(formattedOpenTime); // Timepicker의 값을 수동으로 설정
        $('#open').timepicker('setTime', formattedOpenTime); // Timepicker 업데이트
    }

    // Close time
    var closeTimeFromServer = $('#close').attr('data-time');
    if (closeTimeFromServer) {
        var formattedCloseTime = convertTo12HourFormat(closeTimeFromServer);
        $('#close').val(formattedCloseTime); // Timepicker의 값을 수동으로 설정
        $('#close').timepicker('setTime', formattedCloseTime); // Timepicker 업데이트
    }
});
