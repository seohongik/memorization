//Ŭ���� �̸��� FunctionTest�Դϴ�.
public class FunctionTest {

	//main �޼��尡 �����Ǿ����ϴ�.
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		//�ΰ��� ������ ���� num1�� num2�� ����� ���ÿ� �ʱ�ȭ�մϴ�.
		
		int num1= 10;//10���� �ʱ�ȭ
		int num2=20;//20���� �ʱ�ȭ
		
		
		//add��� �Ѽ��� ��ȯ���� ���� ������� ���� sum�� �����մϴ�.
		
		//add��� �Ѽ��� �μ��� num1(��:10)�� num2(��:20)�� ���� ���޵˴ϴ�.
		
		
		//sum�� 30�̶�� ���� ���� �˴ϴ�.
		int sum =add(num1,num2);//add��� �Լ��� ȣ���Ͽ� ��ȯ���� sum�� �����մϴ�. �ɼ� sysout�ٷ� ��� ��
		//����� ����� ����մϴ�.
		
		//���� ������ Ctrl+F11
		System.out.println(add(num1,num2));
		
	}

	
	/*�޼����̸� add
	�Ű����� num,num2 ->int ��
 	��ȯ�� : int���Դϴ�.
 	��ȯ�� :result�Դϴ�.
 	��� : �ΰ��� ���� num1�� num2�� ���� ����� result�� �����Ͽ� ���d�մϴ�.*/
	
	public static int add(int num1, int num2){
		//������� �����ϱ� ���� ����
		int result=0;
		
		//�ΰ��� ������ ���� ����� result ������ �����մϴ�.
		result=num1 +num2;
		
		//�ΰ��� ������ ���� ����� ��ȯ�ϱ� ���Ͽ� return ������ result ������ �ۼ��մϴ�.
		return result;//39�̶�� ���� add��� �Լ��� ȣ���Ѱ����� ��ȯ�˴ϴ�.	
		
	}
}