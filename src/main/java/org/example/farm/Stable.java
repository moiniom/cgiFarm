package org.example.farm;

import org.example.animal.Animal;
import org.example.animal.FarmAnimal;

public interface Stable {
    //method to add the animals
    void addAnimal(Animal animal);
    //method for feeding all animals in the Stable returns number of fed animals
    int feedAll();
    //method returning Array of all animals in the stable
    FarmAnimal[] getAnimals();
    //method returning the number of animals in the Stable
    int getAnimalNum();
}
