document.addEventListener('DOMContentLoaded', function () {
    console.log('DOM fully loaded and parsed');

    // Event listener for clicking on class items
    $('.class-item').on('click', function () {
        console.log('Class item clicked');
        const classNo = $(this).data('classno');
        console.log("classNo: " + classNo);

        // Fetch data using classNo from the backend (replace with actual data retrieval logic)
        const classData = getClassByNo(classNo);

        if (classData) {
            $('#classModalLabel').text(classData.className + ' 정보');
            $('#className').text(classData.className);

            // Populate teacher list
            const teacherList = $('#teacherList');
            teacherList.empty();
            if (classData.teachers && Array.isArray(classData.teachers)) {
                classData.teachers.forEach(teacher => {
                    teacherList.append(`<li class="list-group-item">${teacher}</li>`);
                });
            }

            // Populate students list
            const studentsList = $('#studentsList');
            studentsList.empty();
            if (classData.students && Array.isArray(classData.students)) {
                classData.students.forEach(student => {
                    studentsList.append(`<li class="list-group-item">${student}</li>`);
                });
            }

            // Set notice link
            if (classData.noticeLink) {
                $('#noticeLink').attr('href', classData.noticeLink);
            }

            // Show the modal
            $('#classModal').modal('show');
        } else {
            alert('해당 반의 데이터를 찾을 수 없습니다.');
        }
    });

    // Event listener for the delete button
    $('.delete-btn').on('click', function (event) {
        event.stopPropagation();  // Prevent triggering the click event on the class-item
        console.log('Delete button clicked');
        $(this).closest('.class-item').remove();
    });

    // Event listener for adding a class
    $('#addClassBtn').on('click', function () {
        console.log('Add Class button clicked');
        alert('반 추가 기능은 구현되지 않았습니다.');
    });

    // Event listener for editing the class name
    // Bootstrap 모달이 기본적으로 포커스를 강제하는 기능을 가지고 있어서 sweetalert2과 충돌남
    $.fn.modal.Constructor.prototype._enforceFocus = function () {
    }; // Bootstrap 모달이 포커스를 강제하지 않도록 설정
    new bootstrap.Modal(document.getElementById('classModal'), {focus: false}); // Bootstrap 모달이 로드될 때 자동으로 포커스를 받지 않도록 설정
    //
    $('#editClassNameBtn').on('click', async function () {
        console.log('Edit Class Name button clicked');
        const currentClassName = $('#className').text(); // 현재 반 이름을 가져옵니다.

        Swal.fire({
            title: '새 반 이름을 입력하세요',
            input: 'text',
            inputValue: currentClassName,
            showCancelButton: true,
            confirmButtonText: '저장',
            cancelButtonText: '취소',
            inputValidator: (value) => {
                if (!value) {
                    return '반 이름을 입력해야 합니다!';
                }
            }
        }).then((result) => {
            if (result.isConfirmed) {
                $('#className').text(result.value);
            }
        });
    });

    function getClassByNo(classNo) {
        return $.ajax({
            url: `/classManage/detail/${classNo}`,
            method: 'GET',
            contentType: "application/json",
            success: function (data) {
                console.log("Class Data:", data);
                // data.classKid와 data.classTeacher를 사용하여 모달을 업데이트
                // $('#classModalLabel').text(data.className + ' 정보');
                // $('#classModalLabel').text('반 정보');
                // $('#className').text(data.className);
                // data.classTeacher에서 className을 가져와서 설정
                if (data.classTeacher.length > 0) {
                    $('#className').text(data.classTeacher[0].className);
                } else {
                    $('#className').text('No class name available');
                }

                // 교사 목록 업데이트
                const teacherList = $('#teacherList');
                teacherList.empty();
                data.classTeacher.forEach(teacher => {
                    teacherList.append(`<li class="list-group-item">${teacher.name}</li>`);
                });

                // 학생 목록 업데이트
                const studentsList = $('#studentsList');
                studentsList.empty();
                data.classKid.forEach(kid => {
                    studentsList.append(`<li class="list-group-item">${kid.kidName}</li>`);
                });

                // 모달 표시
                $('#classModal').modal('show');
            },
            error: function (error) {
                console.log("Error:", error);
                alert('반 정보를 가져오는데 문제가 발생했습니다.');
            }

        })
    }

});
