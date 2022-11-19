package sec02;

class Car{
	
	int num;
	double gas;
	
	void show() {//메소드 선언
		
		
		//this 실행되고 있는 객체 자신
		
		
		
		System.out.println("차량번호는"+num+"입니다.");
		System.out.println("연료량은"+gas+"입니다.");
		
	}
	
	
}


public class Sample02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Car car1;
	car1= new Car();
		
	//Car car1 = new Car(); 이렇게도 할 수 있다
		
	car1.num =1234;
	car1.gas = 80.1234;
	
	car1.show();//메소드 호출 멤버 함수
		
		
		
		
	}

}
