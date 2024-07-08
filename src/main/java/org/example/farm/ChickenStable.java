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
        for (Animal chicken : chickens) {
            if (farm.modStorage(chicken.feed, -1)) {
                System.out.println(chicken.feed());
                fedChickens += 1;
            } else {
                System.out.println("Not enough food available");
                break;
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
