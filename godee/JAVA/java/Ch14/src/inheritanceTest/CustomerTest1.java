
//package 이름이 inheritanceTest 입니다.
package inheritanceTest;


// class 이름이  CustomerTest1 입니다.
public class CustomerTest1 {

	
	//main()가 생성되었습니다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* protected 바꾸기*/
		
		//라이언 객체를 생성합니다.
		Customer customerA=new Customer();
		//customerID와 customerName은 protected 변수이므로 set()메소드를 호출합니다.
		customerA.setCustomerID(10010);
		customerA.setCustomerName("라이언");
		customerA.bonusPoint=1000;
		//고객의 정보를 출력합니다.
		System.out.println(customerA.showCustomerInfo());
		
		//VIP고객 무지님을 생성합니다.
		VIPCustomer customerB=new VIPCustomer();
		//customerID와 customerName은 protected 변수이므로 set()메소드를 호출합니다.
		customerB.setCustomerID(10020);
		customerB.setCustomerName("무지");
		customerB.bonusPoint=10000;
		//고객의 정보를 출력합니다.
		System.out.println(customerB.showCustomerInfo());
		
		
		
	}

}
