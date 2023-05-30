/** 클래스 */

// 자바스크립트는 프로토타입 기반 언어라서 상속의 개념이 존재하지 않음
// 하지만 클래스와 비슷하게 동작하게끔 흉내 내는 여러 기법들이 탄생
// 이러한 니즈에 따라 결국 ES6에는 클래스 문법이 추가 



/**클래스란 */

// 클래스는 하위로 갈수록 상위클래스의 속성을 상속하면서 더 구체적인 요건이 추가 또는 변경 
// 물론 하위 클래스가 아무리 구체화 되더라도 이들은 결국 추상적인 개념일 뿐이다.

/**인스턴스란 */

//어떤 클래스의 속성을 지니는 실존하는 개체를 일컬는 개념
// == 사례 , 어떤 조건에 부합하는 예시


/* 현실세계 한 개체가 서로 다른 여러 클래스의 인스턴스일 수 있다. 
 반면 프로그래밍 언어상에는 사용자가 직접 여러가지 클래스를 정의해야하며 
, 클래스를 바탕으로 인스턴스를 만들 때 비로소 어떤 개체가 클래스의 속성을 지님
*/

/**
 * 
 * 프로그램 언어에서의 클래스는 현실세계의 클래스와 마찬가지로 공통 요소를 지니는 집단을 분류하기 위한 개념
 * 하지만 인스턴스들로 부터 공통점을 발견하여 클래스를 정의 하는 현실과 달리 , 클래스가 먼저 정의돼어야만 그로부터 공통적인 요소를 지니는 개체들을 생성할 수 있음
 * 
 */

/**
 * 
 * 자바 스크립트는 프로토타입 기반 언어 
 * 하지만 프로토 타입을 일반적인 의미에서의 클래스 관점에서 접근하면 비슷하게 해석할 수 있는 요소가 있음
 * 
 * Array를 new 연산자와 함께 호출하면 인스턴스가 생성됨 Array를 일종의 클래스라고 하면 Array의 prototype 객체 내부 요소들이 인스턴스에 상속 된다고 볼 수 있다.
 * 엄밀히는 상속이 아닌 프로토 타입 체이닝에 의한 참조지만 결과적으로 동일하게 동작  또 Array 내부 프로퍼티들 중 prototype 프로퍼티를 제외한 나머지는 인스턴스에 상속 되지 않는다.
 *  
 */


/**
 * 
 * 인스턴스에 참조하는지에따라 스테틱 멤버와 인스턴스 맴버로 나뉜다. 
 * 자바스크립트에서는 인스턴스에서도 직접 메서드를 정의할 수 있기 때문에 인스턴스 메서드라는 명칭은 
 * 프로토 타입에 정의한 메서드를 지칭하는 것인지
 * 인스턴스에 정의한 메서드를 지칭하는 것인지 혼란을 야기하므로 
 * 
 * 프로토 타입 메서드라고 부르는 편이 좋음
 * 
 */



/** 
 * //스태틱 메서드/ 프로토타입 메서드 
 * 
 * */

var Rectangle = function (width, height){

    this.width = width;
    this.height = height;

};

Rectangle.prototype.getArea = function(){

    return this.width * this.height;
};

Rectangle.isRectangle = function(instance){

    return instance instanceof Rectangle && instance.width>0 && instance.height>0;
};


var rec1 = new Rectangle(3,4); 
console.log(rec1.getArea()); //12
console.log(rec1.isRectangle(rec1)); //Error
console.log(Rectangle.isRectangle(rec1)); // true



var Grade = function(){

    var args = Array.prototype.slice.call(arguments);

    for( var i =0; i<args.length; i++){

        this[i]=args[i];
    }

    this.length = args.length;

};

Grade.prototype=[];

var g = new Grade(100,80);

g.push(90);

console.log(g); // Grade{0:100, 1:80, 2:90, length : 3}

delete g.length;

g.push(70);

console.log(g) // Grade{ 0:70, 1:80, 2:90, length : 1 }

