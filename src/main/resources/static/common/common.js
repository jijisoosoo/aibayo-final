function initializeMarquee($text_div) {
    var $textCompact = $text_div.find('.text-compact');

    console.log($textCompact[0].scrollWidth);
    console.log($textCompact[0].offsetWidth);

    // 이미 초기화된 경우에는 다시 초기화하지 않음
    // 모달 팝업 시 텍스트 무한 복제 방지
    if ($textCompact.find('.js-marquee').length > 0) {
        console.log("초기화 생략")
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




