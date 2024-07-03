package org.example;

public abstract class Animal {
    public Animal(String reference, String sound, int age, int weight) {
        this.reference = reference;
        this.sound = sound;
        this.age = age;
        this.weight = weight;
    }

    String name = "";
    int age;
    int weight;
    String reference;
    String sound;
    boolean isHungry = false;

    abstract String action();

    public String doSound() {return sound;}

    public String doAction() {
        if(isHungry) {
            return "The "+reference+" is Hungry and thus can't do that.";
        }
        isHungry = true;
        return action();
    }

    public String feed() {
        if(isHungry) {
            isHungry = false;
            return "You feed the "+reference+".\nThey aren't hungry anymore";
        }
        return "The "+reference+" isn't hungry. You can't feed them.";
    }

    public String[] getInfo() {
        return new String[] {reference, name, String.valueOf(age), String.valueOf(weight), String.valueOf(isHungry)};
    }
}


