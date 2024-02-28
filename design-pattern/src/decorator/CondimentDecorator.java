package decorator;

public abstract class CondimentDecorator extends Beverage{

    private Beverage beverage;

    private String description;

    public  abstract String getDescription();

    int cost;

    public int cost(){
        return cost;
    }
}
