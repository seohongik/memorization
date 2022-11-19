
public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i, J, SW;
		i = 0;
		J = 0;
		SW = 0;
		
		do {
			i = i + 1;
			if(SW==0) {
				J = J + i;
				SW = 1;
			} else {
				J = J - i;
				SW = 0;
			}
		} while (i<100);
		
		System.out.println("J =" +J);		
	
	}
}
