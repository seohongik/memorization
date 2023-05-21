/* 06 프로토타입 */

// 자바스크립트는 프로토타입 기반 언어 
// 클래스 기반 언어 -> 상속 
// 프로토타입 기반 언어 -> 객채를 원형으로 삼고 복제(참조)


/* Person.prototype */

var Person = function(name){
    this._name = name;
}

Person.prototype.getName = function(){
    return this._name;
}

var suzi= new Person('Suzi'); 

console.log(suzi); // Person

console.log(suzi.getName()); //Suzi

console.log(suzi.__proto__.getName()); //undefined

console.log(Person.prototype === suzi.__proto__); //true

//instance의 __proto__ 가 Constructor 의 prototype 프로퍼티를 참조 -> 결국 둘은 같은 객체를 바라 보기 때문에 true

// 어떤 변수를 실행해 undefined가 나왔다는 것은 이 변수가 '호출할 수 있는 함수'에 해당한다는 것을 의미 
// 함수가아닌 다른 데이터 타입 이었으면 TypeError가 발생
// 그러나 getName은 그러지 않았으므로 함수이고 실제 실행 됐음을 입증

/** 
 * 
 * 어떤 함수를 메서드로 호출 할때 this는 메서드가 된다.
 * suzi.__proto__.getName()에서 getName 함수 내부에서의 this는 suzi가 아니라 suzi_.__proto__라는 객체가 되는 것
 * 
 * 찾고자 하는 식별자가 정의돼 있지 않을 때는 Error 대신 undefinded를 반환한다. 
 * 
 */

/*undifined 해결법*/

var suzi = new Person('Suzi');

suzi.__proto__._name = 'Suzi_프로토_';

console.log(suzi.__proto__.getName());

console.log(suzi.getName()); 

//why??
//-> __proto__ 가 생략 가능한 프로퍼티이기 때문
// 이해의 영역이 아니라 창시자의 관점


// 생성자 함수의 prototype에 어떤 메서드나 프로퍼티가 있다면 인스턴스에서도 마치 자신의 것처럼 해당 메서드나 프로퍼티에 접근 할 수 있다.


//prototype 과 __proto__

var Constructor  = function(name){
    this.name = name;
};

Constructor.prototype.method1 = function(){};
Constructor.prototype.prototype1 = 'Constructor Prototype Property';

var instance  = new Constructor('Instance');

console.dir(Constructor);
console.dir(instance);


/* constructor 프로퍼티 */

/*생성자 함수의 프로퍼티인 prototype 객체 내부에는 constructor 라는 프로퍼티가 있다. 
  인트턴스의 __proto__객체 내부에도 마찬가지 이 프로퍼티는 단어 그대로 원래의 생성자 함수(자기자신을 참조)
  -> 인스턴스로 부터 그 원형이 무엇인지를 알 수 있는 수단

*/

var arr = new Array(1,2); // [1,2]

console.log(Array.prototype.constructor === Array) //true

console.log(arr.__proto__.constructor === Array) // true

console.log(arr.constructor===Array) //true

var arr2 = new arr.constructor(3,4);

console.log(arr2); // [3,4]

/**
 * 
 * constructor를 변경하더라도 참조하는 대상이 변경될 뿐 
 * 이미 만들어진 인스턴스의 원형이 바뀐 다거나 데이터 타입이 변하는 것을 아니다.
 */


/** 다양한 constructor 접근 방법 */

var Person = function(name){
    this.name = name;
};

var p1 = new Person('사람1');

var p1Proto = Object.getPrototypeOf(p1);

var p2 = new Person.prototype.constructor('사람2');

var p3 = new p1Proto.constructor('사람3');

var p4 = new p1.__proto__.constructor('사람4');

var p5 = new p1.constructor('사람5');

[p1,p2,p3,p4,p5].forEach(function(eachPerson){

    console.log(eachPerson, eachPerson instanceof Person);

});

// all true 


//프로토타입 체인

//메소드 오버라이드 

/*
prototype 객체를 참조하는 __proto__를 생략하면 인스턴스는 prototype에 정의된 프로퍼티나 메서드를 
마치 자신의 것처럼 사용할 수 있음

하지만 만약 인스턴스가 동일한 이름의 프로퍼티 또는 메서드를 가지고 있는 상황이라면??
*/

//메서드 오버라이드

var Person = function(name){
    this.name = name;
};

Person.prototype.getName = function(){
    return this.name;
};


var iu = new Person('지금');

iu.getName = function(){
  return '바로' + this.name;  //바로 지금
};

console.log(iu.getName()); //바로 지금

//iu.__proto__.getName()이 아닌 iu객체에 있는 getName 메서드가 호출 
// 여기서 일어난 현상을 메서드 오버라이드라고 한다. => 덮어 씌움

//교체가 아닌 덮어씌운다는 의미 -> 원본에 접근 할 수 있다. 

