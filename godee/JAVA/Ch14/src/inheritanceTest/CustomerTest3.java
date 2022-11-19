//package는 inheritanceTest 입니다;
package inheritanceTest;
//CustomerTest3 class가 정의하였습니다. 
public class CustomerTest3 {

//	main() 메서드가 생성되었습니다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*매개변수*/
		
		//VIP고객 무지 고객을 생성합니다. 
		VIPCustomer customerB= new VIPCustomer(10020,"무지",12345);
		//System.out.println(customerB.showCustomerInfo());
		
		
		//System.out.println(customerB.showCustomerInfo()+customerB.getAgentId());
		System.out.println(customerB.showVIPinfor());
	}

}
