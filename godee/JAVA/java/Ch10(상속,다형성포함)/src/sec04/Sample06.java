package sec04;

public class Sample06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car[] cars;
		cars =new Car[2];
		
		cars[0] =new Car();
		cars[0].setCar(123, 10.123);
		
		cars[1] =new RacingCar();
		cars[1].setCar(456, 20.345);
		
		for(int i=0; i<cars.length; i++) {
			
			cars[i].show();
			
		}
		
	}

}
