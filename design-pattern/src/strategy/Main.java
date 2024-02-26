package strategy;

public class Main {

    /**
     * 전략 패턴(strategy Pattern)은 알고리즘 군을 정의 하고 캡슐화 해서 각각의 알고리즘 군을 수정 해서 쓸 수 있게 해줌 즉, 알고리즘 분리 해서 독립적 사용 가능
     *
     * */
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.setFlyBehavior(new FlyWithWings());
        mallardDuck.setQuackBehavior(new Squeak());

        mallardDuck.performQuack();
        mallardDuck.performFly();
        mallardDuck.swim();
        mallardDuck.display();

        System.out.println("================");

        Duck modelDuck = new ModelDuck();
        modelDuck.setQuackBehavior(new MuteQuack());
        modelDuck.setFlyBehavior(new FlyNoWay());
        modelDuck.performQuack();
        modelDuck.performFly();
        modelDuck.swim();
        modelDuck.display();

    }
}
