package adapter;

public class MallardDuck implements Duck{

    @Override
    public void quack() {
        System.out.println("꽥");
    }

    @Override
    public void fiy() {
        System.out.println("날고 있어요");

    }
}
