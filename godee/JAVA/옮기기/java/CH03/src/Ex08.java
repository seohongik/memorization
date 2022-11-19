
public class Ex08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 10;
		int num2 = 20;
		
		boolean flag = (num1 > 10) && (num2>0);
		System.out.println(flag);
		
		flag = (num1<0) && (num2>0);
		System.out.println(flag);
		
		flag = (num1>0) || (num2>0);
		System.out.println(flag);
		
		flag = (num1<0) || (num2>0);
		System.out.println(flag);
		
		flag = !(num1>0);
		System.out.println(flag);
	}
	

}
