package org.example;

public class Kangaroo extends WildAnimal{
    public Kangaroo(int age, int weight) {
        super(
                "wild kangaroo",
                "Kangaroo noises idk",
                age, weight);
    }

    @Override
    String action() {
        return "You try to fight the kangaroo. It's not even close.";
    }
}
