
public class Ex18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double dNum1 = 1.2;
		float fNum1 = 0.9F;
		
		int iNum1 = (int)dNum1 + (int)fNum1;
		System.out.println(iNum1);
		System.out.println((int)dNum1);
		System.out.println((int)fNum1);
		
		int iNum2 = (int)(dNum1 + fNum1);
		System.out.println(iNum2);
	}

}
