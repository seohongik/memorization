$(document).ready(function(){

    $(".box1").on("click", function(){
        $("p").text("box1을 클릭 해버렸다.");
    });

    $(".box2").on("click", function(){
        $("p").text("box2를 클릭 해버렸다.");
    });

    $(".box1").on("mouseenter", function(){
        $("p").text("box1에 마우스를 올려버렸다.");
    });

    $(".box1").on("mouseleave", function(){
        $("p").text("box1에 마우스가 사라져버렸다!.");
    });

    $(".box1").on("mousemove", function(){
        $("p").text("box1에 마우스가 무빙하고있다!.");
    });

    $(".box2").on("mouseenter", function(){
        $("p").text("box2에 마우스를 올려버렸다!!!!.");
    });

    $(".box2").on("mouseleave", function(){
        $("p").text("box2에 마우스가 사라져버렸다!.");
    });

    $(window).on("scroll", function(){
        $("p").text("화면이 움직인다!!")
    });

});