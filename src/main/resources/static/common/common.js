$(document).ready(function() {
    $('.text_div').each(function() {
        var $this = $(this);
        var $textCompact = $this.find('.text-compact');

        console.log($textCompact[0].scrollWidth);
        console.log($textCompact[0].offsetWidth);

        // overflow 발생 시에만 적용
        if ($textCompact[0].scrollWidth > $textCompact[0].offsetWidth) {
            $textCompact.marquee({
                duration: 5000,
                startVisible: true,
                pauseOnHover: true,
                duplicated: true,
                gap: 50
            });

            $this.hover(
                function() {
                    // 마우스를 올리면 text-overflow: ellipsis 제거
                    $textCompact.css('text-overflow', 'clip');
                    $textCompact.marquee('resume');
                },
                function() {
                    // 마우스를 떼면 text-overflow: ellipsis 다시 설정
                    $textCompact.css('text-overflow', 'ellipsis');
                    $textCompact.marquee('pause');
                }
            );

            // Start paused
            $textCompact.marquee('pause');
        }
    });
});