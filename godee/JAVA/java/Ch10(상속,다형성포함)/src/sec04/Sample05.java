package sec04;

public class Sample05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1= new RacingCar();
		car1.setCar(1234, 20.123);
		//중요 슈퍼클래스 변수를 사용해서 서브클래스 객체를 다룰 수 있습니다.
		//업케스팅 vs 다운캐스팅
		car1.show();
	}

}
