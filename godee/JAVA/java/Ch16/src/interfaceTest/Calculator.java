//패키지 이름인 interfaceTest입니다.
package interfaceTest;


//Calculator 클래스를 선언합니다. 
//Calculator 클래스 Calc 인터페이스를 구현합니다.


/* 오버라이딩 안할시
- The type Calculator must implement the inherited abstract method Calc.times(int, 
		 int)
		- The type Calculator must implement the inherited abstract method Calc.divide(int, 
		 int)
		- The type Calculator must implement the inherited abstract method Calc.add(int, 
		 int)
		- The type Calculator must implement the inherited abstract method 
		 Calc.substract(int, int)*/


public abstract class Calculator implements Calc {

	@Override
	public int add(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1+num2;
	}

	@Override
	public int substract(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1-num2;
	} //추상클래스

	
	
	
	
	
}
