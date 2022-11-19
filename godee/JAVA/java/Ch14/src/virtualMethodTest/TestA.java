//package이름이 virtualMethodTest입니다.
package virtualMethodTest;

//틀래스 이름이 TestA입니다.
public class TestA {
	//main()가 생성되었습니다.
	int num;
	
	void aaa() {
		
		System.out.println("aaa() 출력합니다.");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//필드(멤버 변수)를 저으이합니다.
		
		TestA a1=new TestA();
		a1.aaa();
		TestA a2= new TestA();
		a2.aaa();
		
	}

}
