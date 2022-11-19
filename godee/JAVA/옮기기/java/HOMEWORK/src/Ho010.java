
public class Ho010 {
	
	//	공백이 출력됩니다.
	static void myFunc() {
		System.out.println();
	}
	
	// java는 매개변수의 데이터 값을 확실히 알려주어야 됩니다.
	static void myFunc(int data1){
		System.out.println(data1);
	}
	
	// java는 같은 이름의 함수를 매개변수의 타입을 변화시켜 다시 사용할 수 있습니다.	
	static void myFunc(double data1) {
		System.out.println(data1);
	}
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myFunc(1);
		myFunc(1.1);
	}

}
