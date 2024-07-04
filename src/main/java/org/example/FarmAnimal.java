package org.example;

//Extends Animal
abstract class FarmAnimal extends Animal{
    public FarmAnimal(String name, String reference, int age, int weight, String sound) {
        super(reference,sound, age, weight);
        //Adds name
        this.name = name;
    }

    //Changes the interaction text
    @Override
    public String doAction() {
        if(isHungry) {
            return name+" is Hungry and thus can't do that.";
        }
        isHungry = true;
        return action();
    }

    //Changes the feed text
    @Override
    public String feed() {
        if(isHungry) {
            isHungry = false;
            return "You feed "+name+".\nThey aren't hungry anymore.";
        }
        return name+" isn't hungry. You can't feed them.";
    }
}
