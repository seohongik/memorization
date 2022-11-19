$(document).ready(function(){
 
   $(window).on("mousemove", function(e){

      var x = e.pageX;
      var y = e.pageY;

      $(".posX").text(x);
      $(".posY").text(y);

   });

});