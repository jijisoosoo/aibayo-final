$(document).ready(function () {
    // Handle attendance status change
    $('select[id^="attendanceStatus_"]').on('change', function () {
        var status = $(this).val();
        var row = $(this).closest('tr');
        if (status === '결석') {
            row.find('input[id^="kidDrop"], input[id^="kidPickup"]').prop('disabled', true).val(''); // Disable fields and clear value
        } else {
            row.find('input[id^="kidDrop"], input[id^="kidPickup"]').prop('disabled', false); // Enable fields
        }
    });

    // Initialize DataTable
    new DataTable('#attendanceTable', {
        info: false,
        ordering: false,
        paging: false,
        searching: false
    });
});