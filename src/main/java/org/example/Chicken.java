package org.example;

public class Chicken extends FarmAnimal{

    public Chicken(String name, int age, int weight) {
        super(
                name,
                "domesticated chicken",
                age, weight,
                "bawk-bawk");
    }

    @Override
    String action() {
        return name+" laid "+Math.round(Math.random()*10)+" eggs.";
    }
}
