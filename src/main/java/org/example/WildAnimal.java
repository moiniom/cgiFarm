package org.example;

//extends Animal without doing anything
abstract class WildAnimal extends Animal{
    public WildAnimal(String reference, String sound, int age, int weight) {
        super(reference, sound, age, weight);
    }
}
