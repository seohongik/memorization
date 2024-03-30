package adapter;

public class Main {
    public static void main(String[] args) {
        /*어뎁터 패턴(Adapter Pattern)은 특정 클래스 인터페이스를 클러이언트에서 요구하는 다른 인터페이스로 변환
         * 인터페이스가 서로 호환 되지 않아 같이 쓸 수 없었던 클래스를 사용할 수 있게 도와줌
         * */

        Duck duck = new MallardDuck();

        Turkey turkey = new WildTurkey();

        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("칠면조가 말하길");

        turkey.gobble();
        turkey.fly();

        System.out.println("오리가 말하길");
        testDuck(duck);

        System.out.println("칠면조가 어뎁터가 말하길");
        testDuck(turkeyAdapter);
    }

    public static void testDuck(Duck duck){
        duck.quack();
        duck.fiy();
    }
}
