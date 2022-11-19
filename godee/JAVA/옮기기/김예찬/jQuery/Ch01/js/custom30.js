$(document).ready(function(){

    var now = new Date();
    $("p").eq(0).text(now);

    var year = now.getFullYear();
    $("p").eq(1).text(year);

    var month = now.getMonth()+1;
    $("p").eq(2).text(month);

    var date = now.getDate();
    $("p").eq(3).text(date);

    var day = now.getDay();
    $("p").eq(4).text(day);

    var hr = now.getHours();
    $("p").eq(5).text(hr);

    var min = now.getMinutes();
    $("p").eq(6).text(min);

    var sec = now.getSeconds();
    $("p").eq(7).text(sec);
});