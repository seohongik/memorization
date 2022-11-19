$(document).ready(function(){
    $("li").eq(0).on("click",function(){ 
      $(".box1").hide();
   });

   $("li").eq(1).on("click",function(){ 
      $(".box1").show();
  });
  
  $("li").eq(2).on("click",function(){ 
   $(".box2").fadeOut(1000);
   });
   $("li").eq(3).on("click",function(){ 
      $(".box2").fadeIn(1000);
   });
});