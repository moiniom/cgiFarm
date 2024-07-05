package org.example.animal;

import org.example.Feed;

public class Chicken extends FarmAnimal {

    public Chicken(String name, int age, int weight) {
        super(
                name,
                "domesticated chicken",
                age, weight,
                "bawk-bawk",
                Feed.type.SEEDS);
    }

    @Override
    String action() {
        return getName() + " laid " + Math.round(Math.random() * 10) + " eggs.";
    }
}
