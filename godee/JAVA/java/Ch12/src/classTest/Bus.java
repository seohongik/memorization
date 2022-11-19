//패키지 이름이 classTest입니다.
package classTest;


//버스 클래스를 정의합니다.
public class Bus {
	
	//필드(멤버 변수를 )정의합니다.
	
	int busNumber; 	//버스번호
	int passengerCount;	//승객수
	int money; //버스 수입
	
	//버스 번호를 매개변수로 받는 생성자
	public Bus(int busNumber) {
		
		this.busNumber=busNumber;
		
		
	}


	//승객이 버스에 탄 경우를 구현하는 메서드
	public void take(int money) {
		
		this.money+=money;	//버스 수입 증가
		passengerCount++;	//승객 수 증가
		
		
	}



	//버스 정보를 출력하는 메서드
	public void showInfo() {
		System.out.println("버스"+busNumber+"번의 승객은"+passengerCount+"명이고,수입은"+money+"원입니다.");
	}


}
