import java.util.Scanner;

public class Ex15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 0;
		char grade =' ';
		System.out.print("점수를 입력하세요>");
		Scanner sc = new Scanner(System.in);
		String tmp = sc.nextLine();
		score = Integer.parseInt(tmp);
		
		System.out.println(score);
	}

}
