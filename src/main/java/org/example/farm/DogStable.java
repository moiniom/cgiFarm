package org.example.farm;

import org.example.animal.Animal;
import org.example.animal.Dog;

import java.util.List;

public class DogStable implements Stable{
    public DogStable(List<Animal> dogs, Farm farm) {
        for(Animal animal : dogs) {
            if(!(animal instanceof Dog)){
                throw new IllegalArgumentException("There can only be place for dogs in a dog stable.");
            }
        }
        this.dogs = dogs;
        this.farm = farm;
    }

    private List<Animal> dogs;
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
        for (Animal dog : dogs) {
            if (farm.modStorage(dog.feed, -1)) {
                System.out.println(dog.feed());
                fedDogs += 1;
            } else {
                System.out.println("Not enough food available");
                break;
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
}
