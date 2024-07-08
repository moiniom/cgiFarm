package org.example.farm;

import org.example.animal.Animal;
import org.example.animal.Chicken;

import java.util.ArrayList;
import java.util.List;

public class ChickenStable implements Stable {

    public ChickenStable(Farm farm) {
        this.farm = farm;
    }

    private List<Animal> chickens = new ArrayList<>();
    private final Farm farm;

    @Override
    public void addAnimal(Animal animal) {
        if(!(animal instanceof Chicken)) {
            throw new IllegalArgumentException("Tried adding non Pig to PigStable");
        }
        chickens.add(animal);
    }

    @Override
    public int feedAll() {
        int fedChickens = 0;
        for (Animal animal : chickens) {
            if(animal.isHungry()){
                if (farm.modStorage(animal.feed, -1)) {
                    System.out.println(animal.feed());
                    fedChickens += 1;
                } else {
                    System.out.println("Not enough food available");
                    break;
                }
            } else {
                System.out.println(animal.getName()+" isn't hungry. You can't feed them right now.");
            }
        }
        return fedChickens;
    }

    @Override
    public List<Animal> getAnimals() {
        return chickens;
    }

    @Override
    public int getAnimalNum() {
        return chickens.size();
    }

    public String getName(){
        return "chicken stable";
    }

}
