
//��Ű���̸��� dailyTest�Դϴ�.
package dailyTest;



//Ŭ���� �̸��� MyDateTest�Դϴ�.
public class MyDeteTest {

	//main() �޼��尡 �����Ǿ����ϴ�.
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//���ϸ� �׽�Ʈ ���� 
		MyDate date1=new MyDate(-1,1,2020);
		System.out.println(date1.isVaild() ?"��ȿ�� ��¥�Դϴ�.":"��ȿ���� ���� ��¥�Դϴ�.");//��ȿ���� ���� ��¥�Դϴ�.
		
		MyDate date2= new MyDate(17,6,2020);
		System.out.println(date2.isVaild()?"��ȿ�� ��¥�Դϴ�.":"��ȿ���� ���� ��¥�Դϴ�.");//��ȿ�� ��¥�Դϴ�.
		
		//date ��� ��ü�� �����մϴ�.
		//date ��ü�� �ʵ�(�������)�� public���� private�� �����ϹǷ� ������ �߻��մϴ�.
		/*
		 
		The field MyDate.month is not visible
		The field MyDate.day is not visible
		The field MyDate.year is not visible
		*/
		
		
		/*
		MyDate date = new MyDate();
		
		date.month=2;
		
		date.day=30;
		
		date.year=2020;
		*/
	}

}