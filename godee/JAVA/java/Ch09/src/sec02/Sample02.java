package sec02;

import java.io.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;

public class Sample02 {
	//throws IOExcetpion
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("영문자를 입력하세요");
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));//control shift 5
	
		String str =br.readLine();//행 단위 입력

		String str1 = str.toUpperCase();//String toUpperCase() : 문자열을 대문자로 변환 한 후 반환합니다. 
		String str2 = str.toLowerCase();//String toLowerCase() : 문자열을 소문자로 변환한 후 반환합니다. 
		
		System.out.println(str1);
		System.out.println(str2);
	}

}
