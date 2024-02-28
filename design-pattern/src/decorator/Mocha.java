package decorator;

public class Mocha extends CondimentDecorator{
    private Beverage beverage;


    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }
    private int cost=3000;

    @Override
    public String getDescription() {
        return beverage.getDescription()+"첨가된 모카 ";
    }


    public int cost() {
        return beverage.cost()+cost;
    }
}
