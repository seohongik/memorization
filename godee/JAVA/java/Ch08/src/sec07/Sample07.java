package sec07;

class Car{
	
	private int num;
	private double gas;
	
	public static int sum=0;
	//�⺻������-�Ű������� ���� ������
	
	public void Car() {//�ν��Ͻ�?
		
		this.num=0;
		this.gas=0.0;
		sum++;
		System.out.println("�ڵ����� �����Ǿ����ϴ�.");
		
		
	}
	
	public static void showSum() {
		
		System.out.println("�ڵ����� ���"+sum+"�� �����ϰ� �ֽ��ϴ�.");
	}
	
	public void show() {
		System.out.println("���� ��ȣ��"+num+"�Դϴ�.");
		System.out.println("���ᷮ��"+gas+"�Դϴ�.");
	}
	
	public void setCar(int num,double gas) {
		this.num=num;
		this.gas=gas;
		
		System.out.println("���� ��ȣ��"+this.num+"����, ���ᷮ��"+this.gas+"�� �ٲپ����ϴ�.");
	
	}

}


public class Sample07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Car.showSum();
		Car car1=new Car();
		car1.setCar(123, 100.123);
		car1.show();
		car1.showSum();
		
		System.out.println();
		
		Car car2=new Car();
		car2.setCar(4567, 123.567);
		car2.show();
		car2.showSum();
	}

}