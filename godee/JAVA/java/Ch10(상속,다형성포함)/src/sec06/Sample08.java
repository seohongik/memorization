package sec06;
class Car{
	
	protected int num;
	protected double gas;
	
	public Car() {
		
		num=0;
		gas= 0.0;
		System.out.println("자동차가 생성되었습니다.");
		
		
	}
	
}

class RacingCar extends Car{
	
	private int course;

	public RacingCar() {
		
		course = course;
		System.out.println("레이싱 카가 생성되었습니다.");
	}
	
	
}





public class Sample08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car[] cars =new Car[2];
		
		cars[0] = new Car();
		cars[1] = new RacingCar();
		
		for(int i=0; i<cars.length; i++) {
			Class c1 = cars[i].getClass();
			System.out.println(c1);
			
		}
		
	}

}
