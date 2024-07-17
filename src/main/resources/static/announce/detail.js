// const myModal = document.getElementById('myModal')
// const myInput = document.getElementById('myInput')
//
// myModal.addEventListener('shown.bs.modal', () => {
//     myInput.focus()
// })

function button_event(){
    if (confirm("정말 삭제하시겠습니까??") === true){    //확인
        document.form.submit();
    }else{   //취소

    }
}


document.querySelectorAll('[data-bs-toggle="modal"]').forEach(function (modalToggle) {
    modalToggle.addEventListener('click', function () {
        var target = modalToggle.getAttribute('data-bs-target');
        var modal = document.querySelector(target);
        var input = modal.querySelector('.reply');

        modal.addEventListener('shown.bs.modal', function () {
            input.focus();
        });
    });
});
