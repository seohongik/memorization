
/* 선언 후 초기화 */
var a;
a='abc';
/* 선언과 동시에 초기화 */
var a='abc';


/*1-3 불변성*/
var a = 'abc';
a = a+'def'; //새주소에 abcdef 저장

var b = 5;//새주소 할당
var c = 5;//b 값 주소 저장
b=7; //새주소 할당(b값 주소 참조 하지 않음 7이 데이터영역에 없기 때문에);

/* 참조형 데이터 할당 */
var obj1 = { /* 먼저 obj1 주소 저장  */
    a:1,   /* 데이터 영역 1 검색 없으면 할당 후 a 주소 저장 그리고 oj1 주소 참조*/
    b:'bbb' /* 데이터 영역 'bbb'검색 없으면 할당 후 b 저장 (a의 주소와 다름) 그리고  obj1 주소 참조*/
}

//즉 데이터 영역에 저장된 값은 모두 불변값 

obj1.a = 2; /* 데이터영역에 2 없으면 새 할당 a 주소 참조 후 obj1 주소 참조 */

var obj  = { /* 먼저 obj 주소 할당 */

    x:3, /* 데이터 영역에 3 검색 없으면 데이터 할당후 x 주소 저장 obj 주소 저장 */
    arr:[3,4,5] /* 변수가 3개니 3개의 변수공간 확보 인덱스 부여 
                    3이 데이터 영역에 있으니 새 할당 없이 재사용
                    4 없으니 데이터 영역에 새 할당 obj 주소 참조
                    5 없으니 데이터 영역에 새 할당 obj 주소 참조 
                */
};
obj.arr = 'str' /* obj.arr 데이터 영역에 str 저장 후 (str이 데이터 영역에 없으니) obj 주소 참조*/







/* 변수 복사 그리고 이후 값 변경 결과 비교*/
var a  = 10;  /*주소 1000 확보후 데이터 영역 주소 값(@5000)에 10 참조 */
var b = a; /* a와 서로 다른 주소 1001 확보 후 데이터 공간에 10(@5000)이 있으니 @5000 들고 와서 주소 1001에 참조 */

/*
    주소   1000         1001
    데이터   a 값 @5000   b 값 @5000
    주소   @5000
    데이터  10

*/

var obj1 = {c:10, d:'ddd'}; 
var obj2 = obj1 //위와 동일하게 동작 obj1과 서로다른 주소 확보후 obj1 데이터영역에서 값 들고와서 참조후 새로 만들어진 주소에 저장


b=15; // a!==b  // 데이터 영역에 15가 없으니 @5004 확보후 15할당 ( 참조되는 주소가 달라짐)

/*
    주소   1000         1001
    데이터   a 값 @5000   b 값 @5004
    주소   @5000          @5004   
    데이터  10              15

*/

obj2.c = 20; //obj === (내부 프로퍼티만 바뀌었으니) obj2는 여전히 obj1의 @주소를 사용(obj1과 obj2는 참조되는 주소가 같음)

/* 참조형 
객체자체를 변경하면 주소가 달라짐 
var obj1 = {c:10, d:'ddd'}; 
var obj2 = obj1
var obj2 ={c:10,d:'ddd'}
obj2 는 새 할당 됨
*/

//결론 :: 자바스크립트의 모든 데이터는 엄밀히 말하면 참조형 데이터 다만 기본형은 주솟값을 복사하는 과정이 한번 만 이루워지고 참조형은 한단게 더 거치게 된다는 차이가있다.


/*매번 객체를 새로 만들면 불변할 수 있음*/

/* 객체 가변성에 따른 문제 */

var user ={
    name:'Jaenam',
    gender:'male'
};

var chageName = function(user,newName){
    var newUser = user;  //newUser과 user은 같은 주소를 바라봄
    newUser.name= newName; //newUser.name 과 user의 프로퍼티가 같이 바뀜
    return newUser;
};
var user2 = chageName(user,'Jung'); 

if(user !== user2){ //false

    console.log('유저 정보가 변경 되었습니다.')
}

//같은 주소를 바라보니 아래와 같은 결과가 나옴

console.log(user.name,user2.name); // Jung , Jung
console.log(user === user2); //true


/*객체 가변성에 따른 문제 해결 */

var user ={
    name:'Jaenam',
    gender:'male'
};

