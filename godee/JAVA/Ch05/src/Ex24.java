import java.util.Scanner;

class Student{
	int num;
	
	int getNum() {
		return num;
	}
	
	void setNum(int num1) {
		num=num1;
		
	}
	void displayNum(int num1) {
		System.out.println("�й� : "+num1);
		
	}
}
public class Ex24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 ���� :�л���� �ý���(3)
		 ó������
		 1)	�й��� ���ڷ� �̷����������, 6�ڸ��� �����մϴ�. 
		 2) �̸��� �ִ� 10���ڷ� �����մϴ�.(���ڳ� Ư�� ���� �ȵ�)
		 3)	�л����� �ִ� 100������ �Է��մϴ�. 
		 4) ������ ������ �� �ֽ��ϴ�. (ex1.����  2.����, 3.����)
		 5) ���ȭ���� ������ �����ϴ�. 
		 
		 1.��ü ����ǥ
		 �й� 	�̸� 		����		����		����		����		���		����
		 ----------------------------------------------------------
		 
		 2. �л��� ����ǥ
		 ----------------------------------------------------------
		  �й� 	�̸� 		����		����		����		����		���		����
		 
		 3. ���� ����ǥ(ex1.����  2.����, 3.����)
		 ----------------------------------------------------------
		  ex)�й� 	�̸� 		����	   	����
		 */
		
	Student student1= new Student();
	System.out.println("�й��Է�>>");
	Scanner scanner = new Scanner(System.in);
	
	int num;
	num =scanner.nextInt();
	student1.setNum(num);
	//System.out.println(student1.getNum());
	
	
	student1.displayNum(num);
	}

}