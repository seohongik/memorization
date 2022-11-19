$(document).ready(function(){
 
   $("li").on("click", function(){
      var txt = $(this).text();
      // alert(txt);
      $("div").css({"background-color":txt});
   });
});