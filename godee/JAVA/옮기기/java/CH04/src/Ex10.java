
public class Ex10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 100;
		char grade = 'A';
		
		switch(score/10) {
			case 9 : case 10 :
				grade='A';
				break;
			case 8:
				grade='B';
				break;
			case 7:
				grade='C';
				break;
			case 6:
				grade='D';
				break;
			default : 
				grade='F';
		}
		System.out.println(score+"점은 " +grade+ "입니다.");
	}

}
