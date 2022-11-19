//package이 abstractTest 입니다.
package abstractTest;


//Desktop 클래스를 정의합니다.
//Desktop 클래스는 Computer 클래스를 상속 받습니다.

/*
 	Multiple markers at this line
	- The type Desktop must implement the inherited abstract method 
	 Computer.typing()
	- The type Desktop must implement the inherited abstract method 
	 Computer.display()
	//방법1 source탭 방법 2 Desktop에 마우스로 조정 방법3 class앞에 abstract를 붙인다(재정의하지 않을 경우)
*/


public class Desktop extends Computer{

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Decktop display()");
	}

	@Override
	public void typing() {
		// TODO Auto-generated method stub
		System.out.println("Decktop typing()");
	}
	
	/*@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void typing() {
		// TODO Auto-generated method stub
		
	}*/

	
}
