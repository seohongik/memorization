//패키지이름이 arrayListTest 입니다.
package arrayListTest;


import java.util.ArrayList;



//클래스이름이 ArrayListTest 입니다.
public class ArrayListTest {
	//메인 메서드()가 생성되었습니다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//ArrayList를 선언합니다.
		ArrayList<Book> library=new ArrayList<Book>();
		
		Book book;
		//add()메서드로 요소값을 추가
		library.add(new Book("HTML가 보이는 그림책","이영란"));
		library.add(new Book("자바가 보이는 그림책","김성훈"));	
			
		
		
		//배열에 추가된 요소 개수만큼 출력합니다.
		for(int i=0; i<library.size(); i++) {
			
			Book book=library.get(i);
			book.showBookInfo();
			
		}
		
		//향상된 for 문
		
	//	for(Book book:library) {
			
	//		book.showBookInfo();
		}
		
		
		
		
		
	}

}
