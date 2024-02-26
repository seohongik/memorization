package strategy;

public class MallardDuck extends Duck{


    @Override
    public void swim() {
        System.out.println("힘차게 수영 한다.");
    }

    @Override
    public void display() {
        System.out.println("저는 물오리 입니다.");
    }
}
