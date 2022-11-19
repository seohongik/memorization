$(document).ready(function(){
    
   $("div").on("click",function(){
      var w =$(this).width();
     /* alert(w+"px");
      $(this).css({"height":w+"px"});*/
      $(this).height(w);
   });
});