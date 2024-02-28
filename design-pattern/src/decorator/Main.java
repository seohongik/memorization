package decorator;

public class Main {

    /***
     *
     * 데코레이터 패턴(Decorator Pattern) 으로 객체에 추가 요소를 동적으로 더할 수 있다. 데코레이터를 사용하면 서브 클래스를 만들 때보다 훨씬 유연하게 기능을 확장할 수 있다.
     *
     * */
    public static void main(String[] args) {

        Beverage beverage = new DarkRoast();

        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);

        System.out.println(beverage.getDescription());
        System.out.println(beverage.cost());

    }
}
