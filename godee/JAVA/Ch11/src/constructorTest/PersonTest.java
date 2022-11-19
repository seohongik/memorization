//패키지 이름이 constructorTest입니다.
package constructorTest;

//클래스 이름이 Person입니다.

class Person{

	//필드(멤버변수)를 선언합니다.
	//이름
	String name;
	
	//키
	int height;
	
	//몸무게
	double weight;
	
	//성별
	
	char gender;
	
	//결혼 유무
	boolean married;
	
	//디폴트 생성자(자바 컴파일러가 자동으로 제공해 줍니다.)
	public Person() {}
	
	
	//사람 이름을 매개 변수로 입력 받아 Person 클래스로 생성하는 생성자
	
	public Person(String pName) {
		
		name =pName;
		
		
		
	}
	
	//이름 키 몸무게를 매개 변수로 입력 받는 생성자
	
	public Person(String pName, int pHeight, double pWeight) {
		
		name =pName;
		height=pHeight;
		weight=pWeight;
		
		
	}
	
}

//클래스 이름이 PersonTest입니다.
public class PersonTest {
	
	//main() 메서드가 생성되었습니다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//오류 해결방안 1-디폴트 생성자를 만들다
		Person person1=new Person();

		//오류 해결방안 - 매개변수가 있는 생성자를 만들다
		Person person2=new Person("라이언");
		
		//디폴트 생성자로 클래스를 생성한 후 인스턴스 변수 값을 따로 초기화 합니다.
		Person person3=new Person();
		person3.name="무지";
		person3.height=170;
		person3.weight=60.9;
		
		//가급적이면 밑에 형태로 만들어 주는게 바람직하다.
		
		//인스턴스 변수 초기화와 동시에 클래스를 생성합니다.
		//-->코드도 간결하고 사용하기도 편리하다는 장점을 가집니다.
		Person person4=new Person("어피치",180,40.5);
	}

}