console.log(iu.__proto__.getName()) // undefined

Person.prototype.name = '이지금';
console.log(iu.__proto__.getName()) // 이지금

// this가 프로토타입을 바라보고 있는데 이걸 인스턴스를 바라보도록 바꾸기 

console.log(iu.__proto__.getName.call(iu)); //지금

console.log(iu.getName()); //바로 지금


/*프로토타입 체인*/

// 기본적으로 모든 객체의 __proto__에는 Object.prototype이 연결. prototype 객체도 예외가 아니다. (자바와 비슷한가?)


//프로토타입 체이닝은 메서드 오버라이드와 동일한 맥락
/**
 * 
 * 어떤 메서드를 호출하면 자바스크립트 엔진은 데이터 자신의 프로퍼티들을 검색해서 원하는 메서드가 있으면 그 메서드 실행
 * 없으면 __proto__를 검색해서 있으면 그 메서드 실행 
 * 다시 없으면 __proto__를 검색해서 실행 (타고 올라간다?)
 * 
 * 
 */

var arr = [1,2];

console.log(Array.prototype.toString.call(arr)); //1,2

console.log(Object.prototype.toString.call(arr)) //object Array

console.log(arr.toString()) // 1,2

arr.toString = function(){

    return this.join('-');
}

console.log(arr.toString()); //1-2


//6-2-3  객체 전용 메서드의 예외 사항 [여기서 부터 다시 볼 필요 있음 이해가 잘 안됨]

/**
 * 
 * 어떤 생성자 함수이든 prototype은 반드시 객체이기 때문에 Object.prototype이 언제나 프로토타입 체인의 최상단에 존재
 * 따라서 객체에서만 사용할 메서드는 다른 여느 데이터 타입처럼 
 * 프로토타입 객체 안에 전의할 수가 없다. 
 * 
 * 객체에서만 사용할 메서드를 Object.prototype 내부에 정의하면 다른 테디어 타입도 해당 메서드를 사용할 수 있게 되기 때문
 * 
 * 
 */


//6-2-4 다중 프로토타입 체인

//-> 생성자 함수의 prototype이 연결하고자 하는 상위 생성자 함수의 인스턴스를 바라보게끔 해주면 된다. 


var Grade = function(){

    var args = Array.prototype.slice.call(arguments);

    for( var i =0; i<args.length; i++){

        this[i]=args[i];
    }

    this.length = args.length;


}

var g = new Grade(100,80);

/*

변수 g는 Grade의 인스턴스를 바라봅니다. 
배열의 형태를 지니지만 배열의 메서드를 사용할 수 없는 유사배열 객체 dlek
유사 배열에 배열 메서드를 적용하는 방법으로 call apply를 소개 했지만 
인스턴스에서 배열 메서드를 직접 쓸 수 있겠끔 하고 싶을 때 

g.__proto__ 즉 Grade.prototype이 배열의 인스턴스를 바라보게 하면 된다. 

Grade.prototype = [];
*/



var Grade = function(){

var args = Array.prototype.slice.call(arguments);

for( var i =0; i<args.length; i++){

    this[i]=args[i];
}

this.length = args.length;


}
Grade.prototype = [];

var g = new Grade(100,80);



g.push(10);

console.log(g);

/** 정리 (프로토타입)
 * 
 * 어떤 생성자 함수를 new 연산자와 함께 호출하면 Constructor에서 정의된 내용을 바탕으로 새로운 인스턴스가 생성되는데 
 * 이 인스턴스에는 __proto__라는 Constructor의 prototype 프로퍼티를 참조하는 프로퍼티가 자동으로 부여
 * __proto__는 생략 가능한 속성이라서 인스턴스는 Constructor.prototype의 메서드를 마치 자기자신의 메서드 인 것처럼 호출 할 수 있다. 
 * 
 * Constructor.prototype에는 constructor 라는 프로퍼티가 있는데 , 이는 다시 생성자 함수 자신을 가르킨다. 
 * 이 프로퍼티는 인스턴스가 자신의 생성자 함수가 무엇인지를 알고자 할 때 필요한 수단
 * 
 * __proto__ 의 최종은 Object.prototype에 당도하게 된다. 
 * 이런식으로 __proto__ 에 __proto__를 찾아가는 과정을 프로토타입 체이닝 (오버라이딩) 이라고 하며 
 * 프로토 타입 체이닝을 통해 각 프로토타입 메서드를 자신의 것처럼 호출 할 수 있다. 
 * 이때 접근 방식은 자신으로부터 가장 가까운 대상 부터 점차 먼 대상으로 나아가며 원하는 값을 찾으면 검색 중당
 * 
 * Object.prototype에는 모든 데이터 타입에서 사용할 수 있는 범용적인 메서드만 존제 
 * 객체 전용 메서드는 스태틱하게 담겨있다 ..
 * 
 * 
 *
 * 
 * 
*/

