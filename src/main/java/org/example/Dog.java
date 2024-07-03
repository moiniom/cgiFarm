package org.example;

public class Dog extends FarmAnimal{
    public Dog(String name, int age, int weight) {
        super(
                name,
                "domesticated dog",
                age, weight,
                "Bark-Bark");
    }

    @Override
    String action() {
        return name+" wants to play, so you throw a stick and "+name+" gets it.";
    }
}
