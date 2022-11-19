$(document).ready(function(){
    $("li").eq(2).next().css({"color":"red"});//nth-child 는 1부터 시작 eq는 0부터 시작
});