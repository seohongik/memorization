package factory;

public class Main {
    /*펙토리 메소드 패턴(factory method patter)은 객체를 생성할 때 필요한 인터페이스를 만들고
      어떤 클래스의 인스턴스를 만들지는 서브클레스에서 결정 팩토리 메소드 패턴을 사용하면 클래스 인스턴스 만드는 일을 서브 클래스에게 맡기게 된다.
      사용하는 서브클래스에 따라 생산되는 객체 인스턴스가 결정된다.*/
    public static void main(String[] args) {
        PizzaStore newYorkStore = new NYPizzaStore();
        Pizza pizzaEdan = newYorkStore.orderPizza("cheese");
        System.out.println("에단이 주문한 "+pizzaEdan.getName());
        System.out.println("=======================================");
        Pizza pizzaJoel = newYorkStore.orderPizza("veggie");
        System.out.println("조엘이 주문한 "+pizzaJoel.getName());

    }
}
