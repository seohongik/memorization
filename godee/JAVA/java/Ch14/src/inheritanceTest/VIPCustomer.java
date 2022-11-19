//package이름이 inheritanceTest입니다.
package inheritanceTest;

//VIPCustomer class 정의합니다.


//VIPCustomer class는    Customer class를 상속 받습니다.
public class VIPCustomer extends Customer {
	
	
		//VIP 고객 관련 기능을 구현할 때만 필요한 필드(멤버변수 )를 정의합니다. 
		
		private int agentID; 			//VIP 고객 담당 상담원 아이디
		double saleRatio;				//VIP 할인율
	
		//디폴트 생성자
		public VIPCustomer() {
		
			
			//컴파일러가 자동으로 추가하는 코드 입니다. 
			//상위 클래스의 Customer()가 호출 됩니다.
			
			//The constructor Customer() is undefined
			super();
			
			
			//The field Customer.customerGrade is not visible
			/*상위 클래스에서 private 변수 이므로 오류가 납니다.*/ 
			/*접근 제한자 protected가 필요합니다.*/
			
			
			
			customerGrade="VIP";	
			bonusRatio=0.05;
			saleRatio=0.1;
			
			//하위클래스를 생성할 때 콘솔출력문을 작성합니다. 
			System.out.println("VIPCustomer() 생성자를 호출합니다.");
			
		}
		
		
		
		
		//매개 변수가 있는 생성자를 정의합니다.
		
		//명시적으로 상위클래스 생성자를 호출합니다.
		public  VIPCustomer(int customerID, String customerName, int agentID) {
			
			super(customerID, customerName);
			
			customerGrade="VIP";	
			bonusRatio=0.05;
			saleRatio=0.1;
			this.agentID=agentID;
			
			
			//하위 클래스를 생성할 때 콘솔 출력문을 작성합니다. 
			System.out.println("VIPCustomer(int,String, int) 생성자를 호출합니다.");
			
			
		}
		
	
		
		/*VIP 고객에게 제공하는 혜택인 할인율과 세일 가격을 어떻게 적용할지 구현 하지 않았다는 문제가 발생합니다.*/
		/*오버 라이딩 기법이 필요합니다.*/
		
		
		@Override
		public int calcPrice(int price) {
			// TODO Auto-generated method stub
			//보너스 포인트 정리
			bonusPoint += price*bonusRatio;
			
			//할인된 가겨을 계산하여 반환
			return price -(int)(price*bonusRatio);
		}
		
		
		//상위 클래스의 showCustomerInfo() 메서드를 참조하여 담당 상담원의 아이디를 추가로 출력합니다.
		
		public String showVIPinfor() {
			
			return super.showCustomerInfo()+"담당 상담원의 아이디는"+agentID+"입니다.";
			
		}
		
		
		
		
		
	




		//VIP 고객에게만 필요한 메서드
		//VIP 고객이 주체기 때문에 get만 사용한다.
		public int getAgentId() {
			
			return agentID;
			
		}
		
		
}
