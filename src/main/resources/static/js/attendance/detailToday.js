// $(document).ready(function() {
//
//     $('#classSelect').change(function() {
//         var selectedClassNo = $(this).val();
//
//         $.ajax({
//             type: 'POST',
//             url: '/attendance/getKidAttendance',
//             data: { classNo: selectedClassNo },
//             success: function(response) {
//                 $('#studentList').empty();
//
//                 response.forEach(function(attendance) {
//                     console.log("kidDrop:", attendance.kidDrop);
//                     console.log("kidPickup:", attendance.kidPickup);
//
//                     var formattedKidDrop = formatTimeToKoreanStyle(attendance.kidDrop);
//                     var formattedKidPickup = formatTimeToKoreanStyle(attendance.kidPickup);
//
//                     var row = '<tr data-kid-no="' + attendance.kidNo + '">' +
//                         '<td>' + attendance.kidName + '</td>' +
//                         '<td>' + attendance.attendanceStatus + '</td>' +
//                         '<td>' + formattedKidDrop + '</td>' +
//                         '<td>' + formattedKidPickup + '</td>' +
//                         '<td>' + attendance.note + '</td>' +
//                         '</tr>';
//
//                     $('#studentList').append(row);
//                 });
//             },
//             error: function(xhr, status, error) {
//                 console.error('Error:', error);
//             }
//         });
//     });
//
//
//     $('#attendanceStatus').on('change', function() {
//         var status = $(this).val();
//         if (status === '결석') {
//             $('#kidDrop, #kidPickup').prop('disabled', true).val(''); // Disable fields and clear value
//         } else {
//             $('#kidDrop, #kidPickup').prop('disabled', false); // Enable fields
//         }
//     });
//
//
//     $('tr[data-kid-no]').on('click', function() {
//         var row = $(this); // 현재 클릭된 행
//         var kidNo = row.data('kid-no'); // data-kid-no 속성에서 아동 번호 가져옴
//         var kidDrop = row.find('td:nth-child(2)').text().trim(); // 두 번째 열에서 등원 시간 가져옴
//         var kidPickup = row.find('td:nth-child(3)').text().trim(); // 세 번째 열에서 하원 시간 가져옴
//         var note = row.find('td:nth-child(4)').text().trim(); // 네 번째 열에서 비고 가져옴
//
//         // 모달 창에 값을 설정
//         $('#updateModal #kidNo').val(kidNo);
//         $('#updateModal #kidDrop').val(kidDrop);
//         $('#updateModal #kidPickup').val(kidPickup);
//         $('#updateModal #note').val(note);
//
//         // 모달 창 표시
//         var myModal = new bootstrap.Modal(document.getElementById('updateModal'));
//         myModal.show();
//     });
//
//     // Remove the existing click event on the anchor tag
//     $('a.attendance-update-one').off('click');
//
//     // Handle apply update button click
//     $('#applyUpdate').on('click', function() {
//         $('#updateForm').submit();
//     });
//
//     // Handle form submission
//     $('#updateForm').on('submit', function(e) {
//         e.preventDefault();
//
//         var formData = new FormData(this); // Create form data object
//
//         formData.forEach((value, key) => {
//             console.log('formdata / ' + key + ": " + value);
//         });
//
//         const currentUrl = new URL(window.location.href);
//         const classNo = currentUrl.searchParams.get('classNo'); // Get classNo from current URL
//
//         // Ajax request
//         $.ajax({
//             type: 'POST',
//             url: './updateAttendanceOne?kidNo=' + formData.get('kidNo') +
//                 '&attendanceStatus=' + formData.get('attendanceStatus') +
//                 '&excusedAbsence=' + formData.get('excusedAbsence') +
//                 '&kidDrop=' + formData.get('kidDrop') +
//                 '&kidPickup=' + formData.get('kidPickup') +
//                 '&note=' + formData.get('note') +
//                 '&classNo=' + classNo,
//             data: formData,
//             processData: false,
//             contentType: false,
//             success: function(response) {
//                 // On success, hide modal and reload page
//                 var myModal = bootstrap.Modal.getInstance(document.getElementById('updateModal'));
//                 myModal.hide();
//                 location.reload();
//             },
//             error: function(xhr, status, error) {
//                 // On error, log to console and show alert
//                 console.error(xhr);
//                 console.error(status);
//                 console.error(error);
//                 Swal.fire({
//                     icon: 'warning',
//                     title: '출석부 수정 실패',
//                     text: '반을 선택해 주세요.',
//                 });
//             }
//         });
//     });
//
//     // Initialize DataTable
//     new DataTable('#attendanceTable', {
//         info: false,
//         ordering: false,
//         paging: false,
//         searching: false
//     });
//
//
//     $('#writeBtn').click(function(event) {
//         event.preventDefault(); // 기본 링크 동작을 막음
//
//         // 선택된 반 번호를 가져옴
//         var selectedClassNo = $('#classSelect').val();
//         console.log("선택된 classNo: " + selectedClassNo);
//
//         if (selectedClassNo) {
//             // 선택된 classNo를 URL에 포함하여 페이지 이동
//             window.location.href = '/attendance/admin/write/' + selectedClassNo;
//         } else {
//             // alert("반을 선택해 주세요.");
//             Swal.fire({
//                 icon: 'warning',
//                 title: '반을 선택하세요',
//
//             });
//         }
//     });
//
// });
//
//
// function formatTimeToKoreanStyle(dateTimeString) {
//     // dateTimeString이 유효하지 않으면 빈 문자열 반환
//     if (!dateTimeString || typeof dateTimeString !== 'string') {
//         return '';
//     }
//
//     // '2024-08-14T16:58:00' 형식에서 시간 부분만 추출
//     var timePart = dateTimeString.split('T')[1]; // '16:58:00' 부분
//     var timeParts = timePart.split(':'); // ['16', '58', '00']
//
//     if (timeParts.length < 2) {
//         return '';
//     }
//
//     var hours = parseInt(timeParts[0], 10); // 16
//     var minutes = timeParts[1]; // 58
//
//     return hours + '시 ' + minutes + '분';
// }

