//this 

//this 는 함수를 호출할 때 결정된다.
/*브라우저 환경*/
console.log(this);
console.log(window);
console.log(this==window);

/*Node.js환경 */
console.log(this)
console.log(global);
console.log(this==global);


/*자바스크립트의 모든 변수는 실은 특정 객체의 프로퍼티로서 동작 */

/*
  전역변수를 선언하면 자바스크립트 엔진은 이를 전역객체의 프로퍼티로 할당한다.(o)
*/
var a =1;
console.log(a); //1
console.log(window.a); //1
console.log(this.a) //1

var a =1;
window.b =2;
console.log(a,window.a,this.a); //1 1 1
console.log(b,window.b,this.b); //2 2 2

window.a=3;
b=4;
console.log(a,window.a,this.a) //3 3 3
console.log(b,window.b,this.b);//4 4 4 


//////////////////// 전역객체의 프로퍼티로 할당한 경우는 삭제/ 전역변수로 선언한 경우는 삭제 ㅌ
/*
전역변수로 선언하면 자바스크립트 엔진이 이를 자동적을로 전역객체의 프로퍼티로 할당하면서 추가적으로 해당 프로퍼티의 configurable속성(변경 삭제 가능성)을 false로 정의
*/

var a = 1;
delete window.a; //false
console.log(a,window.a,this.a); //1 1 1

var b = 2;
delete b; //false
console.log(b,window.b,this.b); //2 2 2


window.c = 3;
delete window.c; //true
console.log(c,window.c,this.c); //UnCaught ReferenceError: c is not defined

window.d = 4;
delete d; //true
console.log(d,window.d,this.d); //UnCaught ReferenceError: d is not defined

/* 
함수 vs 메서드 
독립성 => 함수는 그 자체로 독립정 기능을 수행 메서드는 자실을 호출한 객체에 관한 동작 수행
*/

//. 이없으면 함수 .이 있으면 메서드

var func = function(x){
    console.log(this,x);
}

func(1);


var obj = {
    method:func
};

obj.method(2);

//대괄호 표기법
var obj={
    method :function(x){console.log(this,x);}
}

obj.method(1) ;
obj['method'](2);
//메서드 내부의 this는 호출한 주체에 대한 정보가 담긴다 즉 점 표기법의 경우 마지막 점 앞에 명시된 객체가 곧 this


//함수로서 호출될 때 그 함수 내부에서의 this

//함수 내부에서의 this
/*
어떤 함수를 함수로서 호출할 경우에는 this가 지정되지 않는다. this는 호출 주체인데 함수로서 소출하는 것은 호출 주체를 명시하지 않고 개발자가 코드에 직접 관여해서 실행한 것이 때문
호출 주체의 정보를 알 수 없는 것 
this가 지정되지 않는경우 전역객체를 바라봄 

=> 따라서 함수의 this는 전역 객체 를가르킴 

*/

var obj1 = {

    outer:function(){
        console.log(this); //obj1

        var innerFunc= function(){
            console.log(this); // window //obj2
        }

        innerFunc();

        var obj2={

            innerMethod:innerFunc
        };

        obj2.innerMethod();
    }
   
}

obj1.outer();



/* this의 우회 하는 방법 */

var obj = {

    outer: function(){
        console.log(this) //{outer :f}

        var innerFunc1 = function(){
            console.log(this); //window {}
        };

        innerFunc1();

        var self =this;
        
        var innerFunc2 = function(){
            console.log(self); // {outer :f}
        }

        innerFunc2();
    }
};

obj.outer();

/* arrow function = this를 바인딩하지 않는 함수 */

var obj ={
    outer: function(){
        console.log(this); //{outter :f}
        var innerFunc = ()=>{
            console.log(this);  //{outter :f}
        };
        innerFunc();
    }
};

obj.outer();

/* 콜백 함수 호출 시 그 함수 내부에서의 this */

//콜백함수 => 함수 A의 제어권을 다름함수 B에게 넘겨주는 경우 함수 A를 콜백 함수라고 한다.
// 이때 함수 A는 함수 B의 로직에 따라 실행 되며 this 역시 함수 B 내부로직에서 정한 규칙에 따라 값이 결정됨
// 콜백 한수에서의 this는 무조건 이거다 라고 정의할 수 없다. 콜백함수의 제어권을 가지는 함수 가 콜백 함수에서의 this를 무엇으로 할지를 결정하며 특별히 정의되어있지 않은 경우는 기본적인 함수와 마찬가리고 전역객체를 바라봄

setTimeout(function(){console.log(this)},300); //window {}

[1,2,3,4,5].forEach(function(x){
    console.log(this,x); //window {} ,window {},...
});

document.body.innerHTML +='<button id="a" >클릭</button>';
document.body.querySelector('#id').addEventListener('click',function(e){
    console.log(this,e); //// '<button id="a">클릭</button>'...
});

/*생성자의 this==>(new 명령어와 함께 함수를 호출) 하면 prototype 프로퍼티를 참조하는 __proto__라는 프로퍼티가 있는 객체(인스턴스)를 만들고 , 
 미리 준비된 공총 속성 및 개성을 해당 객체(this)dp qndu 
 
 객체지향의 this란 의미
*/

var Cat = function(name,age){

    this.bark = "야옹"
    this.age = age;
    this.name = name;
}

var choco = new Cat('초코', '7');
var nabi = new Cat('나비', '5');

console.log(choco,nabi);
/*
Cat {bark: '야옹', age: '7', name: '초코'} Cat {bark: '야옹', age: '5', name: '나비'}
*/


