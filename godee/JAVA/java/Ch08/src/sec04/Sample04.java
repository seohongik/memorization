package sec04;

class Car{
	//기본생성자 void값없고 시작 대문자
	
	private int num;
	private double gas;
	public Car() {
		//기본생성자는 선언과 동시에 초기화 하려고 쓴다. 기본옵션
		
		this.num=10;
		this.gas=34.567;
		System.out.println("자동차가 생성되었습니다.");	
		
	}
	
	public void show() {
		System.out.println("차량 번호는"+num+"입니다.");
		System.out.println("연료량은"+gas+"입니다.");
	}
	
}

public class Sample04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car car1= new Car();
		car1.show();

	}

}
