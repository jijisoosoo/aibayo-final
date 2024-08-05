window.onload = function() {
    function closeModal() {
        let passwordModal = document.getElementById('passwordModal');
        let cancelButton = passwordModal.querySelector('.btn-secondary');
        cancelButton.addEventListener('click', function() {
            let modalInstance = bootstrap.Modal.getInstance(passwordModal);
            if (modalInstance) {
                modalInstance.hide();
            }
        });
    }

    function resetInputs(currentPassword, newPassword, confirmPassword) {
        currentPassword.value = '';
        newPassword.value = '';
        confirmPassword.value = '';
    }

    function validatePasswords(currentPassword, newPassword, confirmPassword) {
        if (currentPassword.value === newPassword.value) {
            alert('이전 비밀번호와 일치합니다.');
            resetInputs(currentPassword, newPassword, confirmPassword);
            return false;
        }

        if (newPassword.value !== confirmPassword.value) {
            alert('비밀번호가 일치하지 않습니다.');
            resetInputs(currentPassword, newPassword, confirmPassword);
            return false;
        }

        return true;
    }

    function checkPasswordExistence(currentPassword, newPassword, confirmPassword, callback) {
        $.ajax({
            method: 'GET',
            url: '/passwordExist',
            data: {
                password: currentPassword.value
            },
            success: function(response) {
                callback(response.exists);
            },
            error: function() {
                alert('서버 요청 중 오류가 발생했습니다.');
                resetInputs(currentPassword, newPassword, confirmPassword);
            }
        });
    }

    function handleFormSubmit(event) {
        event.preventDefault();
        console.log('Submit event triggered');

        let passwordForm = event.target;
        let currentPassword = document.getElementById('currentPassword');
        let newPassword = document.getElementById('newPassword');
        let confirmPassword = document.getElementById('confirmPassword');

        if (validatePasswords(currentPassword, newPassword, confirmPassword)) {
            checkPasswordExistence(currentPassword, newPassword, confirmPassword, function(exists) {
                if (exists) {
                    passwordForm.submit();
                } else {
                    alert('존재하지 않는 비밀번호입니다.');
                    resetInputs(currentPassword, newPassword, confirmPassword);
                }
            });
        }
    }

    function initPasswordForm() {
        let passwordForm = document.getElementById('passwordForm');
        // 기존 이벤트 리스너를 모두 제거
        let newPassword = document.getElementById('newPassword');
        let confirmPassword = document.getElementById('confirmPassword');

        passwordForm.replaceWith(passwordForm.cloneNode(true));

        passwordForm = document.getElementById('passwordForm');
        passwordForm.addEventListener('submit', handleFormSubmit);
    }

    function initialize() {
        closeModal();
        initPasswordForm();
    }

    initialize();
};
