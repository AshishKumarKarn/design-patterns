package com.karn.creational.builder;

// builder inheritance with recursive generics

class Person {
    public String name;

    public String position;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("Person{")
                .append("name='")
                .append(name)
                .append("', position='")
                .append(position)
                .append("'}").toString();

    }
}

class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();

    // critical to return SELF here
    public SELF withName(String name) {
        person.name = name;
        return self();
    }

    protected SELF self() {
        // unchecked cast, but actually safe
        // proof: try sticking a non-PersonBuilder
        //        as SELF parameter; it won't work!
        return (SELF) this;
    }

    public Person build() {
        return person;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder worksAs(String position) {
        person.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}

public class FluentBuilderInheritanceRecursiveGenericsClient {
    public static void main(String[] args) {
        EmployeeBuilder eb = new EmployeeBuilder()
                .withName("Dmitri")
                .worksAs("Quantitative Analyst");
        System.out.println(eb.build());
    }
}