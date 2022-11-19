$(document).ready(function(){

    $("div").on("mousewheel", function(event, delta){
        if(delta>0) {
            $(this).css({"background":"red"});
            $("p").text("마우스 휠을 올렸습니다.");
        } else if (delta<0) {
            $(this).css({"background":"blue"});
            $("p").text("마우스 휠을 내렸습니다.");
        }
    });

});