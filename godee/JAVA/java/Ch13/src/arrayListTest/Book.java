//��Ű�� �̸��� arrayListTest�Դϴ�.
package arrayListTest;


//Book Ŭ������ �����մϴ�.
public class Book {
	
	
	//Book Ŭ������ �ʵ�(�������)�� �����Ͻÿ�
	

	private String bookName;	//å�̸�
	private String author;		//����

	//�����ڸ� �����Ͻÿ�

	//����Ʈ ������
	public Book() {
		
	}
	
	//�Ű� ������ �ִ� ������
	public Book(String bookName, String author) {
		
		this.bookName = bookName;
		this.author = author;
	}
	
	//�޼��� (����Լ�)�� �����Ͻÿ�
	public String getBookName() {
		return bookName;
	}
	


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	
	public String getAuthor() {
		return author;
	}
	
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	public void showBookInfo() {
		
		System.out.println(bookName+":"+author);
	}
	



}




	