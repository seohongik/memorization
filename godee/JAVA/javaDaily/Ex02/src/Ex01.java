import java.util.Scanner;


public class Ex01 {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);

				String str=sc.nextLine();
				int result= 0;
			for(int i=0; i<str.length(); i++) {
				
				result += str.charAt(i)-48;
				
				
			}
			System.out.println(result);
			
			
			
			
		
			
			
			
			
			}
		
	
}