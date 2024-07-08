$(document).ready(function() {
    $('.text_div').each(function() {
        var $this = $(this);
        var $textCompact = $this.find('.text-compact');
        
        // overflow 발생 시에만 적용
        if ($textCompact[0].scrollWidth > $this.width()) {
            $textCompact.marquee({
                duration: 5000,
                startVisible: true,
                pauseOnHover: true,
                duplicated: true,
                gap: 50
            });

            $this.hover(
                function() {
                    $textCompact.marquee('resume');
                },
                function() {
                    $textCompact.marquee('pause');
                }
            );

            // Start paused
            $textCompact.marquee('pause');
        }
    });
});