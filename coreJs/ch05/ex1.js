/** 클로저-> 어떤 함수에서 선ㅓ한 변수를 참조하는 내부함수에서만 발생하는 현상 
 * 
*/
// 외부함수의 변수를 참조하는 내부함수(1)
var outer = function(){

    var a = 1;

    var inner = function(){

        console.log(++a);
    };

    inner();
};

outer();

//-> inner 함수 내부에서 a 를 선언하지 않았기 때문에 상위 outer렉시칼에서 a를 찾음 outer함수 실행 컨텍스트가 종료되면 렉시칼환경에 저장된 식별자는 a,inner에 대한 참조를 지움 -> 가비지 컬렉터의 수집 대상

// 외부함수의 변수를 참조하는 내부함수(2)

var outer = function(){
    var a = 1;
    var inner = function(){
        return ++a;
    }

    return inner();
};

var outer2 = outer();

console.log(outer2);

// 외부함수의 변수를 참조하는 내부함수(3)

var outer = function(){
    var a = 1;
    var inner = function(){
        return ++a;
    }

    return inner; // 함수 실행 결과가 아닌 inner 함수 자체를 반환
};

var outer2 = outer(); // inner 참조

console.log(outer2());//2 // inner 실행
console.log(outer2());//3 // 증가

console.log(outer2);
console.log(outer2);

//클로저는 어떤 함수에서 선언한 변수를 참조하는 내부 함수에서만 발생하는 현상 
//-> 외부 함수의 LexicalEnvironment가 가비지 컬렉팅 되지 않는 현상

/***
 *  클로저란 어떤 함수 A에서 선언한 변수 a를 참조하는 내부함수 B를 외부로 전달할 경우
 *  A의 실행 컨텍스트가 종료된 이후에도 변수 a가 사라지지 않는 현상
 * */

// 주의 사항 외부로 전달이 곧 return 만을 의미하는 것은 아니다.

//return 없이도 클로저가 발생하는 다양한 경우 
// (1) setInterval | setTimeout

(function(){

    var a = 0; 
    var inervalId = null;
    var inner = function(){

        if(++a>=10){
            clearInterval(inervalId);
        }
        console.log(a);

    };

    inervalId = setInterval(inner, 1000);

})();
//window의 메서드(setTimeout 또는 setInterval에 전달한 콜백 함수 내부에서 지역변수 참조)->클로저


(function(){

    var count = 0; 
    var button = document.createElement('button');
    button.innerText ='click';
    button.addEventListener('click',function(){
        console.log(++count, 'times clicked')
    });

    document.body.appendChild(button);

})();
// 별도의 외부객체인 Dom의 메서드(addEventListener)에 등록한 handler 함수 내부에서 지역변수를 참조 ->클로저



/** 클로저와 메모리 관리 */
// 메모리 관리방법 -> 참조 카운트를 0으로 만듬 :: 방법은 null이나 undefined 할당 
var outer = (function(){

    var a = 1;
    var inner  = function(){
        return ++a;
    }

    return inner ;

})();

console.log(outer());
console.log(outer());
outer = null;  // outer 식별자의 inner 함수 함조 끊음 

///////////

(function(){

    var a = 0; 
    var inervalId = null;
    var inner = function(){

        if(++a>=10){
            clearInterval(inervalId);
            inner = null // inner 식별자의 함수 참조 끊음 
        }
        console.log(a);

    };

    inervalId = setInterval(inner, 1000);

})();

////////

(function(){

    var count = 0; 
    var button = document.createElement('button');
    button.innerText ='click';

    var clickHandler = function(){
        console.log(++count, 'times clicked');

        if(count>=10){
            button.removeEventListener('click', clickHandler);
            clickHandler = null; //clickHandler 식별자의 함수 참조 끊음
        }
    }

    button.addEventListener('click', clickHandler);
    document.body.appendChild(button);

})();

/*클로저 활용 사례*/

// (1) 콜백 함수 내부에서 외부 데이터를 사용하고자 할 때 
//-> 이벤트 리스너에 관한 예시

var fruits = ['apple', 'banana', 'peach'];

var $ul = document.createElement('ul')// 공통 코드

