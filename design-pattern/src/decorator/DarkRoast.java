package decorator;

public class DarkRoast extends Beverage {

    int cost=4500;

    @Override
    public String getDescription() {
        return "다크로스트 ";
    }

    @Override
    public int cost() {
        return cost;
    }
}
