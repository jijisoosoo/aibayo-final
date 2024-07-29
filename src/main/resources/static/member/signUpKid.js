function toggleClassField() {
    const kindergartenSelect = document.getElementById('kindergarten-input');
    const classSelect = document.getElementById('class-input');

    if (kindergartenSelect.value === "") {
        classSelect.disabled = true;
    } else {
        classSelect.disabled = false;
    }
}

document.addEventListener('DOMContentLoaded', function() {
    const kindergartenSelect = document.getElementById('kindergarten-input');
    const classSelect = document.getElementById('class-input');

    // Initialize the class select as disabled
    classSelect.disabled = true;

    // Add event listener to kindergarten select
    kindergartenSelect.addEventListener('change', toggleClassField);
});