package adapter;

public class TurkeyAdapter implements Duck{

    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fiy() {
        for (int i=0; i<5; i++) {
            turkey.fly();
        }
    }
}