// 내장객체인 배열 인스터스의 length 프로퍼티는 configurable 속성이 false라서 삭제 불가
// Grade 클래스의 인스터스는 배열 매서드를 상속하지만 기본 적으로는 일반 객체의 성질을 그래도 지니므로 삭제가 가능해서 문제 발생


var Grade = function(){

    var args = Array.prototype.slice.call(arguments);

    for( var i =0; i<args.length; i++){

        this[i]=args[i];
    }

    this.length = args.length;

};

Grade.prototype = ['a', 'b', 'c','d'];

var g = new Grade(100,80);

g.push(90);

console.log(g); // Grade{0:100, 1:80, 2:90, length : 3}

delete g.length;

g.push(70);

console.log(g) // Grade{ 0:100, 1:80, 2:90,___ 4:70 length : 5 }

// 클레스에 있는 값이 인스턴스의 동작에 영향을 줘서는 안됨
// 나중에 살펴보기로함

//사용자가 정의한 두 클레스 사이에서의 상속관계 구현


var Rectangle  = function(width, height){
    this.width = width;
    this.height = height;

};

Rectangle.prototype.getArea = function(){
    return this.width * this.height;
};


var rect = new Rectangle(3,4);
console.log(rect.getArea()); //12


var Square = function(width){
    this.width = width;
};

Square.prototype.getArea = function(){
    return this.width*this.width;
};

var sq = new Square(5);
console.log(sq.getArea());// 25

// Rectangle 과 Square클레스(프로토타입)에 공통요소가 보인다.
// width라는 프로퍼티가 공통 getArea는 내용이 다르지만 비슷 
// 만약 Square에서 height 프로퍼티에 width 값을 부여하는 형태가 된다면 getArea도 동일


var Square = function(width){
    this.width = width;
    this.height = width;
};

Square.prototype.getArea = function(){
    return this.width*this.height;
};

//Rectangle을 상속하는 Square클레스 

var Square = function(width){
    Rectangle.call(this, width, width);
};

Square.prototype = new Rectangle();

//참고: 주의: 이 함수 구문은 apply()와 거의 동일하지만, call()은 인수 목록을, 반면에 apply()는 인수 배열 하나를 받는다는 점이 중요한 차이점입니다.


/** 클레스가 구체적인 데이터를 지니지 않게 하는 방법 */

//클레스가 구체적인 데이터를 지니지 않게 하는 방법 중 가장 쉬운 방법은 일단 만들고 나서 프로퍼티들을 일일이 지우고
// 더는 새로운 프로퍼티를 추가할 수 없게 하는것

delete Square.prototype.width;
delete Square.prototype.height;

Object.freeze(Square.prototype);



// 좀 더 구체적이고 확실한 방법(1) - 클레스 상속 및 추상화
var extendClass1 = function(SuperClass, SubClass, subMethods){

    SubClass.prototype = new SuperClass();

    for(var prop in SubClass.prototype){

        if(SubClass.prototype.hasOwnProperty(prop)){

            delete SubClass.prototype[prop];
        }
    }

    if(subMethods){
        for(var method in subMethods){

            SubClass.prototype[method] = subMethods[method];
        }

    }


    Object.freeze(SubClass.prototype);

    return SubClass;

};


var Square = extendClass1(Rectangle, function(width){

    Rectangle.call(this, width, width);
});


// Bridge 인스턴스 할당


var Rectangle = function(width, height){

    this.width = width;
    this.height = height;
};

Rectangle.prototype.getArea = function(){
    return this.width* this.height;
}

var Square = function(width){
    Rectangle.call(this, width, width);
}

var Bridge = function(){};

Bridge.prototype = Rectangle.prototype;

Square.prototype = new Bridge();

Object.freeze(Square.prototype);

//-> Bridge 라는 빈 함수를 만들고 , Bridge.prototype 이 Rectangle.prototype을 참조하게 한 다음
// Square.prototype에 new Bridge()fh gkfekdgkaus 
// Rectangle를 Bridge가 대체 이로써 인스턴스를 제외한 프로토 타입 체인 경로상에는 더는 구체적인 데이터가 남지 않음



// 좀 더 구체적이고 확실한 방법(2) - 클레스 상속 및 추상화

