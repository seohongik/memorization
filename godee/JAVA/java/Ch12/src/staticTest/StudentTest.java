//패키지 이름이 staticTest 입니다.
package staticTest;


//클래스 이름이 StudentTest입니다.
public class StudentTest {
	//main()가 생성되었습니다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		//학생 1명을 생성합니다.
		
		Student studentA= new Student();
		
		//학생 이름을 라이언이라고 설정합니다.
		studentA.setStudentName("라이언");
		
	
		
		//학생 1명을 생성합니다.
		
		Student studentB= new Student();
		
		//학생 이름을 라이언이라고 설정합니다.
		studentB.setStudentName("무지");
		
		
		//오류남 serialNum이 private라서
		//serialNum 값을 가져오기위해 get()메서드를 클래스 이름으로 직접 호출 합니다.
		//학생의 학번을 출력합니다.
		System.out.println(Student.getSerialNum());
		
		//학생의 아이디를 출력합니다.
		
		System.out.println(studentA.studentID);
		
		//학생의 학번을 출력합니다.
		System.out.println(Student.getSerialNum());
		
		System.out.println(studentB.studentID);
		
		
		
	}

}
