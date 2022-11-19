//패키지는 kakaoGame;
package kakaoGame;

//추상클래스 Charater를 정의합니다.

public abstract class Character  {

	//필드 (멤버변수)를 선언합니다. 
	protected int hp;
	protected int level;
	protected int energy;
	
	//추상 메서드를 선언합니다. 
	public abstract void eat();
	public abstract void sleep();
	public abstract boolean play();
	public abstract boolean train();
	public abstract void levelUp();
	
	//메서드 (멤버함수)를 정의합니다.
	public boolean checkEnergy() {
		
		if(energy<=0) {
			
			return true;
		}else {
			
			return false;
		}
		
	}
	//캐릭터 정보를 출력하는 메서드를 정의합니다.
	public void printInfo() {
		
		
		System.out.println("=========현재 캐릭터의 정보 출력=========");
		System.out.println("hp  :"+hp);
		System.out.println("energy :"+energy);
		System.out.println("level  :"+level);
	}

}
