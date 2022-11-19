class MyMath{
	/*오버로딩 : 매개변수다 다르거나 타입이 다르거나*/
	long add(long num1, long num2) {
		
		long result= num1+num2;
		
		return result;
	}
	
	
	long add(long num1, long num2, long num3) {
		
		long result= num1+num2+num3;
		
		return result;
	}
	
	double add(double num1, double num2) {
		
		double result = num1+num2;
		
		return result;
		
	}
	
	void showMenu() {
		System.out.println("계산기 프로그램");
		//return 자바 가상 기계가 알아서 해주니 return; 안달어도됨
	}
	
}


public class MyMathMain {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		MyMath myMath = new MyMath();
		
		myMath.showMenu();// 호출을 안하면 돌아가지 않음
		
		long result =myMath.add(10L,20L);
		System.out.println(result);
		
		double result2 = myMath.add(20.5,30.2);
		System.out.println(result2);
		
		double result3 = myMath.add(10L,20L,30L);
		System.out.println(result3);
	}

}
