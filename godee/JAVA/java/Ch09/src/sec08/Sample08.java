package sec08;

class Car{
	
	private int num;
	private double gas;
	
	private String name;
	
	public Car() {
		
		num=0;
		gas=0.0;
		name="홍길동";
		System.out.println("자동차가 생성되었습니다.");
		
		
	}
	
public void show() {
		
		System.out.println("차량번호는" +num+"입니다.");
		System.out.println("연료량은"+gas+"입니다.");
		System.out.println("이름은"+name+"입니다.");
}
	
	
	public void setCar(int num, double gas) {
		
		this.num =num;
		this.gas = gas;
		System.out.println("차량번호는"+num+"으로,연료량은"+gas+"입니다.");
	}
	
	public void setCar(String name) {
		this.name =name;
		System.out.println("차량이름을"+name+"입니다.");
	}
}


public class Sample08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car car1;
		car1=new Car();
		
		car1.show();
		
		int number = 1234;
		double gasoline=1.987;
		String carName ="1호";
		
		car1.setCar(number,gasoline);
		car1.show();
		
		
	}

}