fruits.forEach(function(fruit){ //(A)

    var $li = document.createElement('li');
    $li.innerText = fruit;

    $li.addEventListener('click', function(){ //(B)
        alert('your choice is  '+ fruit)
    });

    $ul.appendChild($li);

});

document.body.appendChild($ul);



//콜백 함수와 클로저(2)  [(B)를 외부로 분리하였을 시]

var fruits = ['apple', 'banana', 'peach'];

var $ul = document.createElement('ul')// 공통 코드

var alertFruit = function(fruit){
    alert('your choice is  '+ fruit);
};

fruits.forEach(function(fruit){
    var $li = document.createElement('li');
    $li.innerText = fruit;
    $li.addEventListener('click',alertFruit); //콜백 함수의 인자에 대한 제어권을 addEventListener가 가진상태 이벤트 객체에 주입
    $ul.appendChild($li);
});
document.body.appendChild($ul);

alertFruit(fruits[1]);
/** 그래서 클릭시 이벤트 겍체가 얼럿 창에 뜸 */

//해결법 -> bind :: 이벤트 객체가 인자로 넘어오는 순서가 바뀌는 점 및 함수 내부에서의 this가 원래의 그것과 달라지는 점은 감안해야함 

var fruits = ['apple', 'banana', 'peach'];

var $ul = document.createElement('ul')// 공통 코드

var alertFruit = function(fruit){
    alert('your choice is  '+ fruit);
};

fruits.forEach(function(fruit){
    var $li = document.createElement('li');
    $li.innerText = fruit;
    $li.addEventListener('click',alertFruit.bind(null, fruit)); //콜백 함수의 인자에 대한 제어권을 addEventListener가 가진상태 이벤트 객체에 주입
    $ul.appendChild($li);
});
document.body.appendChild($ul);

alertFruit(fruits[1]);

//다른방식 -> 고차함수를 이용 :: 함수형 프로그래밍 ( 고차함수란 함수를 인자로 받거나 함수를 리턴하는 함수 )

var fruits = ['apple', 'banana', 'peach'];

var $ul = document.createElement('ul')// 공통 코드

var alertFruitBuilder = function(fruit){

    return function(){
        alert('your choice is  '+ fruit);
    }
}

fruits.forEach(function(fruit){
    var $li = document.createElement('li');
    $li.innerText = fruit;
    $li.addEventListener('click',alertFruitBuilder(fruit)); //콜백 함수의 인자에 대한 제어권을 addEventListener가 가진상태 이벤트 객체에 주입
    $ul.appendChild($li);
});
document.body.appendChild($ul);

//(2) 접근 권한 제어 정보은닉

var outer = function(){
    var a = 1;
    var inner = function(){
        return ++a;
    }

    return inner; // 함수 실행 결과가 아닌 inner 함수 자체를 반환
};

var outer2 = outer(); // inner 참조

console.log(outer2());//2 // inner 실행
console.log(outer2());//3 // 증가

//-> outer은 전역스코프로 부터 철저하게 격리된 닫힌 공간 외부에서 오직 outer 함수가 return 한 정보에만 접근 가능

//-> 외부에 제공하고자 하는 정보들을 모아서 return하고, 내부에서만 사용할 정보들은 return 하지 않는것으로 접근 제어가 가능
// ruturn 한 변수들은 공개 멤버 , 그렇지 않은 변수들은 비공개 맴버



var car = {
     fuel: Math.ceil(Math.random()*10+10), //연료(L)
     power: Math.ceil(Math.random()*3+2),   // 연비(km/L)
     moved:0,
     run: function(){

        var km = Math.ceil(Math.random() *6);
        var wasteFuel = km/this.power;

        if(this.fuel<wasteFuel){
            console.log('이동 불가 ');
            return ; 
        }

        this.fuel -= wasteFuel;
        this.moved +=km;

        console.log(km + 'km 이동 (총 '+this.moved+'km');

     }
}

// car 객체에 직접 접근하여 값을 바꿀 수 있음 ex) car.fuel 등

