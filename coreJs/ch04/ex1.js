/*콜백함수 */

//제어권과 관련되어있다. 제어권도 함께 코드로 넘겨서 위임한 함수


/*제어권 */

//호출 시점
//콜백함수 예제(1-1)
var count=0;
var timer = setInterval(function(){

    console.log(count);

    if(++count>4) clearInterval(timer);

},300);


//콜백함수 예제(1-2)
var count=0;
var cbFunc= function(){
    console.log(count);

    if(++count>4) clearInterval(timer);
};

var timer = setInterval(cbFunc,300);

//--실행 결과 
//0 (0.3 초)
//1 (0.6 초)
//2 (0.9 초)
//3 (1.2 초)
//4 (1.5 초)

//이처럼 콜qoㄱ함수의 제어권을 넘겨받은 코드는 콜백 함수 호출 시점에 대한 제어권을 가진다.

//인자 

//콜백 함수 예제 (2-1) Array.prototype.map


var newArr = [10,20,30].map(function(currentValue, index){

    console.log(currentValue,index);

    return currentValue+5;

})

console.log(newArr);

/*

10 0
20 1
30 2
[15 25 35]
*/

/* map 메서드의 구조 
-> Array.prototype.map(callback[, thisArg])
calback : unction(currentValue, index, array)
*/



//콜백 함수 예제 (2-2) Array.prototype.map 인자의 순서를 임의로 바꾸어 사용한 경우


var newArr2 = [10,20,30].map(function(index, currentValue){

    console.log(index,currentValue);

    return currentValue+5;

});

console.log(newArr);

/*
10 0
20 1
30 2
[5 6 7]
*/

//콜백 함수 예제 (2-3) Array.prototype.map -구현 // this
Array.prototype.map = function(callback, thisArg){

    var mappedArr=[];


    for(var i =0; i<this.length; i++){

        var mappedValue = callback.call(thisArg || window, this[i], i, this);

        mappedArr[i] = mappedValue;

    }

    return mappedArr;
};

//-> 동작 원리 ( 자세한 내용은 모르겠으니 다시 공부 다시 보기 )


// 콜백 함수 내부에서의 this

/*
setTimeout(function(){

    console.log(this);
},300)


var arr = [1,2,3,4,5];
arr.forEach(function(x){

    console.log(this);

});

document.body.innerHTML +='<button id="a">클릭</button>';

document.body.querySelector('#a').addEventListener('click', function(e){
    console.log(this, e);
});
*/


/** 콜백 함수는 함수다*/

var obj ={
    vals:[1,2,3],
    logValues: function(v,i){
        console.log(this,v,i);
    }
}

obj.logValues(1,2); //{vals:[1,2,3], logValues :f} 1 2 

[4,5,6].forEach(obj.logValues); //window{...} 4 0 window{...} 5 1 , window{...} 6 2

// 어떤 함수의 인자에 객체의 메서드를 전달하더라도 이는 결국 메서드가 아닌 함수 일뿐 이다. 


//04 콜백 함수의 내부의 this에 다른 값 바인딩하기 

/**
 * 객체의 메서드를 콜백함수로 전달하면 해당 객체를 this로 바라볼 수 없게 된다.
 * 
 * this의 제어권도 넘겨주게 되므로 사용자가 임의로 값을 바꿀 수 없다. 
 * 
 * 전통적으로 this를 다른 변수에 담아 콜백 함수로 활용할 함수에서는 this 대신 변수를 사용하게 하고 
 * 이를 클로저로 만드는 방식이 많이 쓰였습니다.
 * 
 */


//콜백 함수 내부의 this에 다른 값을 바인딩 하는 방법- 전통적인 방식

var obj1 = {
    name:'obj'
    , func:function(){

        var self = this;
        return function(){
            console.log(self.name)
        };
    }
};

var callback = obj1.func();
setTimeout(callback,1000);

// 콜백 함수 내부에서 this를 사용하지 않는 경우 
var obj1 = {
    name:'obj',
    func:function(){
        console.log(obj1.name);
    }
}

setTimeout(obj1.func, 1000);

//func 함수 재활용
var obj1 = {
    name:'obj'
    , func:function(){

        var self = this;
        return function(){
            console.log(self.name)
        };
    }
};

var obj2 = {

    name:'obj2',
    func:obj1.func
};


var callback = obj1.func();
setTimeout(callback,1000);


var callback2 = obj2.func();
setTimeout(callback2,1500);

var obj3= {name:'obj3'}
var callback3 = obj1.func.call(obj3);
setTimeout(callback3,2000);

//콜백 함수 내부의 this에 다른 값을 바인딩 하는 방법 - bind 메서드 활용

var obj1={

    name:'obj1',
    func:function(){
        console.log(this.name)
    }
};

setTimeout(obj1.func.bind(obj1),1000);

var obj2 = {name:'obj2'};

setTimeout(obj1.func.bind(obj2), 1500);

//콜백 지옥과 비동기 제어 

/**
 * 
 * 콜백지옥 콜백 함수를 익명 함수로 전달하는 과정이 반복되어 코드의 들여쓰기 수준이 감당하기 힘들정도로 깊어지는 현상
 * -> 이벤트 처리나 서버 통신과 같이 비동기적인 작업을 수행하기 위해 이런 현상 발생 -> 가톡성이 떨어지고 코드 수정 어려움
 * 
 * 비동기는 동기의 반대 
 * 
 * 동기 -> 현재 실행중인 코드가 완료된 후에 다음코드 실행
 * 비동기 -> 현재 실행 중인 코드의 완료 여부와 무관하게 즉시 다음 코드로 넘어감 
 * 
 * ->setTimeout(실행 보류) , addEventListener(사용자 이벤트 대기) 서버 요청(XMLHttpRequest) , 별도의 요청 실행 대기 보류 등은 모두 비동기
 *
 * 
 * 
 */

