// $(document).ready(function() {
//     $(document).on('click', '.tuple', function () {
//         // 수납상태 리스트로
//         var paymentStatusList = [];
//         var selectedOptions = document.querySelectorAll('.selectedoption .btn-check');
//         selectedOptions.forEach(function(option) {
//             if (option.checked) {
//                 paymentStatusList.push(option.value);
//             }
//         });
//
//         var startDate = $('#inputStartDate').val() === "" ? null :
//             $('#inputStartDate').val().replace(/\./g, '-') + 'T00:00:00';
//         var endDate = $('#inputStartDate').val()  === "" ? null :
//             $('#inputEndDate').val().replace(/\./g, '-') + 'T00:00:00';
//         var inputString = $('.keyword').val();
//         var classNo = $('.dropdown-class').val();
//
//
//         let param = {
//             startDate : startDate,
//             endDate : endDate,
//             inputString : inputString === "" ? null : inputString,
//             paymentStatusList : paymentStatusList.length === 0 ? null : paymentStatusList,
//             classNo: classNo === "" ? null : classNo
//         };
//
//         console.log("param:" + JSON.stringify(param));
//
//         let url = "/payment/admin/paymentBillingMainSearch";
//
//         commonAjax(url, 'POST', param);
//     });
// });
//
// function afterSuccess(response, method) {
//
// }