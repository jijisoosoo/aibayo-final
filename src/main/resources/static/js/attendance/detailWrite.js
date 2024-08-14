// $(document).ready(function () {
//     $('#writeBtn').click(function (event) {
//         event.preventDefault(); // 기본 폼 제출을 방지
//
//         var attendanceList = [];
//         var kinderNo = $('#kinderNo').val();
//         var classNo = $('#classNo').val();
//         var date = $('#date').val();
//
//         $('#attendanceTable tbody tr').each(function (index, row) {
//             // kidDrop 및 kidPickup 값을 가져와서 currentDate와 결합
//             var kidDropTime = $('#kidDrop_' + index).val();
//             var kidPickupTime = $('#kidPickup_' + index).val();
//             // LocalDateTime 형식의 문자열 생성
//             var kidDropDateTime = date + ' ' + kidDropTime;
//             var kidPickupDateTime = date + ' ' + kidPickupTime;
//
//             var attendance = {
//                 kinderNo: kinderNo,
//                 classNo: classNo,
//                 kidNo: $('#kidNo_' + index).val(),
//                 kidName: $('#kidName_' + index).val(),
//                 attendanceStatus: $('#attendanceStatus_' + index).val(),
//                 kidDrop: kidDropDateTime,
//                 kidPickup: kidPickupDateTime,
//                 note: $('#note_' + index).val()
//             };
//
//             console.log(`param: ${JSON.stringify(attendance)}`);
//             attendanceList.push(attendance);
//         });
//
//         $.ajax({
//             type: 'POST',
//             url: '/attendance/admin/write',
//             contentType: 'application/json',
//             data: JSON.stringify(attendanceList),
//             success: function (response) {
//                 console.log('Success:', response);
//                 window.location.href="/attendance/admin/detailToday"
//             },
//             error: function (xhr, status, error) {
//                 console.error('Error:', error);
//             }
//         });
//     });
// });


$(document).ready(function () {
    $('#writeBtn').click(function (event) {
        event.preventDefault(); // 기본 폼 제출을 방지

        var attendanceList = [];
        var kinderNo = $('#kinderNo').val();
        var classNo = $('#classNo').val();

        $('#attendanceTable tbody tr').each(function (index, row) {
            var kidDropTime = $('#kidDrop_' + index).val();
            var kidPickupTime = $('#kidPickup_' + index).val();

            var currentDate = new Date().toISOString().split('T')[0]; // 2024-08-14 형식

            // kidDrop 및 kidPickup 시간이 없을 경우 공백으로 처리
            var kidDropDateTime = kidDropTime ? currentDate + ' ' + kidDropTime : '';
            var kidPickupDateTime = kidPickupTime ? currentDate + ' ' + kidPickupTime : '';

            // 데이터를 HashMap 형태로 구성
            var attendance = {
                kinderNo: kinderNo,
                classNo: classNo,
                kidNo: $('#kidNo_' + index).val(),
                kidName: $('#kidName_' + index).val(),
                attendanceStatus: $('#attendanceStatus_' + index).val(),
                kidDrop: kidDropDateTime,
                kidPickup: kidPickupDateTime,
                note: $('#note_' + index).val()
            };

            attendanceList.push(attendance);
        });

        $.ajax({
            type: 'POST',
            url: '/attendance/admin/write',
            contentType: 'application/json',
            data: JSON.stringify(attendanceList),
            success: function (response) {
                window.location.href = '/attendance/admin/detailToday';
            },
            error: function (xhr, status, error) {
                console.error('Error:', error);
            }
        });
    });
});
