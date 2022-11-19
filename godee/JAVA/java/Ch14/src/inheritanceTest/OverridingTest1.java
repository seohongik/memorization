
//package inheritanceTest;
package inheritanceTest;

//class OverridingTest1
public class OverridingTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//일반 고객을 생성합니다.
		
		Customer customerA=new Customer(10010,"라이언");
		customerA.bonusPoint=1000;
		
		//VIP 고객을 생성삽니다.
		VIPCustomer customerB= new VIPCustomer(10020,"무지",12345);
		customerB.bonusPoint=10000;
		
		int price=10000;
		
		System.out.println(customerA.getCustomerName()+"님이 지불해야하는 금액은"+customerA.calcPrice(price)+"원입니다.");
		System.out.println(customerB.getCustomerName()+"님이 지불해야하는 금액은"+customerB.calcPrice(price)+"원입니다.");
		
		

	}

}
