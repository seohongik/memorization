//package이름이 gameTest입니다.
package gameTest;
//AdvancedLevel 클래스를 정의합니다.
//AdvancedLevel 클래스는 PlayerLevel 클래스를 상속받습니다.
public class AdvancedLevel extends PlayerLevel {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("빠르히 달립니다");
	}
	
	@Override
	public void jump() {
		// TODO Auto-generated method stub
		System.out.println("높이 점프할 수 있습니다.");
	}

	@Override
	public void turn() {
		// TODO Auto-generated method stub
		System.out.println("턴 할 수 없습니다.");
	}

	@Override
	public void showLevelMessage() {
		// TODO Auto-generated method stub
		System.out.println("중급자 레벨입니다.");
		
	}

}
