package org.example.animal;

import org.example.Feed;

public class Kangaroo extends WildAnimal {
    public Kangaroo(int age, int weight) {
        super(
                "wild kangaroo",
                "Kangaroo noises idk",
                age, weight,
                new Feed("Penguins", 30));
    }

    @Override
    String action() {
        return "You try to fight the kangaroo. It's not even close.";
    }
}
