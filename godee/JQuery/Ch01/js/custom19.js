$(document).ready(function(){//ready 콜백함수 함수에는 일반함수와 콜백함수로 나뉘어짐
    /*
    $("li").eq(0).on("click",function(){
        $("li").eq(0).css({"color":"red"})
    )};*/



    $("li").on("click",function(){
        $(this).css({"color":"red"});
    });
});