package org.example.animal;

import org.example.Feed;

//Extends Animal
public abstract class FarmAnimal extends Animal {
    public FarmAnimal(String name, String reference, int age, int weight, String sound, Feed feed) {
        super(reference, sound, age, weight, feed);
        //Adds name
        this.setName(name);
    }

    //Changes the interaction text
    @Override
    public String doAction() {
        if (isHungry()) {
            return getName() + " is Hungry and thus can't do that.";
        }
        setHungry(true);
        return action();
    }

    //Changes the feed text
    @Override
    public String feed() {
        if (isHungry()) {
            setHungry(false);
            return "You feed " + getName() + ".\nThey aren't hungry anymore.";
        }
        return getName() + " isn't hungry. You can't feed them.";
    }
}
