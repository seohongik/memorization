package decorator;

public class Milk extends CondimentDecorator{

    private Beverage beverage;


    public Milk(Beverage beverage){
        this.beverage = beverage;
    }
    private int cost=3000;

    @Override
    public String getDescription() {
        return beverage.getDescription()+"첨가된 우유 ";
    }


    public int cost() {
        return beverage.cost()+cost;
    }

}
