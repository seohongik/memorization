$(document).ready(function(){

    $("li").on("click", function(){
        var i = $(this).index();
        window.alert(i+1+"번째");
    });

});