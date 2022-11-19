$(document).ready(function(){
   var timer = setInterval(function(){
      var now = new Date();
      var hr=now.getHours();
      var min =now.getMinutes();
      var sec= now.getSeconds();
      var a=$("span").eq(0).text(hr);
      var b=$("span").eq(1).text(min);
      var c=$("span").eq(2).text(sec);
  });


});