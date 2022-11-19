
public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age = 17;
		int charge;
		
		if(age < 8) {
			charge = 1000;
			System.out.println("미취학 아동 입니다.");
		} else if(age < 14) {
			charge = 2000;
			System.out.println("초딩입니다");
		} else if (age < 20) {
			charge = 2500;
			System.out.println("중고딩입니다.");
		} else {
			charge = 30000;
			System.out.println("성인입나다");
		}
		
		System.out.println("입장료는 " +charge+ "원입니다.");
	}

}