var extendClass2 = (function(){

    var Bridge = function(){};

    return function(SuperClass, SubClass, subMethods){

        Bridge.prototype = SuperClass.prototype;

        SubClass.prototype = new Bridge();

        if(subMethods){

            for(var method in subMethods){

                SubClass.prototype[method] = subMethods[method];
            }

        }

        Object.freeze(SubClass.prototype);

        return SubClass;

    };
})();

//좀 더 구체적이고 확실한 방법(3) - 클레스 상속 및 추상화

//(...생략)
Square.prototype = Object.create(Rectangle.prototype);
Object.freeze(Square.prototype);
//(...생략)

/** constructor 복구하기 */

// Subclass 인스턴스에는 constructor가 없고 , SubClass.prototpe에도 없는 상태 
//SubClass.prototype.constructor가 원래의 SubClass를 바라보도록 해주어야 한다.


// 좀 더 구체적이고 확실한 방법(1) -(완성본) - 인스턴스 생성 후 프로퍼티 제거
var extendClass1 = function(SuperClass, SubClass, subMethods){

    SubClass.prototype = new SuperClass();

    for(var prop in SubClass.prototype){

        if(SubClass.prototype.hasOwnProperty(prop)){

            delete SubClass.prototype[prop];
        }
    }

    SubClass.prototype.constructor = SubClass;

    if(subMethods){
        for(var method in subMethods){

            SubClass.prototype[method] = subMethods[method];
        }

    }


    Object.freeze(SubClass.prototype);

    return SubClass;

};


var Square = extendClass1(Rectangle, function(width){

    Rectangle.call(this, width, width);
});


// 좀 더 구체적이고 확실한 방법(2) -(완성본) - 빈 함수를 활용

var extendClass2 = (function(){

    var Bridge = function(){};

    return function(SuperClass, SubClass, subMethods){

        Bridge.prototype = SuperClass.prototype;

        SubClass.prototype = new Bridge();

        SubClass.prototype.constructor = SubClass;

        if(subMethods){

            for(var method in subMethods){

                SubClass.prototype[method] = subMethods[method];
            }

        }

        Object.freeze(SubClass.prototype);

        return SubClass;

    };
})();



//좀 더 구체적이고 확실한 방법(3) -(완성본) - Object.create 활용

var extendClass3 = function(SuperClass, SubClass, subMethods){

    SubClass.prototype = Object.create(SuperClass.prototype);
    SubClass.prototype.constructor = SubClass;

    if(subMethods){
        for(var method in subMethods){

            SubClass.prototype[method] = subMethods[method];
        }

    }

    Object.freeze(SubClass.proptotype);
    return SubClass;

};

//여기 까지가 상속 및 추상화 성공

//super 까지 구현

/** super 까지 구현 [나중에 다시 보기 ] */
var extendClass = function(SuperClass, SubClass, subMethods){

    SubClass.prototype = Object.create(SuperClass.prototype);
    SubClass.prototype.constructor = SubClass;

    ///// 추가된 부분 [S]
    SubClass.prototype.super = function(propName){

        var self = this;

        if(!propName) {

            return function(){
                SuperClass.apply(self, arguments);
            };
        }

        var prop = SuperClass.prototype[propName];

        if(typeof prop !== 'function') {

            return prop;
        }
        
        return function(){
            return prop.apply(self, arguments);
        };
    };

    ///// 추가된 부분 [E]
    if(subMethods){
        for(var method in subMethods){

            SubClass.prototype[method] = subMethods[method];
        }

    }

    Object.freeze(SubClass.proptotype);
    return SubClass;
};

var Rectangle = function(width,height){
    this.width = width;
    this.height = height;
}

Rectangle.prototype.getArea = function(){
    return this.width * this.height;
}

var Square = extendClass(

    Rectangle, 
    function(width){
        this.super()(width, width); //super 사용(1)
    }, {
        getArea : function(){
            console.log('size is ::' , this.super('getArea')()); //super 사용 (2)
        }
    }

);

var sq = new Square(10);

sq.getArea();

console.log(sq.super('getArea')());

/** ES6 클래스 및 클래스 상속  */