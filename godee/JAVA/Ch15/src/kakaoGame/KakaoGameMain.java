//��Ű�� �̸��� kakaoGame�Դϴ�.
package kakaoGame;

import java.util.Scanner;

//Ŭ���� �̸��� kakaoGameMain �Դϴ�.
public class KakaoGameMain {

	//main()�޼��尡 �����Ǿ����ϴ�.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		Character character=null;
		PlayGameEngine pgEngine=null;
		
		System.out.println("=====KAKAO GAME=====");
		System.out.println("���ϴ� ĳ���͸� �����ϼ���");
		System.out.println("1.���̾� 2.����ġ 3.����");
		int num=sc.nextInt();
		
		switch(num) {
		case 1://���̾� ����
			character=new Ryan();
			break;
		case 2://������ ����
			character=new Apeach();
			break;

		case 3://���� ����
			character=new Muzi();
			break;
			
		default : 
			System.out.println("�߸� �����ϼ̽��ϴ�.");
		
		
		}
		
		if(character==null) {
			System.out.println("������ �����մϴ�.");
			return;
		}else {
			pgEngine =new PlayGameEngine(character);
		}
		
		while(true) {
			
			pgEngine.printMenu(sc);
			if(pgEngine.isExit()) {
				System.out.println("������ �����մϴ�.");
				break;
			}
		}
		

	}

}