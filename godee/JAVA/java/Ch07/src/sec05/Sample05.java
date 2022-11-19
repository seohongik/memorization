package sec05;

class Car{
	
	int num;
	double gas;
	
	void show() {
		System.out.println("차량번호는"+this.num +"입니다.");
		System.out.println("연료량은"+this.gas+"입니다.");
		
	}
	//가인수 int num double gas
	void setNumGas(int num, double gas) {
		this.num = num;
		this.gas =gas;
		System.out.println("차량번호는"+ this.num +"으로,연료량은"+this.gas+"으로 변경하였습니다.");
		
		
	}
	
}

public class Sample05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1=new Car();
		
		int number=1234;
		double gasoline =90.067;
		
		car1.show();
		//실인수 number gasoline
		car1.setNumGas(number, gasoline);
		car1.show();
		

	}

}
