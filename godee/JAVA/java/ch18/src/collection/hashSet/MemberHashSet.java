//패키지이름이 collection.hashSet 입니다.
package collection.hashSet;

import java.util.HashSet;
import java.util.Iterator;

import collection.Member;

//MemberHashSet 클래스를 정의합니다. 
public class MemberHashSet {

	
	//필드 (멤버 변수)를 선언합니다. 
	private HashSet<Member> hashSet;
	
	//디폴트 생성자를 정의합니다. 
	
	public MemberHashSet() {
		//HashSet 객체를 생성합니다. 
		
		hashSet = new HashSet<Member>();
	}
	//메서드(멤버함수)를 정의합니다.
	
	//회원을 추가하는 메서드
	
	public void addMember(Member member) {
		
		hashSet.add(member);
		
	}
	
	//회원을 삭제하는 메서드
	
	public boolean removeMember(int memberId) {
		//lterator를 활용해 순회합니다. 
		
		Iterator<Member> iMember =hashSet.iterator();
		
		
		while(iMember.hasNext()) {
			//회원을 하나씩 가져옵니다.
			Member member = iMember.next();
			int tempId = member.getMemberId();
			//아이디를 비교하여 같은 아이디인경우
			
			if(tempId == memberId) {
				
				//회원을 삭제합니다. 
				hashSet.remove(member);
				return true;
			}
			
		}
		System.out.println(memberId+"가 존재하지 않습니다.");
		return false;
	}
	
	//전체 회원을 출력하는 메서드 
	
	public void ShowAllMembers() {
		
		for(Member member:hashSet) {
			System.out.println(member);
			
		}
		System.out.println();
		
	}
	
}