$(document).ready(function() {

    // 반 선택시 데이터 가져오기
    $('#classSelect').change(function() {
        var selectedClassNo = $(this).val();

        $.ajax({
            type: 'POST',
            url: '/attendance/getKidAttendance',
            data: { classNo: selectedClassNo },
            success: function(response) {
                $('#studentList').empty();

                response.forEach(function(attendance) {
                    var formattedKidDrop = formatTimeToKoreanStyle(attendance.kidDrop);
                    var formattedKidPickup = formatTimeToKoreanStyle(attendance.kidPickup);

                    var row = '<tr data-kid-no="' + attendance.kidNo + '">' +
                        '<td>' + attendance.kidName + '</td>' +
                        '<td>' + attendance.attendanceStatus + '</td>' +
                        '<td>' + formattedKidDrop + '</td>' +
                        '<td>' + formattedKidPickup + '</td>' +
                        '<td>' + attendance.note + '</td>' +
                        '</tr>';

                    $('#studentList').append(row);
                });
            },
            error: function(xhr, status, error) {
                console.error('Error:', error);
            }
        });
    });

    // 모달 열기 - 이벤트 위임 방식으로 수정
    $('#studentList').on('click', 'tr[data-kid-no]', function() {
        var row = $(this); // 현재 클릭된 행
        var kidNo = row.data('kid-no'); // data-kid-no 속성에서 아동 번호 가져옴
        var kidName = row.find('td:nth-child(1)').text().trim(); // 첫 번째 열에서 이름 가져옴
        var attendanceStatus = row.find('td:nth-child(2)').text().trim(); // 두 번째 열에서 출결 상태 가져옴
        var kidDrop = row.find('td:nth-child(3)').text().trim(); // 세 번째 열에서 등원 시간 가져옴
        var kidPickup = row.find('td:nth-child(4)').text().trim(); // 네 번째 열에서 하원 시간 가져옴
        var note = row.find('td:nth-child(5)').text().trim(); // 다섯 번째 열에서 비고 가져옴

        console.log("kidNo : " + kidNo);

        // 모달 창에 값을 설정
        $('#updateModal #kidNo').val(kidNo);
        $('#updateModal #attendanceStatus').val(attendanceStatus);
        $('#updateModal #kidDrop').val(kidDrop);
        $('#updateModal #kidPickup').val(kidPickup);
        $('#updateModal #note').val(note);

        // 모달 창 표시
        var myModal = new bootstrap.Modal(document.getElementById('updateModal'));
        myModal.show();
    });

    // 출결 상태 변경 시 등원/하원 시간 입력 필드 활성화/비활성화
    $('#attendanceStatus').on('change', function() {
        var status = $(this).val();
        if (status === '결석') {
            $('#kidDrop, #kidPickup').prop('disabled', true).val(''); // Disable fields and clear value
        } else {
            $('#kidDrop, #kidPickup').prop('disabled', false); // Enable fields
        }
    });

    // 수정 사항 적용 버튼 클릭 시
    $('#applyUpdate').on('click', function() {
        $('#updateForm').submit();
    });

    // 폼 제출 처리
    $('#updateForm').on('submit', function(e) {
        e.preventDefault();

        var formData = new FormData(this); // Create form data object

        formData.forEach((value, key) => {
            console.log('formdata / ' + key + ": " + value);
        });

        const currentUrl = new URL(window.location.href);
        const classNo = currentUrl.searchParams.get('classNo'); // Get classNo from current URL

        // Ajax request
        $.ajax({
            type: 'POST',
            url: './updateAttendanceOne?kidNo=' + formData.get('kidNo') +
                '&attendanceStatus=' + formData.get('attendanceStatus') +
                '&excusedAbsence=' + formData.get('excusedAbsence') +
                '&kidDrop=' + formData.get('kidDrop') +
                '&kidPickup=' + formData.get('kidPickup') +
                '&note=' + formData.get('note') +
                '&classNo=' + classNo,
            data: formData,
            processData: false,
            contentType: false,
            success: function(response) {
                // On success, hide modal and reload page
                var myModal = bootstrap.Modal.getInstance(document.getElementById('updateModal'));
                myModal.hide();
                location.reload();
            },
            error: function(xhr, status, error) {
                // On error, log to console and show alert
                console.error(xhr);
                console.error(status);
                console.error(error);
                Swal.fire({
                    icon: 'warning',
                    title: '출석부 수정 실패',
                    text: '반을 선택해 주세요.',
                });
            }
        });
    });

    // DataTable 초기화
    new DataTable('#attendanceTable', {
        info: false,
        ordering: false,
        paging: false,
        searching: false
    });

    // 작성 버튼 클릭 시
    $('#writeBtn').click(function(event) {
        event.preventDefault(); // 기본 링크 동작을 막음

        // 선택된 반 번호를 가져옴
        var selectedClassNo = $('#classSelect').val();
        console.log("선택된 classNo: " + selectedClassNo);

        if (selectedClassNo) {
            // 선택된 classNo를 URL에 포함하여 페이지 이동
            window.location.href = '/attendance/admin/write/' + selectedClassNo;
        } else {
            Swal.fire({
                icon: 'warning',
                title: '반을 선택하세요',
            });
        }
    });

});

// 시간 포맷을 한국 스타일로 변환
function formatTimeToKoreanStyle(dateTimeString) {
    if (!dateTimeString || typeof dateTimeString !== 'string') {
        return '';
    }

    var timePart = dateTimeString.split('T')[1]; // 시간 부분 추출
    var timeParts = timePart.split(':'); // 시, 분, 초 분리

    if (timeParts.length < 2) {
        return '';
    }

    var hours = parseInt(timeParts[0], 10);
    var minutes = timeParts[1];

    return hours + '시 ' + minutes + '분';
}
