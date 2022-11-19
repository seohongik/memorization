$(document).ready(function(){

    $("button").on("click",function(){
        var num = $("input").val();

        if(num==""){
            alert("아무런 정보도 입력안했음;;")
        } else if(num>=19) {
            alert("어른이네요")
        } else if (num<19) {
            alert("아직 어른이 아닙니다.")
        } else {
            alert("숫자만 입력하세요.")
        }
    });

});