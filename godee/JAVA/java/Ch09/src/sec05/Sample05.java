package sec05;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample05 {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("정수를 2개 입력하세요");
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str1 =br.readLine();
		String str2 =br.readLine();
		
		int num1 =Integer.parseInt(str1);
		
		int num2 =Integer.parseInt(str2);
		
		int result = Math.max(num1, num2);
		
		System.out.println(result);
		
		
		
	}
}