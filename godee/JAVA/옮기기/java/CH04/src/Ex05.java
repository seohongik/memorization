
public class Ex05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age = 13;
		int charge = 0;
		int i = 10;
		
		if(age < 8) {
			charge=1000;
		} if (age >=8 && age < 14) {
			charge = 2000;
		} if (age < 20 && (i+=2) < 0) {
			charge = 2500;
		} 
		
		System.out.println(charge);
	}

}
