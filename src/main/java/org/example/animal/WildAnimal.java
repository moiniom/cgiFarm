package org.example.animal;

import org.example.Feed;

//extends Animal without doing anything
public abstract class WildAnimal extends Animal{
    public WildAnimal(String reference, String sound, int age, int weight, Feed feed) {
        super(reference, sound, age, weight, feed);
    }
}
