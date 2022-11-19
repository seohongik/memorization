//package이름이 gameTest 입니다.
package gameTest;

// SuperLevel class를 정의합니다.
//SuperLevel 클래스는 PlayerLevel 클래스르 상속받습니다.
public class SuperLevel extends PlayerLevel{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("엄청 빨리 달립니다.");
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		System.out.println("아주 높이 점프합니다.");
	}

	@Override
	public void turn() {
		// TODO Auto-generated method stub
		System.out.println("한 바퀴 돕니다.");
	}

	@Override
	public void showLevelMessage() {
		// TODO Auto-generated method stub
		System.out.println("고급자 레벨이비낟.");
	}

}
