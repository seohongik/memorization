$(document).ready(function(){



    
    var timer = setInterval(function(){
        var now = new Date();
        var hr = now.getHours();
        $("span").eq(0).text(hr);
        var min = now.getMinutes();
        $("span").eq(1).text(min);
        var sec = now.getSeconds();
        $("span").eq(2).text(sec);
    }, 1000);

    
});