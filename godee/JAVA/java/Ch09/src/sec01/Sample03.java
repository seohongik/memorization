package sec01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample03 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("문자열를 입력하세요");
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String str1=br.readLine();
		
		System.out.println("검색어를 입력하시오");
		
		String str2 = br.readLine();
		
		char ch = str2.charAt(0);//char charAt(int index); : 문자열에서 index의 위치에 있는 문자를 반환합니다.
		
		int num= str1.indexOf(ch);// int indexOf(String ch) : 비교대상 문자열에서 ch가 최초로 출현하는 위치를 반환 
		
		if(num!=-1) {
		System.out.println(ch+":"+num);
		}else {System.out.println("검색된 결과가 없습니다.");
		
		}
	}

}
