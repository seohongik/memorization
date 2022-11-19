//패키지이름이 collection.arrayList입니다.
package collection.arrayList;

import java.util.ArrayList;

import collection.Member;

//MemberArrayList 클래스를 정의합니다.
public class MemberArrayList {

	//필드 (멤버변수)를 선언합니다. 
	
	private ArrayList<Member> arrayList;
	
	//디폴트 생성자를 정의합니다.
	public MemberArrayList() {
		//Member 형으로 선언한 ArrayList를 생성합니다.
		arrayList=new ArrayList<Member>();
		
		
		
	}
	
	//메서드 (멤버 함수)를 정의합니다.
	//회원을 추가하는 메서드
	public void addMember(Member member) {
		
		arrayList.add(member);
		
		
	}
	//회원을 삭제하는 메서드
	public boolean remove(int memberId) {
		for(int i=0; i<arrayList.size(); i++) {
			
			//get 메서드로 회원을 순차적으로 가져옵니다.
			Member member=arrayList.get(i);
			int tempId=member.getMemberId();
			
			//회원 아이디가 매개변수와 일치하면
			if(tempId==memberId) {
				//해당 회원을 삭제합니다. 
				arrayList.remove(i);
				return true;
			}
			
		}
		//반복문이 끝날때 까지 해당 아이디를 찾지 못한 경우 매시지를 출력합니다.
		System.out.println(memberId+"가 존재하지 않습니다.");
		return false;	
		
	}
	
	//전체 회원을 출력하는 메서드를 정의
	public void showAllMembers() {
		for(Member member : arrayList) {
			
			System.out.println(member);
			
		}
		
		System.out.println();
		
		
	}
	
	//아이디를 중보고딘 회원을 추가합니다. .
	

	

	
	
	
}
