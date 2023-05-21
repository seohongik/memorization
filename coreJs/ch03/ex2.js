/* 명시적으로 this를 바인딩 하는 방법 */

//call 메서드
/*call 메서드는 메서드의 호출 주체인 함수를 즉시 실행하도록 하는 명령어 
 이때 call 메서드의 첫 번재 인자를 this로 바인딩하고 이후의 인자들을 호출할 함수의 매개변수로 한다. 
함수를 그냥 실행하면 this는 전역객체를 참조하지만 call메서드를 이용하면 임의의 객체를 this로 지정할 수 있다. 
*/

//call 1
var func= function (a,b,c) {
    console.log(this,a,b,c);
};

func(1,2,3); //window 1 2 3

func.call({x:1},4,5,6); //objct 4.5.6


//call 2

var obj ={
    a:1 ,
    method : function(x,y){
        console.log(this.a,x,y);
    }
};

obj.method(2,3); //1,2,3

obj.method.call({a:4},5, 6) //4,5,6


//apply 메서드
/*
call 메서드와 기능적으로 완전히 동일 call 메서드는 첫 번재 인자를 제외한 나머지 모든 인자들을 
호출할 함수의 매개변수로 지정하는 반면 apply메서드는 두 번재 인자를 배열로 받아 그 배열의 요소들을 호출할 함수의 매개변수로 지정한다.
*/

var func = function(a,b,c){

    console.log(this,a,b,c);
};

func.apply({x:1},4 , 5, 6 ) //{x:1}, 4, 5, 6

var obj = {

    a:1,
    method: function(x,y){

        console.log(this.a,x,y);
    }
}

obj.method.apply({a:4}, [5,6]) //4 5 6 


//call/apply 활용

//유사 배열 객체 에 배열 메소드 적용

var obj={
    0:'a',
    1:'b',
    2:'c',
    length:3
}

Array.prototype.push.call(obj,'d') 

console.log(obj); //{ 0:'a' , 1:'b' , 2:'c' , 3:'d' length:4}

var arr = Array.prototype.slice.call(obj);

console.log(arr); //['a','b','c','d']

/*객체에는 배열 메서드를 직접 적용 불가  그러나 키가 0 또는 양의 정수인 프로퍼티가 존제하고 length 프로퍼티값이 0보다 큰 정수일때 
    유사한 객체의 경우 call apply 메서드를 이용 배열 메서드를 차용 가능 
    

    * slice => 원래 시작인덱스 값과 마지막 인덱스 값을 받아 시작 값부터 마지막값까지 배열 요소를 추출 하는 메서드 인데, 
               매개변수를 나무것도 넘기지 않을 경우 원본 배열의 얕은 복사 수행 
               
               slice 메서드가 배열 메서드 이기에 복사본은 배열로 된거임

*/


// arguments 객체도 유사배열객체 
// querySelectorAll, getElementsByClassName, Node 선택자로 선택한 결과인 NodeList도 마찬가지 

// call / apply 메서드의 활용 1-2) arguments , NodeList에 배열 메서드 적용

function a(){

    var argv = Array.prototype.slice.call(arguments);

    argv.forEach(function(arg){

        console.log(arg);
    })
}

a(1,2,3);
document.body.innerHTML = '<div> a </div> <div> b </div> <div> c </div>';

var nodeList= document.querySelectorAll('div');

var nodeArr = Array.prototype.slice.call(nodeList);

nodeArr.forEach(function(node){

    console.log(node);
}); //=> 디버깅 안됨

//문자열에 경우에도 call /apply 마찬 가지지만 length 프로퍼티가 읽기 전용이라 변경(push,pop,shift,unshift,splice)는 에러를 던지며 
//concat처럼 대상이 반드시 배열 이어야하는 경우에는 에러는 나지 않지만 제대로 된 결과를 얻을 수 없다. 

/* ES6의 Array.from 메서드 , slice와 유사 */

var obj={
    0:'a',
    1:'b',
    2:'c',
    length:3
}

var arr = Array.from(obj);

console.log(arr); //['a','b','c']


//생성자 내부에서 다른 생성자 호출 

function Person(name,gender){
    this.name = name;
    this.gender = gender;
}


function Student(name,gender,school){
    Person.call(this,name,gender);
    this.school = school

}


function Employee(name,gender,company){
    Person.apply(this,[name,gender]);
    this.company = company

}


var by = new Student('보영','female','단국대');
var jn = new Employee('재난','male','구골');

console.log(by);
console.log(jn);


// 여러 인수를 묶어 하나의 배열로 전달하고 싶은 때 apply 활용
// 예를 들어 배열에서 최대 최소값을 구해야 할 경우 apply를 사용하지 않으면 포문 돌리고 해야함

var numbers=[10,20,3,15,45];

var max = min = numbers[0];

numbers.forEach(function(numbers){

    if(number>max){
        max = numbers;
    }

    if(numbers<min){
        min = numbers;
    }

});

console.log(max,min);



var numbers=[10,20,3,15,45];

var max = Math.max.apply(null,numbers);
var min = Math.min.apply(null,numbers);

//call /apply 메서드 활용 ES6 펼치기 연산자 활용

const numbers=[10,20,3,15,45];
const max = Math.max(...numbers);
const min = Math.min(...numbers);

console.log(max,min);

//bind


//call과 비슷하지만 즉시 호출하지 않고 넘겨받은 this 및 인수들을 바탕으로 새로운 함수를 반환하기만 하는 메서드 
//다시 새로운 함수를 호출할 때 인수를 넘기면 그 인수들은 기존 bind 메서드를 호출할 때 전달 했던 인수들의 뒤에 이어서 등록   


