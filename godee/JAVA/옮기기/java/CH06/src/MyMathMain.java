class MyMath {

	long add(long num1, long num2) {
		long result = num1 + num2;
		return result; 
	}
	
	long add(long num1, long num2, long num3) {
		long result = num1 + num2 + num3;
		return result; 
	}
	
	double add(double num1 , double num2) {
		double result = num1 + num2;
		return result;
	}
	
	void showMenu() {
		System.out.println("계산기 프로그램");
	}
	
}


public class MyMathMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyMath myMath = new MyMath();
		
		myMath.showMenu();
	
		long result = myMath.add(10L,20L);
		double result2 = myMath.add(20.5, 30.2);
		
		System.out.println(myMath.add(1, 2));
		System.out.println(myMath.add(1.0, 2));
		System.out.println(result);
		System.out.println(result2);
		
		long result3 = myMath.add(10L, 20L, 30L);
	}

}
