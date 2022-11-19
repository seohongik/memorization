$(document).ready(function(){

   $(".box1").on("click",function(){
       $("p").text("box1을 클릭했습니다.");
 
   });

   $(".box2").on("click",function(){
    $("p").text("box2을 클릭했습니다.");

    });

    $(".box1").on("mouseenter",function(){
        $("p").text("box1에 마우스를 올렸습니다.");
  
    });

    
    $(".box1").on("mouseleave",function(){
        $("p").text("box1에 마우스를 벗어났습니다.");
  
    });


    $(".box2").on("mouseenter",function(){
        $("p").text("box2에 마우스를 올렸습니다.");
  
    });

    
    $(".box2").on("mouseleave",function(){
        $("p").text("box2에 마우스를 벗어났습니다.");
  
    });

    $(".box2").on("mousemove",function(){
        $("p").text("box2에서 마우스가 움직입니다.");
  
    });

    $(window).on("scroll",function(){
        $("p").text("화면을 스크롤 합니다.");
  
    });



});