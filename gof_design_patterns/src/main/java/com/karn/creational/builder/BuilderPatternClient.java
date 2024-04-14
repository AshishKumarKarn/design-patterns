package com.karn.creational.builder;

/**
 * Separate the construction of a complex object from its representation so that the
 * same construction process can create different representations
 */
public class BuilderPatternClient {
    public static void main(String[] args) {
        Builder builder = new NonVegMealBuilder();
        MealDirector mealDirector = new MealDirector(builder);
        mealDirector.prepareMeal();
        Meal meal = builder.build();
        System.out.println(meal);
    }
}

class MealDirector {
    private final Builder builder;

    public MealDirector(Builder builder) {
        this.builder = builder;
    }

    public void prepareMeal() {
        this.builder
                .addBread()
                .addCheese()
                .addSoftDrink()
                .addFries()
                .addEgg();
    }

    /*
    public Meal getMeal() {
        return this.builder.build();
    }
    */
}

abstract class Builder {

    protected int breadSize;
    protected int cheeseSlice;
    protected String softDrink;
    protected boolean hasFries;
    protected boolean hasEggs;

    public abstract Builder addBread();

    public abstract Builder addCheese();

    public abstract Builder addSoftDrink();

    public abstract Builder addFries();

    public abstract Builder addEgg();

    public abstract Meal build();
}

class VegMealBuilder extends Builder {

    @Override
    public Builder addBread() {
        this.breadSize = 12;
        return this;
    }

    @Override
    public Builder addCheese() {
        this.cheeseSlice = 2;
        return this;
    }

    @Override
    public Builder addSoftDrink() {
        this.softDrink = "Coke";
        return this;
    }

    @Override
    public Builder addFries() {
        this.hasFries = true;
        return this;
    }

    @Override
    public Builder addEgg() {
        this.hasEggs = false;
        return this;
    }

    @Override
    public Meal build() {
        return new Meal(this);
    }
}

class NonVegMealBuilder extends Builder {

    @Override
    public Builder addBread() {
        this.breadSize = 16;
        return this;
    }

    @Override
    public Builder addCheese() {
        this.cheeseSlice = 2;
        return this;
    }

    @Override
    public Builder addSoftDrink() {
        this.softDrink = "Coke";
        return this;
    }

    @Override
    public Builder addFries() {
        this.hasFries = true;
        return this;
    }

    @Override
    public Builder addEgg() {
        this.hasEggs = true;
        return this;
    }

    @Override
    public Meal build() {
        return new Meal(this);
    }

}

class MacChickenMaharajaMealBuilder extends Builder {

    @Override
    public Builder addBread() {
        this.breadSize = 18;
        return this;
    }

    @Override
    public Builder addCheese() {
        this.cheeseSlice = 2;
        return this;
    }

    @Override
    public Builder addSoftDrink() {
        this.softDrink = "Coke";
        return this;
    }

    @Override
    public Builder addFries() {
        this.hasFries = true;
        return this;
    }

    @Override
    public Builder addEgg() {
        this.hasEggs = true;
        return this;
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