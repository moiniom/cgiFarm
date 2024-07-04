package org.example.animal;

import org.example.Feed;

public class Dog extends FarmAnimal {
    public Dog(String name, int age, int weight) {
        super(
                name,
                "domesticated dog",
                age, weight,
                "Bark-Bark",
                new Feed("Steaks", 10));
    }

    @Override
    String action() {
        return getName() + " wants to play, so you throw a stick and " + getName() + " gets it.";
    }
}
