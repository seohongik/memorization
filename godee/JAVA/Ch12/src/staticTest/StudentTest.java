//��Ű�� �̸��� staticTest �Դϴ�.
package staticTest;


//Ŭ���� �̸��� StudentTest�Դϴ�.
public class StudentTest {
	//main()�� �����Ǿ����ϴ�.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		//�л� 1���� �����մϴ�.
		
		Student studentA= new Student();
		
		//�л� �̸��� ���̾��̶�� �����մϴ�.
		studentA.setStudentName("���̾�");
		
	
		
		//�л� 1���� �����մϴ�.
		
		Student studentB= new Student();
		
		//�л� �̸��� ���̾��̶�� �����մϴ�.
		studentB.setStudentName("����");
		
		
		//������ serialNum�� private��
		//serialNum ���� ������������ get()�޼��带 Ŭ���� �̸����� ���� ȣ�� �մϴ�.
		//�л��� �й��� ����մϴ�.
		System.out.println(Student.getSerialNum());
		
		//�л��� ���̵� ����մϴ�.
		
		System.out.println(studentA.studentID);
		
		//�л��� �й��� ����մϴ�.
		System.out.println(Student.getSerialNum());
		
		System.out.println(studentB.studentID);
		
		
		
	}

}