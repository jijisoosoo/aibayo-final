const desc = ["", "좋음", "보통", "나쁨", "매우 나쁨"];
const pmSvg = [
    "",
    `<svg xmlns="http://www.w3.org/2000/svg" width="90" height="90" viewBox="0 0 24 24"><path fill="#3C83EF" d="M12 17.5c2.33 0 4.3-1.46 5.11-3.5H6.89c.8 2.04 2.78 3.5 5.11 3.5M8.5 11A1.5 1.5 0 0 0 10 9.5A1.5 1.5 0 0 0 8.5 8A1.5 1.5 0 0 0 7 9.5A1.5 1.5 0 0 0 8.5 11m7 0A1.5 1.5 0 0 0 17 9.5A1.5 1.5 0 0 0 15.5 8A1.5 1.5 0 0 0 14 9.5a1.5 1.5 0 0 0 1.5 1.5M12 20a8 8 0 0 1-8-8a8 8 0 0 1 8-8a8 8 0 0 1 8 8a8 8 0 0 1-8 8m0-18C6.47 2 2 6.5 2 12a10 10 0 0 0 10 10a10 10 0 0 0 10-10A10 10 0 0 0 12 2"/></svg>`,
    `<svg xmlns="http://www.w3.org/2000/svg" width="90" height="90" viewBox="0 0 256 256"><path fill="#048A24" d="M178.39 158c-11 19.06-29.39 30-50.39 30s-39.36-10.93-50.39-30a12 12 0 0 1 20.78-12c3.89 6.73 12.91 18 29.61 18s25.72-11.28 29.61-18a12 12 0 1 1 20.78 12M236 128A108 108 0 1 1 128 20a108.12 108.12 0 0 1 108 108m-24 0a84 84 0 1 0-84 84a84.09 84.09 0 0 0 84-84m-120-4a16 16 0 1 0-16-16a16 16 0 0 0 16 16m72-32a16 16 0 1 0 16 16a16 16 0 0 0-16-16"/></svg>`,
    `<svg xmlns="http://www.w3.org/2000/svg" width="90" height="90" viewBox="0 0 256 256"><path fill="#FFB505" d="M128 20a108 108 0 1 0 108 108A108.12 108.12 0 0 0 128 20m0 192a84 84 0 1 1 84-84a84.09 84.09 0 0 1-84 84m52-52a12 12 0 0 1-12 12H88a12 12 0 0 1 0-24h80a12 12 0 0 1 12 12M76 108a16 16 0 1 1 16 16a16 16 0 0 1-16-16m104 0a16 16 0 1 1-16-16a16 16 0 0 1 16 16"/></svg>`,
    `<svg xmlns="http://www.w3.org/2000/svg" width="90" height="90" viewBox="0 0 256 256"><path fill="#EC1C1C" d="M128 20a108 108 0 1 0 108 108A108.12 108.12 0 0 0 128 20m0 192a84 84 0 1 1 84-84a84.09 84.09 0 0 1-84 84M76 108a16 16 0 1 1 16 16a16 16 0 0 1-16-16m104 0a16 16 0 1 1-16-16a16 16 0 0 1 16 16m-3.26 57a12 12 0 0 1-19.48 14a36 36 0 0 0-58.52 0a12 12 0 0 1-19.48-14a60 60 0 0 1 97.48 0"/></svg>`
]

$(document).ready(function () {
    let stationName = $('.dust_box').data('station-name');
    // console.log(`stationName: ${stationName}`);

    let url = "https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty";
    let queryParams = `?${encodeURIComponent('serviceKey')}=5zv6%2FkeqLoX546ceoeLoe%2BdLSxW9ljqCM8YBFhS9sEDtq%2FqUlFvw0jMsYmaQu5qeim81NC%2FEg0f%2Fxgk%2FATVI9A%3D%3D`;
    queryParams += `&${encodeURIComponent('returnType')}=${encodeURIComponent('json')}`;
    queryParams += `&${encodeURIComponent('numOfRows')}=${encodeURIComponent('1')}`;
    queryParams += `&${encodeURIComponent('stationName')}=${encodeURIComponent(stationName)}`;
    queryParams += `&${encodeURIComponent('dataTerm')}=${encodeURIComponent('DAILY')}`;
    queryParams += `&${encodeURIComponent('ver')}=${encodeURIComponent('1.3')}`;

    $.ajax({
        type: 'GET',
        url: url + queryParams,
        success: function (response) {
            let item = response.response.body.items[0];
            let pm10Grade1h = item.pm10Grade1h;
            let pm25Grade1h = item.pm25Grade1h;
            // console.log(`item: ${JSON.stringify(response.response.body.items[0])}`);
            // console.log(`pm10Grade1h: ${pm10Grade1h}`)
            // console.log(`pm25Grade1h: ${pm25Grade1h}`)

            let tag = `<div class="dust_box" data-station-name="${stationName}">

                                <div class="fine_box">
                                    <div class="fine_body">
                                        <div class="fine_title">미세먼지</div>
                                        <div class="pm_svg_box">
                                            ${pmSvg[pm10Grade1h]}
                                        </div>
                                        <div class="fine_desc pm_grade_${pm10Grade1h}">
                                            ${desc[pm10Grade1h]}
                                        </div>
                                    </div>
                                </div>
                    
                                <div class="fine_box">
                                    <div class="fine_body">
                                        <div class="fine_title">초미세먼지</div>
                                        <div class="pm_svg_box">
                                            ${pmSvg[pm25Grade1h]}
                                        </div>
                                        <div class="fine_desc pm_grade_${pm25Grade1h}">
                                            ${desc[pm25Grade1h]}
                                        </div>
                                    </div>
                                </div>
                    
                            </div>`;

            $('.dust_box').replaceWith(tag);
        },
        error: function (error) {
            console.log(`error: ${error}`);
        }
    })
});