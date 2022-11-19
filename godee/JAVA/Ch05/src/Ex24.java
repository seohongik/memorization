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
		System.out.println("학번 : "+num1);
		
	}
}
public class Ex24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 제목 :학사관리 시스템(3)
		 처리조건
		 1)	학번은 숫자로 이루어져있으며, 6자리로 생성합니다. 
		 2) 이름은 최대 10글자로 제한합니다.(숫자나 특수 문자 안됨)
		 3)	학생수는 최대 100명까지 입력합니다. 
		 4) 과목은 선택할 수 있습니다. (ex1.국어  2.영어, 3.수학)
		 5) 출력화면은 다음과 같습니다. 
		 
		 1.전체 성적표
		 학번 	이름 		국어		영어		수학		총점		평균		석차
		 ----------------------------------------------------------
		 
		 2. 학생별 성적표
		 ----------------------------------------------------------
		  학번 	이름 		국어		영어		수학		총점		평균		석차
		 
		 3. 과목별 성적표(ex1.국어  2.영어, 3.수학)
		 ----------------------------------------------------------
		  ex)학번 	이름 		국어	   	석차
		 */
		
	Student student1= new Student();
	System.out.println("학번입력>>");
	Scanner scanner = new Scanner(System.in);
	
	int num;
	num =scanner.nextInt();
	student1.setNum(num);
	//System.out.println(student1.getNum());
	
	
	student1.displayNum(num);
	}

}
