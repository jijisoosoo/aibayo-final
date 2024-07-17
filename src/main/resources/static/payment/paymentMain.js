$(document).ready(function() {
    // Initialize DataTable
    new DataTable('#datatable-payment', {
        info: false,
        ordering: true,
        paging: true
    });
});