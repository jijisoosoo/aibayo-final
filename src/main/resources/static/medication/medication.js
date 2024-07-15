$(document).ready(function(){
    $('.datepicker').datepicker({
        format: 'yyyy.mm.dd',
        autoclose: true,
        language: 'ko',
        orientation: 'bottom'
    });
});
const myModal = document.getElementById('myModal')
const myInput = document.getElementById('myInput')

myModal.addEventListener('shown.bs.modal', () => {
    myInput.focus()
})