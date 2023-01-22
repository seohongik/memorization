/**실행 컨텍스트와 콜 스택 */

//-------------(1)
var a = 1;

function outer(){

    function inner(){

        console.log(a); //undefined
        var a  = 3;
    }

    inner(); //------------(2)
    console.log(a); //1
}

outer(); //--------------(3)
console.log(a); //1


/**매개변수와 변수에 대한 호이스팅(1) - 원본코드 */

function a(x){

    console.log(x); //1

    var x;

    console.log(x);// undefined =>1


    var x = 2;

    console.log(x); //2

}

a(1);

// evnvironmentRecord는 현재 실행될 컨텍스트의 대상 코드 내에 어떤 식별자들이 있는지만 관심이있고 각 식별자에 어떻 값이 할당될 것인지는 관심이 없다. 

function a(){

    var x;
    var x;
    var x;

    x =1;
    console.log(x);
    console.log(x);

    x =2;
    console.log(x);

}

a(1);


/** 함수 선언의 호이스팅 */

function a(){

    console.log(b); //undifined =>func

    var b = "bbb";
    console.log(b); //bbb

    function b(){} 

    console.log(b); //func =>bbb


}
a();

function a(){

    var b;
    function b(){}

    console.log(b);

    b='bbb'

    console.log(b);
    console.log(b);

}

a();

/** 함수를 정의하는 세가지 방식 */

function a(){} // 험수 선언문

a();

var b = function(){} // 익명함수 표현식 변수명 b가 곧 하수명
b();

var c =function d(){}; // 기명 함수 표현식 변수명 c 함수명 d

c();
d(); //에러


/**함수 선언문과 함수 표현식 */

console.log(sum(1,2)); //3
console.log(multiply(3,4)); //error

function sum(a,b){

    return a+b;
}

var multiply = function(a,b){

    return a*b; 
}

/** gkatn 선언문의 위험성*/
function a (){} // 되도록 => var a = function(){} 으로 사용하자 호이스팅 때문에 실제로 호출되는 함수는 오직 마지막에 할당된 함수 즉 맨 마지막에 선언된 함수가 실행된다


/**스코프 체인 */

var a = 1;

function outer(){

    function inner(){

        console.log(a); //undefined
        var a  = 3;
    }

    inner(); //------------(2)
    console.log(a); //1
}

outer(); //--------------(3)
console.log(a); //1

//무조건 스포크 체인 상에서 가장 먼저 발견된 식별자에만 접근 가능 


/** 스코프 체인 확인(1) 크롬 전용 */

var a = 1;
 
var outter = function(){

    var b = 2;

    var inner = function(){
        console.log(b);
        debugger;
    };

    inner();
};

outter();