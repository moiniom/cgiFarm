package org.example;

public class Cow extends FarmAnimal {
    public Cow(String name, int age, int weight) {
        super(
                name,
                "domesticated cow",
                age, weight,
                "Mooohh");
    }

    @Override
    String action() {
        return "You milk "+getName()+". They give "+(Math.round(Math.random()*10+5))+" liters of milk.";
    }
}
