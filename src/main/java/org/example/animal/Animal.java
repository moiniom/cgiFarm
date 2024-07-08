package org.example.animal;

import org.example.Feed;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    public Animal(String reference, String sound, int age, int weight, Feed.type feed) {
        this.reference = reference;
        this.sound = sound;
        this.age = age;
        this.weight = weight;
        this.feed = feed;
    }

    //all the Variables an Animal could need
    private String name = "";  //only farm animals actually change this Value
    private final int age;
    private final int weight;
    private final String reference;
    private final String sound;
    private boolean isHungry = false;
    public final Feed.type feed;

    //method in which the action of the animal is later implemented
    abstract String action();

    //Methods to allow interaction
    public String doSound() {
        return sound;
    }

    public String doAction() {
        if (isHungry) {
            return "The " + reference + " is Hungry and thus can't do that.";
        }
        isHungry = true;
        return action();
    }

    public String feed() {
        isHungry = false;
        return "You feed the " + reference + ".\nThey aren't hungry anymore";
    }

    public List<String> getInfo() {
        List<String> info = new ArrayList<>(); //{reference, name, String.valueOf(age), String.valueOf(weight), String.valueOf(isHungry)};
        info.add(reference);
        info.add(name);
        info.add(String.valueOf(age));
        info.add(String.valueOf(weight));
        info.add(String.valueOf(isHungry));
        return info;
    }

    //Getter/Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }
}