//콜백지옥 예시


setTimeout(function(name){
    coffeeList=name;
    console.log(coffeeList);

    setTimeout(function(name){
        coffeeList+=',' +name;
        console.log(coffeeList);

        setTimeout(function(name){
            coffeeList+=',' +name;
            console.log(coffeeList);


            setTimeout(function(name){
                coffeeList+=',' +name;
                console.log(coffeeList);

            },500,'카페라떼');

        },500,'카페모카');

    },500,'아메리카노');

},500,'에스프레소');


//콜백 지옥 해결 - 기명함수로 변환

var coffeeList = '';

var addEspresso = function(name){
    coffeeList=name;
    console.log(coffeeList);
    setTimeout(addAmericano,500,'아메리카노');

}

var addAmericano = function(name){
    coffeeList+=','+name ;
    console.log(coffeeList);
    setTimeout(addMocha,500,'카페모카');

}

var addMocha = function(name){
    coffeeList+=','+name ;
    console.log(coffeeList);
    setTimeout(addLatte,500,'카페라떼');

}

var addLatte = function(name){
    coffeeList+=','+name ;
    console.log(coffeeList);
}

setTimeout(addEspresso,500,'에스프레소');


//비동기 작업의 동기적 표현(1) - promise(1)

new Promise(function(resolve){

    setTimeout(function(){
        var name ='에스프레소';
        console.log(name);
        resolve(name);
    
    },500);

}).then(function(prevName){

    return new Promise(function(resolve){

        setTimeout(function(){
            var name =prevName+', 아메리카노'
            console.log(name);
            resolve(name);
        
        },500);

    });
}).then(function(prevName){

    return new Promise(function(resolve){

        setTimeout(function(){
            var name =prevName+', 카페모카'
            console.log(name);
            resolve(name);
        
        },500);

    });
}).then(function(prevName){

    return new Promise(function(resolve){

        setTimeout(function(){
            var name =prevName+', 카페라떼'
            console.log(name);
            resolve(name);
        
        },500);

    });
})
;

//비동기 작업의 동기적 표현(1) - promise(2)

var addCoffee = function(name){

    return function(prevName){

        return new Promise(function(resolve){

            setTimeout(function(){

                var newName = prevName ? (prevName+', '+name) : name;
                console.log(newName);
            
                resolve(newName);
    
            },500);

        });
        
    };

};

addCoffee('에스프레소')()
    .then(addCoffee('아메리카노'))
    .then(addCoffee('카페모카'))
    .then(addCoffee('카페라떼'));


//비동기 작업의 동기적 표현(3) - Generator

var addCoffee = function(prevName, name){

    setTimeout(function(){
        coffeeMaker.next(prevName? prevName +', '+name:name);
    },500);

};

var coffeeGenerator = function*(){

    var espresso = yield addCoffee('', '에스프레소');
    console.log(espresso);
    
    var americano = yield addCoffee(espresso, '아메리카노');
    console.log(americano);
    
    var mocha = yield addCoffee(americano, '카페모카');
    console.log(mocha);

    var latte = yield addCoffee(mocha, '카페라테');
    console.log(latte);
}

var coffeeMaker  = coffeeGenerator();

coffeeMaker.next();

/*Generator -> * -> iterator-> (next , yield(실행 멈춤))*/

//비동기 작업의 동기적 표현(4) - Promise+ Async/await

var addCoffee = function (name) {

    return new Promise(function(resolve){

        setTimeout(function(){
            resolve(name);
        },500)

    });
    
};


var coffeeMaker = async function(){

    var coffeeList ='';

    var _addCoffee = async function(name){
        coffeeList+=(coffeeList ? ',' : '' ) + await addCoffee(name);
    }

    await _addCoffee('에스프레소');
    console.log(coffeeList);
    await _addCoffee('아메리카노');
    console.log(coffeeList);
    await _addCoffee('카페모카');
    console.log(coffeeList);
    await _addCoffee('카페라떼');
    console.log(coffeeList);

}

coffeeMaker();

/** 정리 
 *  콜백 함수는 다른코드에 인자로 넘겨줌으로써 그 제어권도 함께 위임한 함수
 * 
 *
 * 1) 콜백 함수를 호출하는 시점을 스스토 판단해서 실핼
 * 2) 콜백 함수를 호출할 때 인자로 넘겨줄 값들 및 그 순서가 정해져 있다. 이 순서를 따리지 않고 코드를 작성하면 엉뚱한 결과 초래 (값, 인덱스 vs 인덱스, 값 )
 * 
 * 3) 콜백 함수의 this가 무엇을 바라보도록 할지가 정해져 있는 경우도 있다. 정해지 않은 경우세는 전역객체를 바라봅 
 * 임의로 this를 바꾸고 싶을 경우 bind 메서드를 활용
 * 
 * 어떤 함수에 인사로 메서드를 전달하더라도 이는 결국 메서드가 아닌 함수로써 실행
 * 
 * 비동기 제어 -> Promise, Generator, asnyc.await 등 콜백 지옥에서 벗어날 수 있는 방법이 등장
 * 
 */