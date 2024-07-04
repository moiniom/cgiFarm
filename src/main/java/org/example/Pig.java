package org.example;

public class Pig extends FarmAnimal{
    public Pig(String name, int age, int weight) {
        super(
                name,
                "domesticated pig",
                age, weight,
                "Oink");
    }

    @Override
    String action() {
        return getName()+" sleeps and ignores you.";
    }
}
