$(document).ready(function(){
   $(window).on("scroll", function(){
      $("p").text($(this).scrollTop());
   });
});