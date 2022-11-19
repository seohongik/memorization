
//클래스 이름이 Student 입니다
public class Student {
	//설계한 속성을 문법에 맞추어 작성해주세요.
	//필드(멤버변수)의 선언 (정의)
	//학번
	int studentID;
	//이름
	String studentName;
	//전공
	String major;
	//학년
	int grade;
	

	
	
	//메서드의 정의
	void showStudentInfor() {
		//메서드의 기능을 구현합니다.
		//이름 :studentName
		//전공:major
		//문자열과 변수를 연결하기 위하여"+"연결자를 사용하겠습니다.
		//필드(멤버 변수)를 사용할때에는 ""(큰따옴표)를 봍이지 않습니다.
		//"(큰 따옴표는)문자열을 의미하므로, 문자열 시작과 끝에 붙여줍니다.
		
		System.out.println("이름은:"+studentName +"입니다.");
		System.out.println("전공은"+major+"입니다");
	}
	
	//학생의 이름을 반환하는 메서드를 만들어 주세요
	//메서드의 정의
	String getStudentName() {
		//메서드의 기능을 구현합니다.
		//This method must return a result of type String 에러가 발생합니다.
		//그러므로 반환값을 지정해야합니다.
		
		return studentName;//반환형과 반환값의 자료형(type)은 동일해야 합니다.
		
	}
	
	//학생의 이름을 부여하는 메서드를 구현해 주세요
	
	void setStudentName(String name) {
		//매개변수로 전달받은 name의 값을 필드(멤버변수) studentName에 대입합니다.
		studentName= name;
		
	}
	
	//main 이라고 작성한 후,ctrl+space bar(스페이스바)를 누릅니다.
	//첫번째에 표시된 'main - main method' 항목을 누릅니다.
	//main()메서드가 생성됩니다.
	
	public static void main(String[] args) {
		//클래스형 //변수(객체)이름=new 생성자
		
		Student studentA=new Student(); //Student 클래스 생성
		//studentA에 필드(이름)을 "라이언"으로 지정합니다.
		studentA.studentName ="라이언";
		
		//studentA 필드(이름)을 출력합니다.
		System.out.println(studentA.studentName);
		
		//studentA의 getStudentName() 메서드를 통해 출력합니다.
		
		System.out.println(studentA.getStudentName());
	
		Student studentB=new Student();
		
		//studentB의 setStudentName(String name) 메서드를 통해 학생의 이름을 부여합니다.
		//학생의 이름(무지)을 부여합니다.
		studentB.setStudentName("무지");
		
		//studentB의 etStudentName() 메서드를 통해 출력합니다.
		System.out.println(studentB.getStudentName());
	
		
		
	}
	

}
