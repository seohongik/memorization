package sec09;

class Car{
	
	private int num;
	private double gas;
	
	private String name;
	
	public Car() {
		
		num=0;
		gas=0.0;
		name="ȫ�浿";
		System.out.println("�ڵ����� �����Ǿ����ϴ�.");
		
		
	}
	
public void show() {
		
		System.out.println("������ȣ��" +num+"�Դϴ�.");
		System.out.println("���ᷮ��"+gas+"�Դϴ�.");
		
}
	
	
	public void setCar(int num, double gas) {
		
		this.num =num;
		this.gas = gas;
		System.out.println("������ȣ��"+num+"����,���ᷮ��"+gas+"�Դϴ�.");
	}
	

}



public class Sample09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Car[] cars;//��ü �迭
		
		//cars = new Car[3];
		
		Car[] cars= new Car[3];
		
		for(int i=0; i<cars.length; i++) {
			
			cars[i]=new Car();
			
			
		}
			cars[0].setCar(1, 10.12);
			cars[1].setCar(2, 30.23);
			cars[2].setCar(3, 30.34);
			
			for(int i=0; i<cars.length; i++) {
				
				cars[i].show();
			}
	}

}