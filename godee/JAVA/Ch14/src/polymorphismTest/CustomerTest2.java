//package는 polymorphismTest입니다.
package polymorphismTest;

import java.util.ArrayList;

//class이름은 CustomerTest2입니다.
public class CustomerTest2 {

	//main()메서드가 생성되었습니다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//고객 리스트를 생성합니다.
		ArrayList<Customer> customerList=new ArrayList<Customer>();
		
		//고객을 생성합니다.
		
		Customer customerA = new Customer(10010,"어피치");
		Customer customerB =new Customer(10020,"튜브");
		Customer customerC =new GoldCustomer(10030,"무지");
		Customer customerD =new GoldCustomer(10040,"콘");
		Customer customerE =new VIPCustomer(10050,"라이언",1234);
	
		//ArrayList add 메서드를 사용해 객체 배열에 고객을 추가합니다. 
		
		customerList.add(customerA);
		customerList.add(customerB);
		customerList.add(customerC);
		customerList.add(customerD);
		customerList.add(customerE);
		
		for(int i=0; i<customerList.size(); i++) {
			
	
		
			System.out.println(customerList.get(i).showCustomerInfo());

	
			
		}
		
		System.out.println("=================================보너스 할인율============================");

		int price=10000;
		for(Customer customer: customerList) {
			int cost=customer.calcPrice(price);
			
			System.out.println(customer.getCustomerName()+"님이"+cost+"원을 지불하였습니다.");
			System.out.println(customer.getCustomerName()+"님의 포인트는"+	customer.bonusPoint+"점입니다.");
	
			
		}
		
		
	
	}

}
