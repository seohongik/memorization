package sec06;
class Car{
	
	int num;
	double gas;
	
	public int getNum() {
		System.out.println("차량번호를 조회합니다.");
		return num;
	}
	public void setNum(int num) {
		this.num = num;
		System.out.println("차량번호를"+this.num+"으로 변경합니다.");
	}
	public double getGas() {
		System.out.println("연료량을 조회합니다.");
		return gas;
	}
	public void setGas(double gas) {
		this.gas = gas;
		System.out.println("연료량을"+this.gas+"으로 변경합니다.");
	}
	
	void show() {
		System.out.println("차량번호는"+this.num+"입니다.");
		System.out.println("연료량은"+this.gas+"입니다.");		
	}
	
}


public class Sample06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1=new Car();
		car1.show();
		
		car1.setNum(5678);
		car1.setGas(70.967);
		
		int number = car1.getNum();
		double gasoline=car1.getGas();
		
		System.out.println("차을 자동차를 조사한 결과");
		System.out.println("차량번호는"+number+"입니다.");
		System.out.println("연료량은"+gasoline+"입니다.");
		
		

	}

}
