//��Ű�� �̸��� hidigTest�Դϴ�.
package hidingTest;

//Ŭ���� �̸��� studentTest�Դϴ�.
public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		//stuendtA��ü�� ���� �մϴ�.
		
		Student studentA=new Student();
		
		//studentA ����ü "���̾�"�̶�� �̸��� �����մϴ�.
		//The field Student.studentName is not visible ��� ������ �߻��մϴ�.
		//studentA.studentName="���̾�";
		
		//setStudentName() �޼��带 Ȱ���� private ������ ������ �����մϴ�.
		studentA.setStudentName("���̾�");
		
		
		//studentA ��ü�� ������ �ִ� �л� �̸��� ����մϴ�.
		System.out.println(studentA.getStudentName());
		
		/*
		 [����]
		 studentName �ʵ�(�������)�� �̸����� ���� �����ϴ� ���� �ƴϰ�
		 setStudentName() �޼���(����Լ�)�� Ȱ���Ͽ� ���� ������ �� �ֽ��ϴ�.
		 ��, �ܺ� Ŭ�������� private ������ ���� ������ �� �� ������
		 public �޼��带 ���ϸ� private ������ ���� �� �� �ֽ��ϴ�.
		 */
		
		
	}

}