//package이름이 inheritanceTest입니다.
package inheritanceTest;

//OverridingTest2 클래스
public class OverridingTest2 {

	//main()가 생성되었습니다
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer vc = new VIPCustomer(10030,"나몰라",67890);
		vc.bonusPoint=1000;
		System.out.println(vc.getCustomerName()+"님이 지불해야하는 금액은"+vc.calcPrice(10000)+"원입니다.");

	}

}
