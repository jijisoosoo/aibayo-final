function initializeMarquee($text_div) {
    var $textCompact = $text_div.find('.text-compact');

    // console.log($textCompact[0].scrollWidth);
    // console.log($textCompact[0].offsetWidth);

    // 이미 초기화된 경우에는 다시 초기화하지 않음
    // 모달 팝업 시 텍스트 무한 복제 방지
    if ($textCompact.find('.js-marquee').length > 0) {
        // console.log("초기화 생략")
        return;
    }

    // overflow 발생 시에만 적용
    if ($textCompact[0].scrollWidth > $textCompact[0].offsetWidth) {
        $textCompact.marquee({
            duration: 5000,
            startVisible: true,
            pauseOnHover: true,
            duplicated: true,
            gap: 50 // 공백 크기 설정 (픽셀 단위)
        });

        $text_div.hover(
            function() {
                // 마우스를 올리면 text-overflow: ellipsis 제거
                $textCompact.css('text-overflow', 'clip');
                $textCompact.marquee('resume');
            },
            function() {
                // 마우스를 떼면 text-overflow: ellipsis 다시 설정
                $textCompact.css('text-overflow', 'ellipsis');
                $textCompact.marquee('pause');
                $textCompact.css('outerText')
            }
        );

        // Start paused
        $textCompact.marquee('pause');
    }
}

// ajax json 전달
function commonAjax(url,type, param) {
    $.ajax({
        url: url,
        type: type,
        data:  JSON.stringify(param),
        contentType: 'application/json',
        success: function(response) {
            afterSuccess(response);
        },
        error: function(xhr, status, error) {
            console.error("AJAX 요청 오류:", status, error);
        }
    })
}

$(document).ready(function() {
    // 페이지가 로드되면 모든 컨테이너에 대해 marquee 초기화
    $('.text_div').each(function() {
        initializeMarquee($(this));
    });
});

document.addEventListener("DOMContentLoaded", () => {
    const chatIframe = document.getElementById("chatIframe");

    // 페이지 로드 시 채팅팝업을 끈 상태로 설정
    document.body.classList.remove("show-chatbot");
    chatIframe.style.width = '100px';
    chatIframe.style.height = '100px';
});






// // 쿠키 전체 삭제하기
// const allDelCookies = (domain, path) => {
//     domain = domain || window.location.hostname;
//     path = path || '/';
//     const cookies = document.cookie.split('; '); // 배열로 반환
//     const expiration = 'Thu, 01 Jan 1970 00:00:00 GMT';
//
//     if (cookies.length === 1 && cookies[0] === '') {
//         alert('삭제할 쿠키가 없습니다.');
//     } else {
//         for (let i = 0; i < cookies.length; i++) {
//             const cookie = cookies[i];
//             const eqPos = cookie.indexOf('=');
//             const name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
//             document.cookie = name + '=; expires=' + expiration + '; path=' + path + '; domain=' + domain;
//         }
//         alert('쿠키 전부 삭제완료!!');
//     }
// };
//
// // 로그아웃 버튼 클릭 시 전체 쿠키 삭제
// $(document).ready(function() {
//     $('#logoutButton').on('click', function() {
//         $.ajax({
//             url: '/logout',
//             type: 'POST',
//             xhrFields: {
//                 withCredentials: true
//             },
//             success: function(response) {
//                 // 모든 쿠키 삭제
//                 allDelCookies();
//                 alert('Logged out successfully');
//                 window.location.href = '/login'; // 로그아웃 후 리디렉션 할 페이지
//             },
//             error: function(xhr, status, error) {
//                 alert('Logout failed');
//                 console.error('Error:', error);
//             }
//         });
//     });
// });

$(document).ready(function() {
    $('#logoutButton').on('click', function() {
        $.ajax({
            url: '/logout',
            type: 'POST',
            xhrFields: {
                withCredentials: true
            },
            success: function(response) {
                // 쿠키에서 'jwt' 토큰을 삭제합니다.
                var domain = window.location.hostname;
                document.cookie = 'jwt=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/; domain=' + domain + ';';
                alert('Logged out successfully');
                window.location.href = '/login'; // 로그아웃 후 리디렉션 할 페이지
            },
            error: function(xhr, status, error) {
                alert('Logout failed');
                console.error('Error:', error);
            }
        });
    });
});