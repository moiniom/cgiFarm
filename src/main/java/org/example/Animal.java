package org.example;

public abstract class Animal {
    public Animal(String reference, String sound, int age, int weight, Feed feed) {
        this.reference = reference;
        this.sound = sound;
        this.age = age;
        this.weight = weight;
        this.feedType = feed;
    }

    //all the Variables an Animal could need
    private String name = "";  //only farm animals actually change this Value
    private final int age;
    private final int weight;
    private final String reference;
    private final String sound;
    private boolean isHungry = false;
    public final Feed feedType;

    //method in which the action of the animal is later implemented
    abstract String action();

    //Methods to allow interaction
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


