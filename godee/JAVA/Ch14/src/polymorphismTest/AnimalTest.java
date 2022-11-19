//package polymorphismTest입니다.
package polymorphismTest;



//Animal 클래스를 정의합니다.
class Animal{
	
	//메서드 (멤버함수)를 정의합니다.
	public void move() {
		
		
		System.out.println("동물이 움직입니다.");
	}
	
	
}
//Human 클래스를 정의합니다.
class Human extends Animal{
	
	//메서드(멤버 함수)를 정의합니다.
	
	public void move() {
		
		System.out.println("사람이 두발로 걷습니다.");
		
	}
	
}

//Tiger 클래스를 정의합니다.

class Tiger extends Animal{
	
	
	//메서드(멤버 함수)를 정의합니다.
	
		public void move() {
			
			System.out.println("호랑이가 네 발로 뜁니다.");
			
		}
	
	
}

//Eagle 클래스를 정의합니다.

class Eagle extends Animal{
	
	public void move() {
		
		System.out.println("독수리가 하늘을 납니다.");
		
	}


}






//class이름이 AnimalTest 입니다.
public class AnimalTest {
	//main() 메서드 가 생성되었습니다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnimalTest aTest = new AnimalTest();
		
		//사람 객체를 생성하여 매개 변수로 전달합니다.
		
		//Animal animal=new Human(); 과 같다
		aTest.moveAnimal(new Human());
		
		//호랑이 객체를 생성하여 매개변수로 전달합니다.
		
		//Animal animal=new Tiger();
		aTest.moveAnimal(new Tiger());
		
		
		//독수리 객체를 생성하여 매개변수로 전달합니다.
		//Animal animal=new Eagle()
		aTest.moveAnimal(new Eagle());
		
		
		
	}
	//움직이는 동작을 수행하는 메서드
	//Animal -> 매개변수의 자료형이 상위 클래스입니다.
	public void moveAnimal(Animal animal) {
		//재정의된 메서드를 호출합니다.
		animal.move();
		
		
	}

}
