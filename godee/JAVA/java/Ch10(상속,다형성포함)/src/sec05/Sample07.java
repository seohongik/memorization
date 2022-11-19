package sec05;

class Car{
	
	private int num;
	private double gas;
	
	public Car() {
		
		num=0;
		gas=0.0;
		System.out.println("자동차가 생성되었습니다.");
	}
	
}

public class Sample07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Car car1 =new Car();
		Car car2 = new Car();
		
		Car car3;
		car3 =car1;
		
		boolean b1 =car1.equals(car2);
		boolean b2 =car1.equals(car3);
		
		System.out.println(b1);
		System.out.println(b2);		
	}

}
