package com.karn.creational.builder;
/**
 * Separate the construction of a complex object from its representation so that the
 * same construction process can create different representations
 * */
public class Client {
    public static void main(String[] args) {
        Builder builder = new NonVegMealBuilder();
        MealDirector mealDirector = new MealDirector(builder);
        mealDirector.prepareMeal();
        Meal meal = mealDirector.getMeal();
        System.out.println(meal);
    }
}

class MealDirector {
    private final Builder builder;

    public MealDirector(Builder builder) {
        this.builder = builder;
    }

    public void prepareMeal() {
        this.builder.addBread();
        this.builder.addCheese();
        this.builder.addSoftDrink();
        this.builder.addFries();
        this.builder.addEgg();
    }

    public Meal getMeal() {
        return this.builder.build();
    }
}

abstract class Builder {

    protected int breadSize;
    protected int cheeseSlice;
    protected String softDrink;
    protected boolean hasFries;
    protected boolean hasEggs;

    public abstract void addBread();

    public abstract void addCheese();

    public abstract void addSoftDrink();

    public abstract void addFries();

    public abstract void addEgg();

    public abstract Meal build();
}

class VegMealBuilder extends Builder {

    @Override
    public void addBread() {
        this.breadSize = 12;
    }

    @Override
    public void addCheese() {
        this.cheeseSlice = 2;
    }

    @Override
    public void addSoftDrink() {
        this.softDrink = "Coke";
    }

    @Override
    public void addFries() {
        this.hasFries = true;
    }

    @Override
    public void addEgg() {
        this.hasEggs = false;
    }

    @Override
    public Meal build() {
        return new Meal(this);
    }
}

class NonVegMealBuilder extends Builder {

    @Override
    public void addBread() {
        this.breadSize = 16;
    }

    @Override
    public void addCheese() {
        this.cheeseSlice = 2;
    }

    @Override
    public void addSoftDrink() {
        this.softDrink = "Coke";
    }

    @Override
    public void addFries() {
        this.hasFries = true;
    }

    @Override
    public void addEgg() {
        this.hasEggs = true;
    }

    @Override
    public Meal build() {
        return new Meal(this);
    }

}

class MacChickenMaharajaMealBuilder extends Builder {

    @Override
    public void addBread() {
        this.breadSize = 18;
    }

    @Override
    public void addCheese() {
        this.cheeseSlice = 2;
    }

    @Override
    public void addSoftDrink() {
        this.softDrink = "Coke";
    }

    @Override
    public void addFries() {
        this.hasFries = true;
    }

    @Override
    public void addEgg() {
        this.hasEggs = true;
    }

    @Override
    public Meal build() {
        return new Meal(this);
    }

}

class Meal {
    private final int breadSize;
    private final int cheeseSlice;
    private final String softDrink;
    private final boolean hasFries;
    private final boolean hasEggs;


    public Meal(Builder builder) {
        this.softDrink = builder.softDrink;
        this.breadSize = builder.breadSize;
        this.cheeseSlice = builder.cheeseSlice;
        this.hasFries = builder.hasFries;
        this.hasEggs = builder.hasEggs;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Meal{").append("breadSize=").append(breadSize).append(", cheeseSlice=").append(cheeseSlice).append(", softDrink='").append(softDrink).append('\'').append(", hasFries=").append(hasFries).append(", hasEggs=").append(hasEggs).append('}').toString();
    }
}