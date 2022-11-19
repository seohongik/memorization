//package이름이 polymorphismTest입니다.
package polymorphismTest;
//class는 GoldCustomer입니다.
//GoldCustomer눈 Customer 를 상속 받습니다.
public class GoldCustomer extends Customer {
	
	//Gold 고객 관련 기능을 구현할 때만 필요한 필드(멤버 변수)를 정의합니다. 보너스 포인트 , 할인율
	
	double saleRatio;
	
	//매개 변수가 있는 생성자를 정의합니다.
	GoldCustomer(int customerID, String customerName){
		//명시적으로 상위클래스 생성자를 호출합니다.
		super(customerID, customerName);
		
		customerGrade="GOLD";
		bonusRatio=0.02;
		saleRatio=0.1;
	}
	
	//지불 계산 메서드 제정의
	
	public int calcPrice(int price) {
		
		//보너스 포인트 적립합니다.
		bonusPoint += price*bonusRatio;
		
		
		
		//할인된 가격을 계산하여 반환합니다.
		
		return price-(int)(price*saleRatio);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
