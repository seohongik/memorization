package factory;

public abstract class PizzaStore extends Pizza {

    protected abstract Pizza createPizza(String type);
    public Pizza orderPizza(String type){

        Pizza pizza =null;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;

    }


}
