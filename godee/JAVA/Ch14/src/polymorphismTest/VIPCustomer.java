//패키지이름이 polymorphismTest입니다.
package polymorphismTest;

//VIPCustomer 클래스를 정의합니다.
////VIPCustomer 클래스는 Customer 클래스를 상속 받습니다.
public class VIPCustomer extends Customer {
	
	
	//VIP 고객관련 기능을 구현할 때만 필요한필드(멤버변수)를 정의합니다.
	
	private int agentID;		//vip 고객 담당 상담원아이디
	double saleRatio;			//할인율
	
	//매개 변수가 있는 생성자를 정의합니다.
	public VIPCustomer(int customerID, String customerName, int agentID) {
		
		//명시적으로 상위클래스 생성자를 호출합니다.
		
		super(customerID, customerName);
		this.agentID=agentID;	//담당 상담원 아이디
		customerGrade="VIP"; 	//고객등급 vIP
		bonusRatio =0.05;		//보너스 적립 5%
		saleRatio=0.1;			//할인율 10%
		
		
	}
	
	
	//지불 가격 메서드를 재정의 합니다.
	
	public int calcPrice(int price) {
		
		bonusPoint +=price*bonusRatio;
		
		
		return price-(int)(price*saleRatio); 
		
	}
	
	//상위 클래스에 showCustomerInfo() 메서드를 참조해 담당 상담원의 아이디를 추가로 출력합니다.
	//고객 정보 출력하는 메서드를 재정의합니다.
	public String showVIPInfo() {
		
		return super.showCustomerInfo()+"담당 상담원 아이디는"+agentID+"입니다.";
	}
	//VIP 고객에게만 필요한 메서드
	
	public int getAgentID() {
		
		
		return agentID;
	}
	
	
	

}
