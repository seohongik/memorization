//package이름이 polymorphismTest입니다.
package polymorphismTest;


//class 이름이 CustomerTest1입니다.
public class CustomerTest1 {
	
	
	//main()메도스다 생성되었습니다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//일반 고객을 생성합니다.
		Customer customerA=new Customer();
		//일반 고객의 아이디를 부여합니다.
		customerA.setCustomerID(10010);
		//일반 고객의 이름을 부여합니다.
		customerA.setCustomerName("라이언");
		//일반 고객의 보너스 포인트를 부여합니다.
		customerA.bonusPoint=1000;
		//일반 고객의 정보를 출력합니다.
		System.out.println(customerA.showCustomerInfo());
		
		//VIP customer를 Customer 형으로 선언합니다
		Customer customerB=new VIPCustomer(10020,"무지",1234);
		//VIP 고객의 보너스 포인트를 부여합니다.
		customerB.bonusPoint=10000;
		//VIP고객의 정보를 출력합니다.
		System.out.println(customerB.showCustomerInfo());
		
		System.out.println("==========할인율과 보너스 계산============");
		
		int price=10000;
		
		//보너스 포인트 적립,지불 계산하는 메서드를 호출합니다.
		int priceA=customerA.calcPrice(price);
		
		//보너스 포인트 적립,지불 계산하는 메서드를 호출합니다.
		//VIPCustomer 클래스의 calcPrice가 재정의 되었을시
		
		int priceB=customerB.calcPrice(price);	
		
		//고객의 정보를 출력합니다.
		System.out.println(customerA.getCustomerName()+"님이"+priceA+"원을 지불 했습니다.");
		System.out.println(customerA.showCustomerInfo());
		System.out.println(customerB.getCustomerName()+"님이"+priceB+"원을 지불 했습니다.");
		System.out.println(customerB.showCustomerInfo());

	}

}
