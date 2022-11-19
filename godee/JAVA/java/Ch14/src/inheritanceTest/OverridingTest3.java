//페키지 이름이 inheritanceTest입니다.
package inheritanceTest;

//클래스 이름이 OverridingTest3 입니다.
public class OverridingTest3 {
	
	//main() 메서드가 생성 되었습니다.
	public static void main(String[] args) {
		
		int price=10000;
		
		//Customer 임스턴스를 생성합니다.
		Customer customerA= new Customer(10010,"라이언");
		System.out.println(customerA.getCustomerName()+"님이 지불해야하는 금액은"+customerA.calcPrice(price)+"원입니다.");
		
		//VIPCustomer 인스턴스를 생성합니다.
		
		VIPCustomer customerB=new VIPCustomer(10020,"무지",12345);
		System.out.println(customerB.getCustomerName()+"님이 지불해야하는 금액은"+customerB.calcPrice(price)+"원입니다");
		
		//VIPCustomer 인스턴스를 Customer 형으로 변환합니다. 
		
		Customer vc=new VIPCustomer(10030,"나몰라",67890);
		System.out.println(vc.getCustomerName()+"님이 지불해야 하는 금액은"+vc.calcPrice(price)+"원입니다.");
		
	}
	

}
