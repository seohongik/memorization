$(document).ready(function(){
    $("button").on("click",function(){
        var num =$("input").val();//값을 읽어옴

        if(num==""){
            alert("아무런 정보도 입력하지 않으셨습니다.");
        } else if(num>=19){
            alert("당신은 성인입니다.");
        } else if(num<19){
            alert("당신은 미성년입니다.");
        } else{
            alert("숫자만 입력하세요");
        }

    })
 
});