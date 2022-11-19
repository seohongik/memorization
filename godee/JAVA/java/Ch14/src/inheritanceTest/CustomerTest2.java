//package 이름이 inheritanceTest 입니다.
package inheritanceTest;


//class 이름이 CustomerTest2 입니다.
public class CustomerTest2 {
	
	
	//main()메소드가 생성되었습니다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*걍 매개변수*/
		
		//하위 클래스를 생성합니다.
		VIPCustomer customerB= new VIPCustomer();
		customerB.setCustomerID(10020);
		customerB.setCustomerName("무지");
		customerB.bonusPoint=10000;
		//고객이 정보를 출력합니다.
		System.out.println(customerB.showCustomerInfo());
			
	}

}