//즉 bind 메서드는 함수에 this를 미리 적용하는것과 부분 적용 함수를 구현 하는 두가지 목적을 모두 지닙


//bind 메서드 - this 지정과 부분 적용 함수 구현
var func = function(a,b,c,d){

    console.log(this,a,b,c,d);
}


func(1,2,3,4); //window{ } ,1,2,3,4

var bindFunc1 = func.bind({x:1});

bindFunc1(5,6,7,8,) //{x:1} 5 6 7 8  //=> bind에 this만 지정한것

var bindFunc2 = func.bind({ x:1 },4,5)

bindFunc2(6,7) //{x:1} 4 5 6 7 //=> bind에 부분 적용함수 구현한것

bindFunc2(8,9) //{x:1} 4 5 8 9 //=> bind에 부분 적용함수 구현한것


//bind 메서드 - name 프로퍼티 
/** bind 메서드를 적용해서 새로 만든 함수는 name프로퍼티에 bound라는 접두어가 붙음
    추적하기에 쉬움
 */



var func = function(a,b,c,d){
    console.log(this,a,b,c,d);
};

var bindFunc = func.bind( { x:1 },4 ,5 );

console.log(bindFunc());  // => 4,5,undefinded,undefinded

console.log(func.name); //func
console.log(bindFunc.name); //bound func

//상위 컨텍스트의 this를 내부함수나 콜백 함수에 전달라기 

/*
    3-1-3절 메서드의 내부함수에서 this 를 우회하는 방법 self등의 변수를 활용하는 우회법을 소개했는데  call apply bind 메서드를 이용하면 
    더 깔끔히 처리할 수 있다.
*/

var obj = {

    outer:function(){

        console.log(this);

        var innerFunc = function(){
            console.log(this);
        };

        innerFunc.call(this);
    }
};

obj.outer();


var obj = {

    outer:function(){

        console.log(this);

        var innerFunc = function(){
            console.log(this);
        }.bind(this);

        innerFunc();
    }
};

obj.outer();

//bind 메서드 - 내부함수에 this 전달


var obj = {

    logThis:function(){
        console.log(this);
    },

    logThisLater1:function(){
        setTimeout(this.logThis,500);
    },

    logThisLater2:function(){
        setTimeout(this.logThis.bind(this),1000);
    }


};

obj.logThisLater1(); //window{...}
obj.logThisLater2(); //obj{ logThis: f...}

//화살표 함수의 예외사항

//ES6에 새로 도입된 화살표 함수는 실행 컨텍스트 생성시 this를 바인딩 하는 과정이 제외  
//함수내부에 this가 없으며 접근하고자 하면 스코프 체인상 가장 가까운 this에 접근하게 됨

var obj ={

    outer:function(){
        console.log(this);

        var innerFunc=()=>{
            console.log(this);
        };

        innerFunc();
    }

}
obj.outer();

//콜백함수 +this


var report={

    sum:0,
    count:0,
    add: function(){
        var args = Array.prototype.slice.call(arguments);

        args.forEach(function(enrty){

            this.sum +=enrty;
            ++this.count;

        },this);

    },

    average: function(){
        return this.sum/this.count;
    }

}

report.add(60,85,95);

console.log(report.sum, report.count, report.average())

// 아래와 같음 

var report={

    sum:0,
    count:0,
    add: function(){
        var args = Array.prototype.slice.call(arguments);

        args.forEach(function(enrty){

            this.sum +=enrty;
            ++this.count;

        },report);

    },

    average: function(){
        return this.sum/this.count;
    }

}

report.add(60,85,95);

console.log(report.sum, report.count, report.average())


//콜백 함수와 함께 thisArg를 인자로 받는 메서드 

/*
Array.prototype.forEach(callback[, thisArg]);

Array.prototype.map(callback[, thisArg]);

Array.prototype.filter(callback[, thisArg]);

Array.prototype.every(callback[, thisArg]);

Array.prototype.find(callback[, thisArg]);

Array.prototype.findIndex(callback[, thisArg]);

Array.prototype.from(callback[, thisArg]);

Set.prototype.forEach(callback[, thisArg]);

Map.prototype.forEach(callback[, thisArg]);
*/


//정리 

/* 다음 규칙은 명시적 this바인딩이 없는 한 늘 성립 */

/*
1. 전역공간에서의 this는 전역객체(브라우저에서는 window Node.js는 global ) 참조

2. 어떤 함수를 메서드로 호출한 경우 this는 메서드 호출 주체(메서드명 앞의 객체)참조 

3. 어떤 함수를 함수로서 호출한 경우 this는 전역객체를 참조합니다. 메서드의 내부함수에서도 같습니다. 

4. 콜백 함수 내부에서의 this는 해당 콜백 함수의 제어권을 넘겨받은 함수가 정의한 바에 따르며 , 정의하지 않는 경우에는 전역객체 참조

5. 생성자 함수에서의 this는 생성될 인스터스 참조 
*/

/* 명시적 this 바인딩 */

/*

1. call apply 메서드는 this를 명시적으로 지정하면서 함수또는 메서드 호출

2. bind 메서드는 this 및 함수에 넘길 인수를 일부 지정하여 새로운 함수를 만듬

3. 요소를 순회하면서 콜백 함수를 반복 호출 하는 내용의 일부 메서드는 별도의 인자로 this를 받기도 함

*/


