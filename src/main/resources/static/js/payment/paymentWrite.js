let afterSuccessType = null;
let discountList = [];

$(document).ready(function() {

    // 전체 선택
    $("#checkAll").click(function() {
        $("input.class_checkbox").prop("checked", this.checked);
    });

    // 전체 선택 빼기
    $("input.class_checkbox").click(function() {
        let total = $("input.class_checkbox").length;
        let checked = $("input.class_checkbox:checked").length;

        if (checked === total) {
            $("#checkAll").prop("checked", true);
        } else {
            $("#checkAll").prop("checked", false);
        }
    });


    document.querySelectorAll('.inputtext').forEach(function(inputElement) {
        // input 이벤트 리스너: 입력된 값에서 숫자가 아닌 문자를 제거
        inputElement.addEventListener('input', function (e) {
            this.value = this.value.replace(/[^0-9]/g, '');

            // #discount_rate인 경우 숫자 두 자리까지만 허용
            if (this.id === 'discount_rate' && this.value.length > 2) {
                this.value = this.value.slice(0, 2);
            }
        });

        // keydown 이벤트 리스너: 숫자키와 허용된 키만 입력 가능하게 설정
        inputElement.addEventListener('keydown', function (e) {
            const allowedKeys = [
                'Backspace', 'Tab', 'ArrowLeft', 'ArrowRight', 'Delete', 'Enter'
            ];

            if (
                (e.key >= '0' && e.key <= '9') || // 숫자키 허용
                allowedKeys.includes(e.key)       // 허용된 기타 키 허용
            ) {
                return;
            } else {
                e.preventDefault(); // 허용되지 않은 키 입력 차단
            }
        });
    });




    $(document).on('change', '.selectoption-child', function () {
        let classNo = $('.selectoption-child').val()

        let param = {
            classNo: classNo === "" ? null : classNo
        };

        let url = "/payment/admin/paymentBillingWriteGetKid";

        afterSuccessType = 'getKid'
        commonAjax(url, 'POST', param);

    });


    $(document).on('click', '#setIdList', function () {
        let classNo = $('.selectClass').val();
        let className = $('.selectClass option:selected').text();

        // member id 리스트로
        let selectedKidList = [];
        let selectedOptions = document.querySelectorAll('.form-check .class_checkbox');
        selectedOptions.forEach(function(option) {
            if (option.checked) {
                let selectedKid = {
                    id: option.value,
                    memberName: option.getAttribute('data-member-name'),
                    kidNo: option.getAttribute('data-kid-no'),
                    kidName: option.getAttribute('data-kid-name')
                };
                selectedKidList.push(selectedKid);
            }
        });

        let param = {
            classNo : classNo,
            className : className,
            selectedKidList : selectedKidList
        };

        console.log(param);

        let url = "/payment/admin/ShowSelectedKid";

        afterSuccessType = 'showSelectedKid'
        commonAjax(url, 'POST', param);

    });


    $(document).on('click', '#add_discount', function () {

        // discountList를 받아오기
        // let existDiscountElement = document.querySelectorAll('#discountElement');
        // existDiscountElement.forEach(function(element) {
        //
        //     let discountKidElement = element.querySelector('#discount_kid');
        //     let discountedRateElement = element.querySelector('#discounted_rate');
        //
        //     let discounted = {
        //         memberId: discountKidElement.getAttribute('data-member-id'),
        //         kidNo: discountKidElement.getAttribute('data-kid-no'),
        //         kidName: discountKidElement.textContent.trim(),
        //         discountRate: discountedRateElement.textContent.trim().replace('%', '')
        //     };
        //     discountList.push(discounted);
        // });

        // 새 할인 항목을 list에 추가
        let newDiscountElement = {
            memberId: $('.discountForSelectedKids option:selected').attr('id'),
            kidNo: $('.discountForSelectedKids option:selected').attr('data-kid-no'),
            kidName: $('.discountForSelectedKids option:selected').text(),
            discountRate: $('#discount_rate').val()
        };
        discountList.push(newDiscountElement);

        let param = {
            discountList : discountList
        };

        // console.log( $('.discountForSelectedKids option:selected').attr('id'));
        // console.log($('.discountForSelectedKids option:selected').attr('data-kid-no'));
        // console.log($('.discountForSelectedKids option:selected').text());
        // console.log($('#discount_rate').val());
        console.log(discountList);

        let url = "/payment/admin/showDiscountedKid";

        afterSuccessType = 'showDiscountedKid'
        commonAjax(url, 'POST', param);

    });

});

function afterSuccess(response, method) {

    if(afterSuccessType === 'getKid'){
        $('.carousel').replaceWith($(response).find('.carousel'));
        afterSuccessType = null;
    }

    if(afterSuccessType === 'showSelectedKid'){
        $('.div-2').replaceWith($(response).find('.div-2'));
        $('.discountForSelectedKids').replaceWith($(response).find('.discountForSelectedKids'));
        afterSuccessType = 'null';
    }

    if(afterSuccessType === 'showDiscountedKid'){
        $('.div-11').replaceWith($(response).find('.div-11'));
        afterSuccessType = 'null';
    }



}