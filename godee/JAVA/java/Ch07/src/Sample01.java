class Car{//Ŭ���� ����
	
	int num; //������ȣ
	double gas; //���ᷮ
	
	
}


public class Sample01 {
	
		public static void main(String[] args) {
		
			Car car1;
			car1 = new Car(); //�ν��Ͻ�ȭ (������Ʈ ����)
			
			car1.num =1234;
			car1.gas=90.567;
			
			System.out.println("������ȣ��" + car1.num +"�Դϴ�"); //���
			
			System.out.println("���ᷮ��" + car1.gas +"�Դϴ�"); //���
			
		}

}