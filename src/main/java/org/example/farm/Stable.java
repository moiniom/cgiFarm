package org.example.farm;

import org.example.animal.Animal;

import java.util.List;

public interface Stable {
    //method to add the animals
    void addAnimal(Animal animal);
    //method for feeding all animals in the Stable returns number of fed animals
    int feedAll();
    //method returning Array of all animals in the stable
    List<Animal> getAnimals();
    //method returning the number of animals in the Stable
    int getAnimalNum();
    //reference of Stable
    String getName();
}
