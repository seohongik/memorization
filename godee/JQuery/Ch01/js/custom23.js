$(document).ready(function(){
    $("li").eq(0).on("click",function(){
      $("div").addClass("on"); 
      
   });
   $("li").eq(1).on("click",function(){
      $("div").removeClass("on"); 
      
   });
});