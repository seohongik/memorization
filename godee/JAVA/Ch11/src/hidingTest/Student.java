//패키지 이름이 hidigTest입니다.
package hidingTest;


//클래스 이름이 student입니다.
public class Student {
	
	//필드(멤버변수)를 정의합니다.
	
	int studentID; 		//학번
	
	//studentName 변수를 private으로 선언합니다.
	private String studentName; //이름
	String major; 		//전공
	int grade;			//학년
	

	//학생 이름을 가져오는 메서드를 정의합니다.
	//private 변수인 studentName에 접근해 값을 가져오는 public get()메서드
	
	public String getStudentName() {
		
		return studentName;
	}
	
	//학생 이름을 부여하는 메서드를 정의합니다.

	//private 변수인 studentName에 접근해 값을 지정하는 public set()메서드

	public void setStudentName(String studentName) {
		
		this.studentName = studentName;
		
	}
	

	
	
	
}
