//패키지이름이 polymorphismTest입니다.
package polymorphismTest;


//클래스 이름이 Customer 입니다.
public class Customer {
	
	//필드(멤버 변수를)정의합니다.
	
	protected int customerID; 			//고객아이디
	protected String customerName;		//고객이름
	protected String customerGrade;		//고객등급
	int bonusPoint;						//보너스 비율
	double bonusRatio;					//적립비율

	//디폴트 생성자
	
	public Customer() {
		
		//고객 등급과 보너스 포인트 적립율을 지정하는 메서드 호출
		initCustomer();
		
	}
	
	//매개변수가 있는 생성자
	
	public Customer(int customerID,String customerName) {
		
		
		this.customerID = customerID;
		this.customerName= customerName;
		initCustomer();

		
		
	}
	
	//고객등급과 보너스 포인트를 적립율을 지정하는 메소드
	private void initCustomer() {
		
		customerGrade ="SILVER";
		bonusRatio=0.01;
		
		
		
	}
	//메서드 (멤버 함수)를 정의합니다.
	//보너스 포인트 적립, 자불 가격 계산하는 메서드
	
	public int calcPrice(int price) {
		
		bonusPoint += price*bonusRatio;
		
		
		
		return price;
	
	
		
	}
	
	
	//고객 정보를 반환하는 메서드
	
	public String showCustomerInfo() {
		
		return customerName+"님의 등급은"+ customerGrade+"이며"+"보너스포인트는"+bonusPoint+"점입니다.";		
	}

	
	
	//protected 예약어로 선언한 변수를 외부에서 사용할 수 있도록 get() set()메서드를 추가합니다.
	

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



}
