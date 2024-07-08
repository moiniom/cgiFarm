package org.example.farm;

import org.example.animal.Animal;
import org.example.animal.Pig;

import java.util.ArrayList;
import java.util.List;

public class PigStable implements Stable{

    public PigStable(Farm farm) {
        this.farm = farm;
    }

    private final List<Animal> pigs = new ArrayList<>();
    private final Farm farm;

    @Override
    public void addAnimal(Animal animal) {
        if(!(animal instanceof Pig)) {
            throw new IllegalArgumentException("Tried adding non Pig to PigStable");
        }
        pigs.add(animal);
    }

    @Override
    public int feedAll() {
        int fedPigs = 0;
        for (Animal pig : pigs) {
            if (farm.modStorage(pig.feed, -1)) {
                System.out.println(pig.feed());
                fedPigs += 1;
            } else {
                System.out.println("Not enough food available");
                break;
            }
        }
        return fedPigs;
    }

    @Override
    public List<Animal> getAnimals() {
        return pigs;
    }

    @Override
    public int getAnimalNum() {
        return pigs.size();
    }

    public String getName(){
        return "pig stable";
    }
}