var createCar = function(){ //함수로 실행 함으로서 fuel power 변수 비공개 지정
        var fuel = Math.ceil(Math.random()*10+10); //연료(L)
        var power= Math.ceil(Math.random()*3+2);   // 연비(km/L)
        var moved=0;
        

    return {
            get moved(){ //읽기 전용속성 부가
                return moved;
            }
        ,
        run: function(){

            var km = Math.ceil(Math.random() *6);
            var wasteFuel = km/power;

            if(fuel<wasteFuel){
                console.log('이동 불가 ');
                return ; 
            }

            fuel -= wasteFuel;
            moved +=km;

            console.log(km + 'km 이동 (총 '+moved+'km');

        }
    }
}

var car = createCar();

console.log(car.run());

/* 정보 은닉 
1. 함수에서 지역변수 및 내부함수 등을 생성 
2. 외부에 접근권한을 주고자 하는 대상들로 구성된 참조형 데이터(대상이 여럿일 때는 객체 또는 배열, 하나일 때는 함수)를 return
  -> return한 변수들은 공개 멤버 , 그렇지 않은 변수들은 비공게 맴버
*/

//부분 적용 함수 
/**
 *  n개의 인자를 받는 함수에 미리 m개의 인자만 넘겨 기억시켰다가 
 *  나중에(n-m)개의 인자를 넘기면 비로소 원해 함수의 실행 결과를 얻은 수 있는 
 *  함수
 *  bind 메서드의 실행 결고가 부분 적용함수
 */

var add = function(){

    var result = 0;
    for(var i=0; i<arguments.length; i++){

        result+=arguments[i];
    }

    return result;

};

var addPartial = add.bind(null, 1,2,3,4,5); // 기억해 놨다가
console.log(addPartial(6,7,8,9,10)); //실행
// this에 관여하지 않은 별도의 부분 적용 함수를 짤 수가 없다. (비록 지금 코드에 this가 없지만)


var partial = function(){

    var origianlPartialArgs = arguments;
    var func = origianlPartialArgs[0];

    if(typeof func !=='function'){
        throw new Error('첫 번째 인자가 함수가 아닙니다.');
    }

    return function(){
        var partialArgs = Array.prototype.slice.call(origianlPartialArgs,1);
        var restArgs = Array.prototype.slice.call(arguments);
        return func.apply(this,partialArgs.concat(restArgs));
    }
}

var add = function(){

    var result = 0;
    
    for(var i=0;i <arguments.length; i++){

        result+=arguments[i];
    }

    return result;
}

var addPartial = partial(add, 1,2,3,4,5);
console.log(addPartial(6,7,8,9,10));

var dog = {
    name:'강아지'
    , greet : partial(function(prefix,suffix){
        return prefix + this.name +suffix;
    },'왈왈, ')
}
console.log(dog.greet('입니다.!')); // 이시점에서 비로소 실행

//인자들을 원하는 위치에 미리 넣어놓고 나중에는 빈 자리에 인자를 채워 넣어 실행

Object.defineProperty(window, '_',{

    value: 'EMPTY_SPACE',
    writable : false,
    configurable :false,
    enumerable: false

});

var partial2 = function(){

    var origianlPartialArgs = arguments;
    var func = origianlPartialArgs[0];

    if(typeof func !=='function'){
        throw new Error('첫 번째 인자가 함수가 아닙니다.');
    }

    return function(){

        var partialArgs = Array.prototype.slice.call(origianlPartialArgs,1);
        var restArgs = Array.prototype.slice.call(arguments);
        for( var i=0; i<partialArgs.length; i++){
            if(partialArgs[i]=== _){ // Symbol.for('EMPTY_SPACE') // 심볼 공간에 문자열이 있으면 해당값 참조 선언돼 있지 않으면 새로 만드는 방식
                partialArgs[i] =  restArgs.shift();
            }
        }

        return func.apply(this, partialArgs.concat(restArgs));
    };
};

var add = function(){
    var result = 0;
    for( var i=0; i<arguments.length; i++){
       result+=arguments[i];
    }
    return result;
}
// var _= Symbol.for('EMPTY_SPACE');
var addPartial = partial2(add,1,2, _, 4, 5, _, _, 8,9);
console.log(addPartial(3,6,7,10))

