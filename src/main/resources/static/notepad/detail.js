$(document).ready(function () {
    if ($('.notepad_detail_content_body').find('.liferecord').length > 0) {
        // console.log("생활기록 존재")
        let lifeRecord = $('.liferecord');
        let mood = lifeRecord.data('mood');
        let health = lifeRecord.data('health');
        let temperature = lifeRecord.data('temperature');
        let meal = lifeRecord.data('meal');
        let sleepTime = lifeRecord.data('sleepTime');
        let defecationStatus = lifeRecord.data('defecationStatus');

        console.log(`mood: ${mood}, health: ${health}, temperature: ${temperature},
                    meal: ${meal}, sleepTime: ${sleepTime}, defecationStatus: ${defecationStatus}`);

        $('#mood' + mood).attr('checked', 'true');
        $('#health' + health).attr('checked', 'true');
        $('#temperature' + temperature).attr('checked', 'true');
        $('#meal' + meal).attr('checked', 'true');
        $('#sleeptime' + sleepTime).attr('checked', 'true');
        $('#defecation_status' + defecationStatus).attr('checked', 'true');
    } else {
        // console.log("생활기록 없음");
    }
});