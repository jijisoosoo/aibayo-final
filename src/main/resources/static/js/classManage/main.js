document.addEventListener('DOMContentLoaded', function () {
    // Event listener for clicking on class items
    $('.class-item').on('click', function () {
        const classNo = $(this).data('classno');
        console.log("classNo :" + classNo);

        // Fetch data using classNo from the backend (replace with actual data retrieval logic)
        const classData = getClassDataByNo(classNo);

        if (classData) {
            $('#classModalLabel').text(classData.className + ' 정보');
            $('#className').text(classData.className);

            // Populate teacher list
            const teacherList = $('#teacherList');
            teacherList.empty();
            classData.teachers.forEach(teacher => {
                teacherList.append(`<li class="list-group-item">${teacher}</li>`);
            });

            // Populate students list
            const studentsList = $('#studentsList');
            studentsList.empty();
            classData.students.forEach(student => {
                studentsList.append(`<li class="list-group-item">${student}</li>`);
            });

            // Set notice link
            $('#noticeLink').attr('href', classData.noticeLink);

            // Show the modal
            $('#classModal').modal('show');
        } else {
            alert('해당 반의 데이터를 찾을 수 없습니다.');
        }
    });

    // Event listener for the delete button
    $('.delete-btn').on('click', function (event) {
        event.stopPropagation();  // Prevent triggering the click event on the class-item
        $(this).closest('.class-item').remove();
    });


    // Event listener for adding a class
    $('#addClassBtn').on('click', function () {
        alert('반 추가 기능은 구현되지 않았습니다.');
    });

    // Event listener for editing the class name
    $('#editClassNameBtn').on('click', function () {
        const newClassName = prompt('새 반 이름을 입력하세요:', $('#className').text());
        if (newClassName) {
            $('#className').text(newClassName);
        }
    });

    // Function to fetch class data based on classNo
    function getClassDataByNo(classNo) {
        // Replace this with actual data retrieval logic, like an AJAX call
        const classData = {
            1: {
                className: '1반',
                teachers: ['Mrs. Kim', 'Mr. Lee'],
                students: ['Student A', 'Student B', 'Student C'],
                noticeLink: 'https://example.com/notices/1'
            },
            2: {
                className: '2반',
                teachers: ['Mr. Lee', 'Ms. Park'],
                students: ['Student D', 'Student E'],
                noticeLink: 'https://example.com/notices/2'
            },
            3: {
                className: '3반',
                teachers: ['Ms. Park', 'Mr. Choi'],
                students: ['Student F', 'Student G', 'Student H'],
                noticeLink: 'https://example.com/notices/3'
            },
            // Add more classes as needed
        };
        return classData[classNo];
    }
});