var chageName = function(user,newName){   
    return {

        name:newName,
        gender: user.gender
    };
};
var user2 = chageName(user,'Jung'); 

if(user !== user2){ //true

    console.log('유저 정보가 변경 되었습니다.')
}
//같은 주소를 바라보니 아래와 같은 결과가 나옴
console.log(user.name,user2.name); // Jaenam , Jung
console.log(user === user2); //false

/*객체의 가면성에 따른 문제 해결 copyObJect함수 이용 */

var copyObJect = function(targect){  
    var result ={};

    for(var prop in targect){
        result[prop]  = targect[prop];
    }
    return result;

}


var user ={
    name:'Jaenam',
    gender:'male'
};

var user2 = copyObJect(user); // 새 주소 할당하고

user2.name = 'Jong' // 새객에의 내부 프로퍼티 중첩 객체가 아님

if(user !== user2){ //true

    console.log('유저 정보가 변경 되었습니다.')
}
//같은 주소를 바라보니 아래와 같은 결과가 나옴
console.log(user.name,user2.name); // Jaenam , Jung
console.log(user === user2); //false

/*참고사항 immutabls.js ,baobab.js 불변객체 라이브러리*/


/* 얕은 복사 깊은 복사 */
// 얕은 복사 바로 아래 단계의 값만 복사
// 깉은 복사 내부의 모든 값들을 하나하나 찾아서 전부 복사하는 방법

// copyObject 얕은 복사 중첩된 객체에서 참조형 데이터가 저장된 프로퍼티틑 복사하라때 그 주솟값만 복사한다는 뜻 아래 코드 참조

var user = { //중첩 객체
    name:'Jaenam',
    urls:{
        portfolio :'http://github.com/hong',
        blog : 'http://blog.com',
        facebook: 'http://facebook.com/hong'
    }
};

var user2 = copyObJect(user);

user2.name = 'Jong'; 
console.log(user.name==user2.name) //false

user.urls.portfolio = 'http://portfolio.com';
console.log(user.urls.portfolio==user2.urls.portfolio) //true; 

user2.urls.blog = '';
console.log(user.urls.blog==user2.urls.blog) //true; 

//얕은 복사는 한단계 더 들어가면 기존 데이터를 그대로 참조


/* 중첩된 객체에 대한 깊은 복사 */

var user2 = copyObJect(user);
user2.urls = copyObJect(user.urls);

user.urls.portfolio = 'http://portfolio.com';
console.log(user.urls.portfolio==user2.urls.portfolio) //false; 

user2.urls.blog = '';
console.log(user.urls.blog==user2.urls.blog) //false; 

// 기본형 데이터 일 경우에는 그대로 복사 되지만 참조형 데이터의 다시 그 내부의 프로퍼티를 복사 해야 비로서 깊은 복사

/* 객체의 깊은 복사를 수행하는 범용함수 */

var copyObJectDeep = function(targect){

    var result = {};

    if(typeof targect ==='object' && targect !==null){ // null에 대해서도 oject를 반환 한다 자바스크립트 버그

        for(var prop in targect){

            result[prop]  = copyObJectDeep(targect[prop]); // 재귀 호출하면서 깊은 복사
        }

    }else{
        result = targect; // 기본형 대비
    }
    return  result;
}

/* 깊은 복사 결과 확인 */
 
var obj = {
    a:1,
    b:{
        c:null,
        d:[1,2]
    }
};

var obj2 = copyObJectDeep(obj);

obj2.a = 3;
obj2.b.c = 4;
obj.b.d[1] = 3;

console.log(obj);

/*
obj = {
    a:1,
    b:{
        c:null,
        d:[1,3]
    }
};
*/


console.log(obj2);

/*
obj2 = {
    a:3,
    b:{
        c:4,
        d:[1,2]
    }
};
*/

/* 참조 1.hasOwnProperty 메서드 이용하여 프로토타입 체이닝 통해 상속된 프로퍼티 복사하지 않게 할 수 있음 
       2. ES5 getter setter를 통해 복사하는 방법은 
       ES6의        Object.getOwnPropertyDesciptor
       Es2017의     Object.getOwnPropertyDesciptors 외에는 없음 
*/



