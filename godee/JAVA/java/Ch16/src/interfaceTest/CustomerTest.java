//package이름이 interfaceTest입니다.
package interfaceTest;
//클래스 이름이 CustomerTest 입니다.
public class CustomerTest {

	//main() 메서드를 생성되었습니다. 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Customer 객체를 생성합니다. 
		Customer customer=new Customer();
		
		//Customer 클래스형인 customer Buy 인터페이스 형인 buyer에 대입하여 형변홥 합니다. 
		
		Buy buyer= customer;
		//buyer는 인터페이스의 메서드만 호출 가능합니다. 
		
	//	System.out.println(buyer.getClass());
		
		buyer.buy();
		
		//Customer 클래스 형인 customer를 Sell 인터페이스 형인 seller에 대입하여 형변환 합니다. 
		
		Sell seller=customer;
		
		//System.out.println(seller.getClass());
		seller.sell();
		
		//seller를 하위 클래스형인 Customer로 다시 형변환 합니다. 
		if(seller instanceof Customer) {
			
			Customer customerA= (Customer)seller;		
			customerA.buy();
			customerA.sell();		
			}
	
		}

}
