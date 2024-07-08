package org.example.farm;

import org.example.animal.Animal;
import org.example.animal.Dog;

import java.util.ArrayList;
import java.util.List;

public class DogStable implements Stable{
    public DogStable(Farm farm) {
        this.farm = farm;
    }

    private List<Animal> dogs = new ArrayList<>();
    private final Farm farm;

    @Override
    public void addAnimal(Animal animal) {
        if(!(animal instanceof Dog)) {
            throw new IllegalArgumentException("Tried adding non Dog to DogStable");
        }
        dogs.add(animal);
    }

    @Override
    public int feedAll() {
        int fedDogs = 0;
        for (Animal animal : dogs) {
            if(animal.isHungry()){
                if (farm.modStorage(animal.feed, -1)) {
                    System.out.println(animal.feed());
                    fedDogs += 1;
                } else {
                    System.out.println("Not enough food available");
                    break;
                }
            } else {
                System.out.println(animal.getName()+" isn't hungry. You can't feed them right now.");
            }
        }
        return fedDogs;
    }

    @Override
    public List<Animal> getAnimals() {
        return dogs;
    }

    @Override
    public int getAnimalNum() {
        return dogs.size();
    }

    public String getName(){
        return "dog stable";
    }
}
