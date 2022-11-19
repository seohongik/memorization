//패키지 이름이 interfaceTest입니다. 
package interfaceTest;

//클래스 이름이 calculatorTest입니다.
public class CalculatorTest {
	
	//main()메서드가 생성되었습니다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int num1=10;
		int num2=5;
		
		CompleteCalc calc = new CompleteCalc();
		
		
		
		//더하기 메서드를 호출한 후 그 결과값을 출력합니다.
		System.out.println(calc.add(num1, num2));
		//빼기 메서드를 호출한 후 그 결과값을 출력합니다.
		System.out.println(calc.substract(num1, num2));
		//곱하기 메서드를 호출한 후 그 결과값을 출력합니다.
		System.out.println(calc.times(num1, num2));
		//나누기 메서드를 호출한 후 그 결과값을 출력합니다.
		System.out.println(calc.divide(num1, num2));
		//showInfo() 메서드를 호출 합니다.
		calc.showInfo();
		//디폴ㅌ 메서드를 호출합니다. 
		calc.description();
		
		
		
		
	
		Calc calcTest=new CompleteCalc();
		System.out.println(calcTest.add(num1, num2));
		System.out.println(calcTest.substract(num1, num2));
		System.out.println(calcTest.times(num1, num2));
		System.out.println(calcTest.divide(num1, num2));
		//showInfo()만 접근 풀가능
		
		//제정의한 description()호출합니다. 
		
		calcTest.description();
	
		int[]arr={1,2,3,4,5};
		
		//이거 분석하기 인터페이스니까 CalculatorTest로 접근 못합
	
		//정적메서드를 호출하시오
		System.out.println(Calc.total(arr));
		
	}

}
