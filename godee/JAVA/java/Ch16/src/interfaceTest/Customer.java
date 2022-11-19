//package이름이 interfaceTest입니다.
package interfaceTest;

//Customer 클래스를 정의합니다.

//Customer 클래스는 Buy와 Sell인터페이스를 모두 구현합니다. 
public class Customer implements Buy,Sell{

	@Override
	public void sell() {
		// TODO Auto-generated method stub
		System.out.println("구매하기");
	}

	@Override
	public void buy() {
		// TODO Auto-generated method stub
		System.out.println("판매하기");
	}

	
	
	
}
