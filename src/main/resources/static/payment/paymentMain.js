$(document).ready(function() {
    // Initialize DataTable
    new DataTable('#datatable-payment', {
        info: false,
        ordering: true,
        paging: true,
        searching: false,
        aaSorting: [],
        order : [[ 3, "desc" ]],

        // 0번째 컬럼(checkbox) 정렬 비활성
        columnDefs: [
            { "targets": [0], "orderable": false }
        ],

        // 페이지 당 데이터 수: 상단에 안 보이게
        layout: {
            topStart: null
        }
    });

    // checkbox 전체 선택
    function checkAll() {
        $("#checkAll").click(function() {
            if($("#checkAll").is(":checked")) $("input[class='form-check-input']").prop("checked", true);
            else $("input[class='form-check-input']").prop("checked", false);
        });

        $("input[class='form-check-input']").click(function() {
            var total = $("input[class='form-check-input']").length;
            console.log(total);
            var checked = $("input[class='form-check-input']:checked").length;
            console.log(checked);

            if(total != checked) $("#checkAll").prop("checked", false);
            else $("#checkAll").prop("checked", true);
        });
    }
    checkAll();

    $(".dt-paging-button").click(checkAll());

});
