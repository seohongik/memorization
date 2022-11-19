$(document).ready(function(){

    $("div").on("click", function(){
        var w = $(this).width();
        alert(w+"px");
        $(this).width(300);

        // $(this).css({"height":w+"px"});
        $(this).height(w);
    });

});