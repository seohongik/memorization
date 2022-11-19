//package이름이 inheritanceTest입니다.
package inheritanceTest;
// Customer class가 정의되었습니다.
public class Customer {
	
	//필드(멤버변수)를 정의하시오
	protected int customerID;		//고객아이디
	protected String customerName;	//고객이름
	protected String customerGrade;	//고객등급
	int bonusPoint;					//보너스 포인트
	double bonusRatio;				//적립 비율

	//디폴트 생성자를 정의합니다.
	public Customer(){
		customerGrade="SLIVER";		//기본등급
		bonusRatio=0.01;			//보너스 포인트 기본 적립 비율

		//상위 클래스 생성할 때 콘솔 출력문을 작성합니다. 
		System.out.println("customer() 생성자를 호출합니다.");


	}

	//매개변수가 있는 생성자
	public Customer(int customerID,String customerName ) {
		this.customerID=customerID;
		this.customerName=customerName;
		customerGrade="SLIVER";
		bonusRatio=0.01;

		System.out.println("Customer(int, String) 생성자를 호출합니다.");

	}

	//멤버 함수를 정의합니다

	//보너스 포인트 적립 지불 가격 계산하는 메서드
	public int calcPrice(int price) {

		bonusPoint +=price*bonusRatio;

		return price;


	}


	//protected 예약어로 선언한 변수를 외부에서 사용할 수 있도록 get() set() 메서드를 추가합니다.

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}


	//고객 정보를 반환하는 매소드
	public String showCustomerInfo() {

		return customerName+"님의 등급은"+customerGrade+"이며, 보너스포인트는"+bonusPoint
				+"입니다.";	

	}

}
