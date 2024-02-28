package decorator;

public class Decaf extends Beverage{
    int cost=6500;

    @Override
    public String getDescription() {
        return "디카페인 ";
    }

    @Override
    public int cost() {
        return cost;
    }
}
