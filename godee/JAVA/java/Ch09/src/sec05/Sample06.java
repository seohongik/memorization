package sec05;
class Car{
	
	private int num;
	private double gas;
	
	public Car() {
		
		num=0;
		gas=0.0;
		
		System.out.println("�ڵ����� �����Ǿ����ϴ�.");
				
	}
	
	public void setCar(int num, double gas) {
		this.num=num;
		this.gas = gas;
		
		System.out.println("���� ��ȣ��"+ this.num+"����, ���ᷮ��"+this.gas+"�� �����Ͽ����ϴ�.");
		
		
	}
	
	public void showCar() {
		
		System.out.println("������ȣ��"+this.num+"�Դϴ�.");
		System.out.println("���ᷮ��"+this.gas+"�Դϴ�.");
	}
}

public class Sample06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Car car1;
		System.out.println("car1�� �����߽��ϴ�.");
		
		car1=new Car();
		car1.setCar(1234,123.456);
		
		Car car2;
		
		System.out.println("car2�� �����߽��ϴ�.");
		
		car2 =car1;
		System.out.println("car2�� car1�� �����߽��ϴ�.");
		car1.showCar();
		System.out.println();
		car2.showCar();//car2��new�����ڸ� �Ƚ�� ������ callbyreference car1�� �ּ����� ���� 
		
		
		
	}

}