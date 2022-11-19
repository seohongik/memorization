$(document).ready(function(){

   /* $("div").on("mouseenter", function(){
        $("div").stop().animate({"width":"500px","height":"500px"},1000,"easeOutBounce")
    });

    $("div").on("mouseleave", function(){
        $("div").stop().animate({"width":"300px","height":"300px"},1000,"easeOutBounce")
    });*/

    $("div").on("mouseenter", function(){
        $("div").stop().animate({"width":"500px","height":"500px"},1000,function(){
            $("div").stop().animate({"background-color":"red"},1000);
        });
        
        
    });
    $("div").on("mouseleave", function(){
        $("div").stop().animate({"width":"300px","height":"300px"},1000,function(){
            $("div").stop().animate({"background-color":"blue"},1000);
        });
        
        
    });

});