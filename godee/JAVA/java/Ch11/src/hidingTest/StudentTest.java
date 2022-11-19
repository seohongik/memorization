//패키지 이름이 hidigTest입니다.
package hidingTest;

//클래스 이름이 studentTest입니다.
public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		//stuendtA객체를 생성 합니다.
		
		Student studentA=new Student();
		
		//studentA 객에체 "라이언"이라는 이름을 지정합니다.
		//The field Student.studentName is not visible 라는 오류가 발생합니다.
		//studentA.studentName="라이언";
		
		//setStudentName() 메서드를 활용해 private 변수에 접근이 가능합니다.
		studentA.setStudentName("라이언");
		
		
		//studentA 객체가 가지고 있는 학생 이름을 출력합니다.
		System.out.println(studentA.getStudentName());
		
		/*
		 [참고]
		 studentName 필드(멤버변수)에 이름값을 직접 대입하는 것이 아니고
		 setStudentName() 메서드(멤버함수)를 활용하여 값을 대입할 수 있습니다.
		 즉, 외부 클래스에서 private 변수에 직접 접근할 수 는 없지만
		 public 메서드를 통하면 private 변수에 접근 할 수 있습니다.
		 */
		
		
	}

}
