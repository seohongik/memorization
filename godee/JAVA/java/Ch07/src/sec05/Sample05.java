package sec05;

class Car{
	
	int num;
	double gas;
	
	void show() {
		System.out.println("������ȣ��"+this.num +"�Դϴ�.");
		System.out.println("���ᷮ��"+this.gas+"�Դϴ�.");
		
	}
	//���μ� int num double gas
	void setNumGas(int num, double gas) {
		this.num = num;
		this.gas =gas;
		System.out.println("������ȣ��"+ this.num +"����,���ᷮ��"+this.gas+"���� �����Ͽ����ϴ�.");
		
		
	}
	
}

public class Sample05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1=new Car();
		
		int number=1234;
		double gasoline =90.067;
		
		car1.show();
		//���μ� number gasoline
		car1.setNumGas(number, gasoline);
		car1.show();
		

	}

}