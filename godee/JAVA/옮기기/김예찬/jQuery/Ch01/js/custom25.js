$(document).ready(function(){
 
   $("button").on("click", function(){
      $("div").html("<h1>변경후입니다.</h1>");
   });

   $("div").on("click", function(){
      alert($(this).html());
   });
});