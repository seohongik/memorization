// 연도와 달을 입력받아 각 변수에 저장합니다.
var year = window.prompt("출력하고 싶은 년도는?","2020");
var month = window.prompt("출력하고 싶은 달은?","2");



// title 객체를 생성합니다.
var title = document.getElementById("title");
// title 객체안에 저장된 변수를 작성합니다.(2020.2)
title.innerHTML = year + '.' + month;

