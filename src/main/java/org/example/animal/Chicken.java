package org.example.animal;

import org.example.Feed;

public class Chicken extends FarmAnimal {

    public Chicken(String name, int age, int weight) {
        super(
                name,
                "domesticated chicken",
                age, weight,
                "bawk-bawk",
                new Feed("Seeds", 5));
    }

    @Override
    String action() {
        return getName() + " laid " + Math.round(Math.random() * 10) + " eggs.";
    }
}
