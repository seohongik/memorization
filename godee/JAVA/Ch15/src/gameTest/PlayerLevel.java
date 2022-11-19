//package이름이 gameTest입니다
package gameTest;


//추상 클래스를 정의합니다.
public abstract class PlayerLevel {
	
	//추상 메서드를 선언합니다.
	
	public abstract void run();
	public abstract void jump();
	public abstract void turn();
	public abstract void showLevelMessage();
	
	
	final public void go(int count) {
		
		run();
		for(int i=0; i<count; i++) {
			jump();
		}
		turn();
	}
	

}
