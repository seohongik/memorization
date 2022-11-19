//패키지 이름은 classTest입니다.
package classTest;

//클래스 이름이 studentTest입니다.
public class StudentTest {
	
	
	//main()메소드가 생성되었습니다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		//학생 두명을 생성합니다.
		Student studentA=new Student("라이언",5000);
		Student studentB=new Student("무지",10000);
		
		//노선 번호가 100번인 버스를 생성합니다.
		Bus busA=new Bus(100);
		
		//StudentA가 100번 버스를 탑니다.
		studentA.takeBus(busA);
		
		//studentA의 정보를 출력합니다.
		studentA.showInfo();
		
		//버스 정보를 출력합니다.
		busA.showInfo();

		//노선 번호가 1호선인 지하철을 생성합니다.
		Subway subwayA=new Subway("2호선");

		//studentB가 2호선을 탑니다.
		studentB.takeSubway(subwayA);
		
		//studentB의 정보를 출력합니다.
		studentB.showInfo();
		
		//지하철 정보를 출력합니다.
		subwayA.showInfo();
		
		
		
	}

}
