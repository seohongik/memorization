import java.util.Scanner;

public class Ex21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] words= {
				{"chair","의자"},
				{"computer","컴퓨터"},
				{"apple","사과"}
		};
		
		Scanner scr = new Scanner(System.in);
		
		for(int i=0; i<words.length; i++) {
			System.out.printf("Q%d. %s의 뜻은?",i+1,words[i][0]);
			
			String userInput = scr.nextLine();//String 형을 입력받음
			
			if(userInput.equals(words[i][1])) {
				System.out.println("정답입니다.");
				
			}else {
				System.out.printf("틀렸습니다. 정답은%s입니다.\n",words[i][1]);
			}//end of if
		}//end of for
	}

}
