//패키지이름이 collection.arrayList입니다.
package collection.arrayList;

import collection.Member;

//클래스 이름이 MemberArrayListTest 입니다.
public class MemberArrayListTest {
	//메인 메서드가 생성되었습니다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//MemberArrayList 객체를 생성합니다.
		MemberArrayList memberArrayList =new MemberArrayList();
		
		//새로운 회원 인스턴스를 생성합니다.
		Member memberA = new Member(1001,"라이언");
		Member memberB = new Member(1002,"어피치");
		Member memberC = new Member(1003,"무지");
		
		//MemberArrayList에 회원을 추가합니다.
		memberArrayList.addMember(memberA);
		memberArrayList.addMember(memberB);
		memberArrayList.addMember(memberC);
		
		//전체 회원을 출력합니다.
		memberArrayList.showAllMembers();
		
		//어피치 회원을 삭제 합니다. 
		memberArrayList.remove(memberB.getMemberId());
		
		//전체 회원을 출력합니다.
		memberArrayList.showAllMembers();
		
		Member memberD=new Member(1003,"z콘");
		memberArrayList.addMember(memberD);
		memberArrayList.showAllMembers();
		
	}

}
