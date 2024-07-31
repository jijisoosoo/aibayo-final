$(document).ready(function(){
    $('#classSelect').change(function(){
        var selectedClassNo = $(this).val();
        var currentUrl = window.location.href;

        // classNo 값을 업데이트
        var newUrl = currentUrl.replace(/classNo=\d+/, 'classNo=' + selectedClassNo);

        // attendanceInsertStatus 값을 업데이트, 없으면 추가
        if (/attendanceInsertStatus=\d+/.test(newUrl)) {
            newUrl = newUrl.replace(/attendanceInsertStatus=\d+/, 'attendanceInsertStatus=0');
        } else {
            newUrl += '&attendanceInsertStatus=1';
        }

        // cmd 값을 업데이트, 없으면 추가
        if (/cmd=[^&]+/.test(newUrl)) {
            newUrl = newUrl.replace(/cmd=[^&]+/, 'cmd=detailBefore');
        } else {
            newUrl += '&cmd=detailBefore';
        }

        window.location.href = newUrl;
    });

    // Initialize DataTable
    new DataTable('#attendanceTable', {
        info: false,
        ordering: false,
        paging: false
    });
});