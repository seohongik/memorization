class Car{//클레스 정의
	
	int num; //차량번호
	double gas; //연료량
	
	
}


public class Sample01 {
	
		public static void main(String[] args) {
		
			Car car1;
			car1 = new Car(); //인스턴스화 (오브젝트 생성)
			
			car1.num =1234;
			car1.gas=90.567;
			
			System.out.println("차량번호는" + car1.num +"입니다"); //출력
			
			System.out.println("연료량은" + car1.gas +"입니다"); //출력
			
		}

}
