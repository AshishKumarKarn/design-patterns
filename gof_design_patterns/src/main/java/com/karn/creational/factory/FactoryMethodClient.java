package com.karn.creational.factory;

import java.util.ArrayList;
/**
 *
 * The Factory Method Pattern defines an interface
 * for creating an object, but lets subclasses decide which
 * class to instantiate. Factory Method lets a class defer
 * instantiation to subclasses.
 * */
public class FactoryMethodClient {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYStylePizzaStore();
        Pizza p1 = pizzaStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + p1.getName() + "\n");
        PizzaStore pizzaStore1 = new ChicagoStylePizzaStore();
        Pizza p2 = pizzaStore1.orderPizza("cheese");
        System.out.println("Joel ordered a " + p2.getName() + "\n");


    }

}
abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
    protected abstract Pizza createPizza(String type);
}
class NYStylePizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new NYStyleCheesePizza();
        }else if(type.equals("plain")){
            return new NYStylePlainPizza();
        }
        return null;
    }
}

class ChicagoStylePizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new ChicagoStyleCheesePizza();
        }else if(type.equals("plain")){
            return new ChicagoStylePlainPizza();
        }
        return null;
    }
}

abstract class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<>();
    public void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings: ");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println(" " + toppings.get(i));
        }
    }
    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }
    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }
    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }
    public String getName() {
        return name;
    }
}
class NYStyleCheesePizza extends Pizza {
    NYStyleCheesePizza(){
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
        toppings.add("Grated Blue Cheese");
    }
}
class NYStylePlainPizza extends Pizza {
    NYStylePlainPizza(){
        name = "NY Style Sauce Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Oregano");
    }
}
class ChicagoStyleCheesePizza extends Pizza {
    ChicagoStyleCheesePizza(){
        name = "Chicago Style Sauce and Cheese Pizza";
        dough = "Thick Crust Dough";
        sauce = "Magic Sauce";
        toppings.add("Grated Reggiano Cheese");
        toppings.add("Grated Blue Cheese");
    }
}
class ChicagoStylePlainPizza extends Pizza {
    ChicagoStylePlainPizza(){
        name = "Chicago Style Sauce Plain Pizza";
        dough = "Thick Crust Dough";
        sauce = "Magic Sauce";
    }
}