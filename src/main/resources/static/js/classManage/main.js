document.addEventListener('DOMContentLoaded', function () {
    const classData = {
        '1반': {
            teachers: ['Mrs. Kim', 'Mr. Lee'],
            students: ['Student A', 'Student B', 'Student C'],
            noticeLink: 'https://example.com/notices/1'
        },
        '2반': {
            teachers: ['Mr. Lee', 'Ms. Park'],
            students: ['Student D', 'Student E'],
            noticeLink: 'https://example.com/notices/2'
        },
        '3반': {
            teachers: ['Ms. Park', 'Mr. Choi'],
            students: ['Student F', 'Student G', 'Student H'],
            noticeLink: 'https://example.com/notices/3'
        },
        '4반': {
            teachers: ['Mr. Choi', 'Mrs. Kim'],
            students: ['Student I', 'Student J'],
            noticeLink: 'https://example.com/notices/4'
        },
        '5반': {
            teachers: ['Ms. Park', 'Mr. Choi'],
            students: ['Student F', 'Student G', 'Student H'],
            noticeLink: 'https://example.com/notices/3'
        },
        '6반': {
            teachers: ['Mr. Choi', 'Mrs. Kim'],
            students: ['ㅋㅋ', 'ㅇㅇ'],
            noticeLink: 'https://example.com/notices/4'
        }

    };

    $('.class-item').on('click', function () {
        const className = $(this).data('class');
        const data = classData[className];

        $('#classModalLabel').text(className + ' 정보');
        $('#className').text(className);

        // Populate teacher list
        const teacherList = $('#teacherList');
        teacherList.empty();
        data.teachers.forEach(teacher => {
            teacherList.append(`<li class="list-group-item">${teacher}</li>`);
        });

        // Populate students list
        const studentsList = $('#studentsList');
        studentsList.empty();
        data.students.forEach(student => {
            studentsList.append(`<li class="list-group-item">${student}</li>`);
        });

        // Set notice link
        $('#noticeLink').attr('href', data.noticeLink);

        $('#classModal').modal('show');
    });

    $('.delete-btn').on('click', function (event) {
        event.stopPropagation();
        $(this).closest('.class-item').remove();
    });

    $('#addClassBtn').on('click', function () {
        alert('반 추가 기능은 구현되지 않았습니다.');
    });

    $('#editClassNameBtn').on('click', function () {
        const newClassName = prompt('새 반 이름을 입력하세요:', $('#className').text());
        if (newClassName) {
            $('#className').text(newClassName);
        }
    });
});