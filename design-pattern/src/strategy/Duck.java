package strategy;

public abstract class Duck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public void performFly(){
        getFlyBehavior().fly();
    }

    public void performQuack(){
       getQuackBehavior().quack();
    }

    private FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    private QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    abstract public void swim();

    abstract public void display();
}
