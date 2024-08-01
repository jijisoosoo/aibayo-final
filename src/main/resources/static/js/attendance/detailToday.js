// $(document).ready(function() {
//     // Handle class selection change
//     $('#classSelect').change(function() {
//         var selectedClassNo = $(this).val();
//         var currentUrl = window.location.href;
//
//         // Update classNo value
//         var newUrl = currentUrl.replace(/classNo=\d+/, 'classNo=' + selectedClassNo);
//
//         // Update attendanceInsertStatus value, if not present add it
//         if (/attendanceInsertStatus=\d+/.test(newUrl)) {
//             newUrl = newUrl.replace(/attendanceInsertStatus=\d+/, 'attendanceInsertStatus=0');
//         } else {
//             newUrl += '&attendanceInsertStatus=1';
//         }
//
//         // Update cmd value, if not present add it
//         if (/cmd=[^&]+/.test(newUrl)) {
//             newUrl = newUrl.replace(/cmd=[^&]+/, 'cmd=detailToday');
//         } else {
//             newUrl += '&cmd=detailToday';
//         }
//
//         window.location.href = newUrl;
//     });
//
//     // Handle attendance status change
//     $('#attendanceStatus').on('change', function() {
//         var status = $(this).val();
//         if (status === '결석') {
//             $('#kidDrop, #kidPickup').prop('disabled', true).val(''); // Disable fields and clear value
//         } else {
//             $('#kidDrop, #kidPickup').prop('disabled', false); // Enable fields
//         }
//     });
//
//     // Handle update button click
//     $('a.attendance-update-one').on('click', function(e) {
//         e.preventDefault();
//         var row = $(this).closest('tr'); // Find closest tr tag
//         var kidNo = row.data('kid-no'); // Get kid number from data attribute
//         var attendanceStatus = row.find('td:nth-child(2)').text().trim(); // Get attendance status from second column
//         var excusedAbsence = row.find('td:nth-child(3)').text().trim(); // Get excused absence from third column
//         var kidDrop = row.find('td:nth-child(4)').text().trim(); // Get drop time from fourth column
//         var kidPickup = row.find('td:nth-child(5)').text().trim(); // Get pickup time from fifth column
//         var note = row.find('td:nth-child(6)').text().trim(); // Get note from sixth column
//
//         // Set values in the modal fields
//         $('#updateModal #kidNo').val(kidNo);
//         $('#updateModal #attendanceStatus').val(attendanceStatus).change(); // Trigger change event
//         $('#updateModal #excusedAbsence').val(excusedAbsence);
//         $('#updateModal #kidDrop').val(kidDrop);
//         $('#updateModal #kidPickup').val(kidPickup);
//         $('#updateModal #note').val(note);
//
//         // Show the modal
//         var myModal = new bootstrap.Modal(document.getElementById('updateModal'));
//         myModal.show();
//     });
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
//                 alert('Error updating attendance');
//             }
//         });
//     });
//
//     // Initialize DataTable
//     new DataTable('#attendanceTable', {
//         order: [[3, 'desc']]
//     });
// });


$(document).ready(function() {
    // Handle class selection change
    $('#classSelect').change(function() {
        var selectedClassNo = $(this).val();
        var currentUrl = window.location.href;

        // Update classNo value
        var newUrl = currentUrl.replace(/classNo=\d+/, 'classNo=' + selectedClassNo);

        // Update attendanceInsertStatus value, if not present add it
        if (/attendanceInsertStatus=\d+/.test(newUrl)) {
            newUrl = newUrl.replace(/attendanceInsertStatus=\d+/, 'attendanceInsertStatus=0');
        } else {
            newUrl += '&attendanceInsertStatus=1';
        }

        // Update cmd value, if not present add it
        if (/cmd=[^&]+/.test(newUrl)) {
            newUrl = newUrl.replace(/cmd=[^&]+/, 'cmd=detailToday');
        } else {
            newUrl += '&cmd=detailToday';
        }

        window.location.href = newUrl;
    });

    // Handle attendance status change
    $('#attendanceStatus').on('change', function() {
        var status = $(this).val();
        if (status === '결석') {
            $('#kidDrop, #kidPickup').prop('disabled', true).val(''); // Disable fields and clear value
        } else {
            $('#kidDrop, #kidPickup').prop('disabled', false); // Enable fields
        }
    });

    // Handle row click for updating
    $('tr[data-kid-no]').on('click', function() {
        var row = $(this); // Current row
        var kidNo = row.data('kid-no'); // Get kid number from data attribute
        var attendanceStatus = row.find('td:nth-child(2)').text().trim(); // Get attendance status from second column
        var excusedAbsence = row.find('td:nth-child(3)').text().trim(); // Get excused absence from third column
        var kidDrop = row.find('td:nth-child(4)').text().trim(); // Get drop time from fourth column
        var kidPickup = row.find('td:nth-child(5)').text().trim(); // Get pickup time from fifth column
        var note = row.find('td:nth-child(6)').text().trim(); // Get note from sixth column

        // Set values in the modal fields
        $('#updateModal #kidNo').val(kidNo);
        $('#updateModal #attendanceStatus').val(attendanceStatus).change(); // Trigger change event
        $('#updateModal #excusedAbsence').val(excusedAbsence);
        $('#updateModal #kidDrop').val(kidDrop);
        $('#updateModal #kidPickup').val(kidPickup);
        $('#updateModal #note').val(note);

        // Show the modal
        var myModal = new bootstrap.Modal(document.getElementById('updateModal'));
        myModal.show();
    });

    // Remove the existing click event on the anchor tag
    $('a.attendance-update-one').off('click');

    // Handle apply update button click
    $('#applyUpdate').on('click', function() {
        $('#updateForm').submit();
    });

    // Handle form submission
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
                alert('Error updating attendance');
            }
        });
    });

    // Initialize DataTable
    new DataTable('#attendanceTable', {
        info: false,
        ordering: false,
        paging: false
    });


});
