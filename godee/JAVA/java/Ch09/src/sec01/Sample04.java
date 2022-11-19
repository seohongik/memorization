package sec01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample04 {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("문자열를 입력하세요");
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str1 =br.readLine();
		
		System.out.println("추가할 문자열을 입력하시요");
		
		String str2 = br.readLine();
		
		StringBuffer sb =new StringBuffer(str1);
		
		sb.append(str2);
		
		System.out.println(sb);
	}
}