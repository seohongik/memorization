package strategy;

public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("아무 소리도 못낸다.");

    }
}
