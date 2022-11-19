package sec03;


class Car{
	
	int num;
	double gas;
	
	void show() {
		System.out.println("차량 번호는"+this.num+"입니다.");
		System.out.println("연료량은"+this.gas+"입니다.");
		
	}
	
	void showCar() {
		System.out.println("지금부터 자동차의 정보를 표시합니다.");
		show();//함수안에 다른함수를 호출 할 수 있다.
		
		
	}
	
}


public class Sample03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1 = new Car();
		
		car1.num = 5678;
		car1.gas= 95.1234;
		car1.showCar();
	}

}