var dog = {
    name:'강아지'
    , greet : partial2(function(prefix,suffix){
        return prefix + this.name +suffix;
    },'왈왈, ')
}

console.log(
    dog.greet(' 배고파요! ')
)

//디바운스 : (부분함수 실무편) 디바운스는 짧은 시간 동안 동일한 이벤트가 많이 발생할 경우 
//이를 전부 처리하지 않고 처음 또는 마지막에 발생한 이벤트에 대해 한 번만 처리하는 것
//->프론트엔드 성능 최정화에 큰 도움을 주는 기능 중 하나

//scroll, wheel, mousemove, resize 등에 많이 쓰임

var debounce = function(eventName, func, wait){

    var timeoutId = null;

    return function(event) {

        var self = this;
        console.log(eventName, 'event 발생');
        clearTimeout(timeoutId);
        timeoutId = setTimeout(func.bind(self, event), wait);

    };

};

var moveHandler = function(e){
    console.log('move event 처리');

}

var wheelHandler = function(e){
    console.log('wheel event 처리');

}

document.body.addEventListener('mousemove',debounce('move', moveHandler,500));

document.body.addEventListener('mousewheel',debounce('wheel', wheelHandler,300));

//(4) 커링 함수

/**
 * 
 * 커링 함수는 여러 개의 인자를 받는 함수를 하나의 인자만 받는 함수로 나눠서 순차적으로 호출 할 수 있게 체인 형태로 궁성한것
 * 부분 적용 함수와 기본적인 맥락은 일치하지만 몇가지 다른 점이있음
 * 
 * 커링 -> 한번에 하나의 신자만 전달하는것을 원칙으로 함
 * 커링 -> 중간 과정상 한수를 실행한 결과는 그다음 인자를 받기 위해 대기할 뿐 마지막 인자가 전달되기 전까지는 원본 함수가 실행 되지 않음
 * 
 * 부분 적용함수 -> 여러개의 인자를 전달할 수 있고 , 실행 결과를 제 실행 할 때 원본 함수가 무조건 실행
 * 
 * 
 */

var curry3 = function(func){
    return function(a){
        return function(b){
            return func(a,b);
        }
    }
}

var getMaxWith10 = curry3(Math.max)(10);
console.log(getMaxWith10(8)); //10
console.log(getMaxWith10(25)); //25

var getMinWith10 = curry3(Math.min)(10);
console.log(getMinWith10(8)); //8
console.log(getMinWith10(25)); //10

var curry5 = function(func){

    return function(a){
        
        return function(b){

            return function(c){
                return function(d){
                    
                    return function(e){

                           return func(a,b,c,d,e) ;
                    }
        
                }
        
            }
        
        }

    }

}

var getMax = curry5(Math.max);

console.log(getMax(1)(2)(3)(4)(5));

//위와 동일

var curry5 = func=>a=>b=>c=>d=>e=> func(a,b,c,d,e);

var getMax = curry5(Math.max);

console.log(getMax(1)(2)(3)(4)(5));

// 커링 함수가 유용한 점 -> 당장 필요한 정보만 받아서 전달하고 또 필요한 정보가 들어오면 전달하는 식
// 마지막 인자가 넘어갈 때 까지 함수 실행을 미룸
// 지연실행
// 원하는 시점까지 지연 시켰다가 실행하는 것이 요긴한 상황이면 커링을 쓰자 
// 프로젝트 내에서 자주 쓰이는 함수의 매개 변수가 항상 비슷하고 일분만 바뀌는 경우에도 커링을 쓰자

var getInformation = function(baseUrl){
    return function(path){
        return function(id){
            return fetch(baseUrl+path+'/'+id);
        }
    }
}

//ES6
//var getInformation = baseUrl=>path=>id=> fetch(baseUrl+path+'/'+id);

//fetch 함수는 url을 받아 해당 url에 HTTP 요청을 함
// 매번 baseUrl기입 하기 보다 공통 요소(id 제외 )는 먼저 기억시켜두고 특정 값 (id)만으로 서버요청하는게 효율 가독 성 측면에더 좋음
