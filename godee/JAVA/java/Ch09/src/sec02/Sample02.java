package sec02;

import java.io.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;

public class Sample02 {
	//throws IOExcetpion
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("�����ڸ� �Է��ϼ���");
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));//control shift 5
	
		String str =br.readLine();//�� ���� �Է�

		String str1 = str.toUpperCase();//String toUpperCase() : ���ڿ��� �빮�ڷ� ��ȯ �� �� ��ȯ�մϴ�. 
		String str2 = str.toLowerCase();//String toLowerCase() : ���ڿ��� �ҹ��ڷ� ��ȯ�� �� ��ȯ�մϴ�. 
		
		System.out.println(str1);
		System.out.println(str2);
	}

}