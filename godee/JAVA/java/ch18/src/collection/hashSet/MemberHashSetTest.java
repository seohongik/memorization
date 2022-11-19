//패키지이름이 collection.hashSet입니다.
package collection.hashSet;

import collection.Member;

//클래스 이름 MemberHashSetTest
public class MemberHashSetTest {
	
	//main()메서드가 생성되었습니다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//memberHashSet 객체를 생성하빈다. 
		MemberHashSet memberHashSet =new MemberHashSet();
		
		//회원을 생성합니다. 
		Member memberA= new Member(1001,"라이언");
		Member memberB= new Member(1002,"어피치");
		Member memberC= new Member(1003,"무지");
		
		//회원을 추가합니다. 
		memberHashSet.addMember(memberA);
		memberHashSet.addMember(memberB);
		memberHashSet.addMember(memberC);
		//전체 회원을 출력합니다. 
		memberHashSet.ShowAllMembers();
		
		//어피치 회원을 삭제합니다. 
		memberHashSet.removeMember(memberB.getMemberId());
		
		//전체 회원을 출력합니다. 
		memberHashSet.ShowAllMembers();
				
		//아이디를 중복된 회원을 추가합니다. 
		Member memberD= new Member(1003,"콘");
		
		memberHashSet.addMember(memberD);
		
		//전체 회원을 출력합니다. 
		memberHashSet.ShowAllMembers();
	}

}