/*JSON을 활용한 간단한 깊은 복사*/
var copyObJectJViaJSON = function(targect){

    return JSON.parse(JSON.stringify(targect));
}; // 함수 숨겨진 프로퍼티: __proto_ 나 getter/setter 등과 같이 JOSN으로 변경할 수 없는 프로퍼티 무시 httpRequest로 받은 데이터를 저장한 객체를 복사할때 유용


var obj = {
    a:1,
    b:{
        c:null,
        d:[1,2],
        func1 : function(){console.log(3);},
        func2 : function(){console.log(4);}
    }
};

var obj2 = copyObJectJViaJSON(obj);

obj2.a = 3;
obj2.b.c = 4;
obj.b.d[1] = 3;

console.log(obj); 

/*
obj = {
    a:1,
    b:{
        c:null,
        d:[1,3],
        func1 : f(),
        func2 : f()
    }
};
*/


console.log(obj2);

/*
obj2 = {
    a:3,
    b:{
        c:4,
        d:[1,2],
    }
};
*/


/* undefined 와 null */

// 자바스크립트에 없음 을 나타내는 값 두가지 undefined null 
/*

undefined 사용자가 지정
값이 존재하지 않을때 자바스크립트 엔진이 자동으로 부여
사용자가 응당 어떤 값을 지정할 것이라고 예상되는 상황에도 그렇게 하지 않았을 때 

1. 값을 데입하지 않은 변수 , 즉 데이터 영역의 메모리에 주소를 지정하지 않은 식별자에 접근
2. 객체 내부에 존재하지 않은 프로퍼티에 접근할려고 할 때 
3. return 문이 없거나 호출 되지 않은 함수의 실행 결과

*/

var a;
console.log(a); // (1) undefinded 값을 대입하지 않은 변수

var obj  = {a:4};

console.log(obj.a); // 4
console.log(obj.b); // (2) undefinded 객체 내부에 존재하지 않은 프로퍼티에 접근
console.log(b); // c.f) ReferenceError : b is not defined

var func = function(){} 
var c = func(); // (3) 반환(return) 값이 없으면 undefined를 반환한 것으로 간주
console.log(c); //(3) undefinded 


/* undefined와 배열 */
var arr1 = [];
arr1.length =3;

console.log(arr1); //[empty x 3]

var arr2 = new Array(3); 
console.log(arr2); //[empty x 3]

var arr3 = [undefined,undefined,undefined];
console.log(arr3) // [undefined,undefined,undefined]

//-> 배열에서 비어있는 요소와 'undefined를 할당한 요소'는 출력 결과 부터 다르다. '비어 있는 요소'는 순회와 관련된 많은 배열 메서드의 순회대상에서 제외

/* 빈 요소와 배열의 순회 (나중에 다시 보기)*/
var arr1=[undefined,1]
var arr2=[];
arr2[1] = 1;

arr1.forEach(function(v,i){console.log(v,i); }); //undefined 0 / 1 1
arr2.forEach(function(v,i){console.log(v,i); }); // 1 1

arr1.map(function(v,i){return v+i;}); //[NaN,2]
arr2.map(function(v,i){return v+i;}); //[emtpy,2]

arr1.filter(function(v){return !v;}); // [undefined]
arr2.filter(function(v){return !v;}); // []

arr1.reduce(function(p,c,i){ return p+c+i;  },''); //undefined011
arr2.reduce(function(p,c,i){ return p+c+i;  },''); //11

//-> 값으로 어딘가에 할당한 undefined는 실존하는 데이터인 반면 자바스크립트 엔진이 반환해주는 undefined는 문자 그대로 값이 없음을 나타냄
// 둘 중 하나를 사용하지 않으면 된다 undefined를 할당 하지 않으면 혼란을 피할수 있다.

// 비어있음을 으로다저긍로 나타내고 싶을 때는 undefined 대신에 null을 쓰면 된다
// typeof null이 object 라는 점을 주의


/*undefined와 null의 비교*/

var n = null;
console.log(typeof n); // object

console.log(n==undefined) //true;
console.log(n==null) //true;

console.log(n===undefined) //false;
console.log(n===null) //true
/*
==동등 연산자 ===일치 연산자
동등 연산자로 비교할 경우 null인지 아니면  undefined인지 판별 불가 
일치 연산자를 써야만 정확히 판단 가능 
*/


