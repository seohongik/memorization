//패키지 이름이 finalTest입니다.
package finalTest;

//클래스 이름이 Constant 입니다. 
public class Constant {

	//필드 (멤버변수)를 정의합니다.
	int num =10;
	//The blank final field NUM may not have been initialized
	//final int NUM; 
	final int NUM =100;
	
	//main()메서드가 생성되었습니다.
	public static void main(String[] args) {
		Constant constant = new Constant();
		constant.num= 50;
		System.out.println(constant.num);
		
		
		//The final field Constant.NUM cannot be assigned 오류가 납니다.
		//constant.NUM=100;
		System.out.println(constant.NUM);
	}
}
