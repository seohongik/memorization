package strategy;

public class FlyWithWings implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("날개짓 하며 퍼덕 퍼덕");
    }
}
