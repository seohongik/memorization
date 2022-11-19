package collection;

public class Member {
	
	
	private int memberId;
	private String memberName;
	
	public Member(int memberId,String memberName) {
		this.memberId=memberId;
		this.memberName=memberName;
			
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return memberName+ "회원님의 아이디는" +memberId+"입니다.";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		
		//hashCode()메소드가 회원 아이디를 반환하도록 재정의합니다. 
		return memberId;
	
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		//매개변수로 받은 회원 아이디가 자신의 회원 아이디와 같다면 true로 반환합니다. 
		if(obj instanceof Member) {
			
			Member member=(Member)obj;
			if(this.memberId==member.memberId) 
				return true;
			else 
				return false;
			
			
		}
		
		return false;
	}
	
	
	
	
	
	

}
