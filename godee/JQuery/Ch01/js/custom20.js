$(document).ready(function(){//ready 콜백함수 함수에는 일반함수와 콜백함수로 나뉘어짐
    
   $("li").on("click",function(){
    var i=$(this).index();
    alert(i);
   });
});