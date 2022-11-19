//패키지 이름이 staticTest입니다.
package staticTest;


//Student 클래스를 정의합니다.
public class Student {
	//필드(멤버 변수)를 정의합니다.
	
	//static 변수는 인스턴스 생성과 상관없이 먼저 생성됩니다.
	private static int serialNum=2000;	//학번을 차례대로 부여하기 위함
	int studentID;						//학생의 ID
	String studentName; 				//학생의 이름
	int major;							//전공
	int grade; 							//학번
	
	//생성자
	
	public Student() {
		
		serialNum++;
		studentID=serialNum;
		
	}
		
	

	//학생의 이름을 가져오는 메서드를 정의합니다.
	public String getStudentName() {
		
		
		return studentName;
		
	}
	
	

	//학생의 이름을 부여하는 메서드를 정의합니다.
	public void setStudentName(String name) {
		
		studentName=name;
		
	}
	
	//serialNum의 get() 메서드
	
	public static int getSerialNum() {
		int i=10;					//지역변수라서 사용가능
		//studentName="라이언";		//멤버변수라서 사용불가능 Cannot make a static reference to the non-static field studentName
		return serialNum;
		
	}
	
	//serialNum의 set() 메서드
	public static void setSerialNum(int serialNum) {
		
		Student.serialNum=serialNum;
		
	}
	
	
	
	
	
}
