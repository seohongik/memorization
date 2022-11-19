//package이름이 abstractTest입니다.
package abstractTest;


//MyLaptop 클래스를 정의합니다.

//MyLaptop 클래스는 Laptop 추상클래스를 상속받습니다.
//The type MyLaptop must implement the inherited abstract method Computer.typing()
public class MyLaptop extends Laptop {

	@Override
	public void typing() {
		// TODO Auto-generated method stub
		//추상 메서드의 몸체 코드를 작성합니다.
		System.out.println("MyLaptop typing()");
	}

}
