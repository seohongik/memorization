//��Ű���̸��� collection.arrayList�Դϴ�.
package collection.arrayList;

import collection.Member;

//Ŭ���� �̸��� MemberArrayListTest �Դϴ�.
public class MemberArrayListTest {
	//���� �޼��尡 �����Ǿ����ϴ�.
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//MemberArrayList ��ü�� �����մϴ�.
		MemberArrayList memberArrayList =new MemberArrayList();
		
		//���ο� ȸ�� �ν��Ͻ��� �����մϴ�.
		Member memberA = new Member(1001,"���̾�");
		Member memberB = new Member(1002,"����ġ");
		Member memberC = new Member(1003,"����");
		
		//MemberArrayList�� ȸ���� �߰��մϴ�.
		memberArrayList.addMember(memberA);
		memberArrayList.addMember(memberB);
		memberArrayList.addMember(memberC);
		
		//��ü ȸ���� ����մϴ�.
		memberArrayList.showAllMembers();
		
		//����ġ ȸ���� ���� �մϴ�. 
		memberArrayList.remove(memberB.getMemberId());
		
		//��ü ȸ���� ����մϴ�.
		memberArrayList.showAllMembers();
		
		Member memberD=new Member(1003,"z��");
		memberArrayList.addMember(memberD);
		memberArrayList.showAllMembers();
		
	}

}