
public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i=0, J=0;
		
		while(true) {
			i++;
			J = J+i;
			if(i>=99) {
				System.out.println("J =" + J);
				break;
			} else {
				i = i+1;
				J = J-i;	
			}
		}
	}

}
