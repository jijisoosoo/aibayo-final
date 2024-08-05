document.addEventListener("DOMContentLoaded", function() {
    // 모달 요소 선택
    var passwordModal = document.getElementById('passwordModal');
    var cancelButton = passwordModal.querySelector('.btn-secondary');
    var passwordForm = document.getElementById('passwordForm');
    var currentPassword = document.getElementById('currentPassword');
    var newPassword = document.getElementById('newPassword');
    var confirmPassword = document.getElementById('confirmPassword');

    // '취소' 버튼 클릭 시 모달 닫기
    cancelButton.addEventListener('click', function() {
        $('#passwordModal').modal('hide');
    });


    // 비밀번호 검증 및 폼 제출 처리
    passwordForm.addEventListener('submit', function(event) {
        if (currentPassword.value === newPassword.value) {
            event.preventDefault();  // 폼 제출 방지
            alert('이전 비밀번호와 일치합니다.');
            currentPassword.value = '';
            newPassword.value = '';
            confirmPassword.value = '';
            return false; // 추가된 return 문
        }

        if (newPassword.value !== confirmPassword.value) {
            event.preventDefault();  // 폼 제출 방지
            alert('비밀번호가 일치하지 않습니다.');
            newPassword.value = '';
            confirmPassword.value = '';
            return false; // 추가된 return 문
        }


    });
});
