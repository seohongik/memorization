//패키지 이름이 kakaoGame입니다
package kakaoGame;

//Ryan 클래스를 정의합니다.
//Ryan 클래스를 Charater 클래스를 상속 받습니다. 
public class Ryan extends Character {
	
	//디폴트 생성자를 정의합니다
	Ryan(){
		
		hp=30;
		energy=50;
		System.out.println("라이언이 생성되었습니다");
		printInfo();
		
	}
	

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		energy+=10;
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		energy+=5;
	}

	@Override
	public boolean play() {
	
		// TODO Auto-generated method stub
		energy -=20;
		hp+=5;
		levelUp();
		return checkEnergy();
		
		
	}

	@Override
	public boolean train() {
		// TODO Auto-generated method stub
		energy -=15;
		hp+=20;
		levelUp();
		return false;
	}

	@Override
	public void levelUp() {
		// TODO Auto-generated method stub
		if(40<=hp) {
			level++;
			hp-=40;
		}
		
		
	}

}
