//package이름이 abstractTest입니다.
package abstractTest;

//Laptop 클래스를 정의합니다.
//Laptop 클래스는 Conputer 클래스를 상속 받습니다.

/*
	Multiple markers at this line
- The type Desktop must implement the inherited abstract method 
 Computer.typing()
- The type Desktop must implement the inherited abstract method 
 Computer.display()
//방법1 source탭 방법 2 Desktop에 마우스로 조정 방법3 class앞에 abstract를 붙인다(재정의하지 않을 경우 여기선 typing())
*/

//Laptop 추상클래스는 Computer 추상클래스를 상속 받습니다.
public abstract class Laptop extends Computer {

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
		//추상 메서드의 몸체 코드를 작성합니다.
		System.out.println("Laptop display()");
		
	}

	

}
