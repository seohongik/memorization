package sec01;

class Car{
	
	int num;
	double gas;
	
	
	void show() {
		System.out.println("차량 번호는"+num+"입니다.");
		System.out.println("연료량은"+gas+"입니다.");
	}
}

public class Sample01 {

	public static void main(String[] args) {
		//public 어디서나 다 쓸 수있는것(클레스에 public을 안붙인경우는 디폴트값으로 들어가있기 때문에 필드명앞에 (private) 메소드앞에 (public) 
		// TODO Auto-generated method stub
		
		Car car1=new Car();
		
		car1.num = 1234;
		car1.gas = 90.1234;
		car1.show();

	}

}
