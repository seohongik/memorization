$(document).ready(function(){
    $("li").children("span").css({"color":"red"});
    // 안됨 ul의 자식이 li이기 때문에 $("ul").children("span").css({"color":"red"});
    // 이건 됨 ul>li>span $("ul").children("li").children("span").css({"color":"red"});
});