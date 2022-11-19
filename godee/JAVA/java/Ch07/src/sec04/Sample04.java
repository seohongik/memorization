package sec04;

class Car{
	int num;
	double gas;
	
	void setNum(int n) {
		num = n;
		System.out.println("차량번호는"+num+"변경하였습니다.");
		
	}
	
	void setGas(double g) {
		gas=g;
		System.out.println("연료량은"+gas+"변경하였습니다.");
	}
	
	void show() {
		System.out.println("차량번호는" +num+"입니다.");
		System.out.println("연료량은" +gas+"입니다.");
		
	}
	
}


public class Sample04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1 = new Car();
		car1.show();
		car1.setNum(1234);
		car1.setGas(10.5678);
		car1.show();

	}

}
