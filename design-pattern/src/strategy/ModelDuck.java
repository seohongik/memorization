package strategy;

public class ModelDuck extends Duck{
    @Override
    public void swim() {
        System.out.println("수영 못함");
    }

    @Override
    public void display() {
        System.out.println("모델 장난감");
    }
}
