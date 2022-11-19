package sec07;


class Car{
	
	private int num;
	private double gas;
	
	public Car() {
		
		num=0;
		gas=0.0;
		System.out.println("자동차가 생성되었습니다.");
		
		
	}
	
	public void show() {
		
		System.out.println("차량번호는" +num+"입니다.");
		System.out.println("연료량은"+gas+"입니다.");
	}
	
	public void setCar(int num, double gas) {
		
		this.num =num;
		this.gas = gas;
		System.out.println("차량번호는"+num+"으로,연료량은"+gas+"입니다.");
	}
}


public class Sample07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("car1을 선언했습니다.");
		Car car1=new Car();
		
		car1.setCar(1000,123.456);
		
		Car car2;
		System.out.println("car2를 선언했습니다.");
		
		car2=car1;
		System.out.println("car2에 car1을 대입했습니다.");
		
		car1.show();
		car2.show();
		
		car1.setCar(2345, 10.567);
		System.out.println("car1의 차량을 변경합니다.");
		
		car1.show();
		car2.show();
		

	}

}
