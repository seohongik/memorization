$(document).ready(function(){
   
    $(".btn1").on("click",function(){
        $(".frame img").attr({
            "src":"./images/bg1.jpg", 
            "alt":"시계1"
        });//end of attr  
        
    });

    $(".btn2").on("click",function(){
        $(".frame img").attr({
            "src":"./images/bg2.jpg", 
            "alt":"시계1"
        });

        
    });//end of attr

    
});