$(document).ready(function(){

   var sample = $("video").get(0);

   $(".load").on("click", function(){
      sample.load();
   });

   $(".play").on("click", function(){
      sample.play();
   });

   $(".pause").on("click", function(){
      sample.pause();
   });
});