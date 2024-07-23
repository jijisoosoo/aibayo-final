function findByRegDate(parameter) {
    console.log('dateText: ' + parameter.dateText);

    let url = '/notepad/user/searchDate';
    let data = {
        kidNo : parameter.kidNo,
        boardRegDate: parameter.dateText
    }

    commonAjax(url, 'POST', data);

}
