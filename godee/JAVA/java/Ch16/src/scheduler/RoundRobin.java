//package이름이 scheduler입니다.
package scheduler;

//RoundRobin클래스를 정의합니다.
//RoundRobin클래스는 Scheduler 인터페이스를 구현합니다.
//상담원 한 명씩 돌아가며 동일하게 상담 업무를 배분합니다.
public class RoundRobin implements Scheduler {

	@Override
	public void getNextCall() {
		// TODO Auto-generated method stub
		System.out.println("상담 전화를 순서대로 대기열에서 가져옵니다.");
	
	}

	@Override
	public void sendCallToAgent() {
		// TODO Auto-generated method stub
		System.out.println("다음 순서 상담원에게 배분합니다.");
	}

}
