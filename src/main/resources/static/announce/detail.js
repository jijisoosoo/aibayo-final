var deleteBtn = document.querySelector('.deleteBtn');

deleteBtn.addEventListener('click', function() {
    alert('정말 삭제하시겠습니까?');
});

const myModal = document.getElementById('myModal')
const myInput = document.getElementById('myInput')

myModal.addEventListener('shown.bs.modal', () => {
    myInput.focus()
})