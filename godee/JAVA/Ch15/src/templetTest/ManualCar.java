//package이름은 templetTest입니다.
package templetTest;


// ManualCar class가 정의되었습니다.

//ManualCar 클래스는 Car 추상클래스를 상속받습니다.
public class ManualCar extends Car {

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("사람이 운전합니다.");
		System.out.println("사람이 핸들을 조작합니다.");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("사람이 브레이크로 정지합니다.");
	}
	
	
	

}
