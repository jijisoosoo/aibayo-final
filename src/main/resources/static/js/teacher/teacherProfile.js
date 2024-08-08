document.addEventListener('DOMContentLoaded', () => {
    classPaint();
});






function classPaint() {
    // 'classList' 클래스를 가진 모든 요소를 선택
    const finalClassElements = document.querySelectorAll('.classList');
    const addableElements = document.querySelectorAll('.addableClassList');
    const assignedElements = document.querySelectorAll('.assignedClassList');

    // 각 요소의 'id' 속성 값을 리스트로 반환
    const finalClass = Array.from(finalClassElements).map(element => element.id);
    const addableClass = Array.from(addableElements).map(element => element.id);
    const assignedClass = Array.from(assignedElements).map(element => element.id);

    // 결과를 콘솔에 출력
    console.log(finalClass);
    console.log(addableClass);
    console.log(assignedClass);


    // if(finalClass === addableClass){
    //
    // }
    //
    //
    // $('.row-selected-teacher').hide();
    //
    // // 초기 로드 시 체크된 라디오 버튼에 해당하는 div를 표시
    // var initialSelectedValue = $('input[name="teacherStatusRd"]:checked').val();
    // if (initialSelectedValue) {
    //     $('#teacherStatus' + initialSelectedValue + 'Div').show();
    // }
}