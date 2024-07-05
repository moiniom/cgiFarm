package org.example.farm;

import org.example.animal.Animal;
import org.example.animal.FarmAnimal;
import org.example.animal.Pig;

import java.util.Arrays;

public class PigStable implements Stable{

    public PigStable(Pig[] pigs, Farm farm) {
        this.pigs = pigs;
        this.farm = farm;
    }

    private Pig[] pigs;
    private final Farm farm;

    @Override
    public void addAnimal(Animal animal) {
        if(!(animal instanceof Pig)) {
            throw new IllegalArgumentException("Tried adding non Pig to PigStable");
        }
        pigs = Arrays.copyOf(pigs, pigs.length+1);
        pigs[pigs.length-1] = (Pig) animal;
    }

    @Override
    public int feedAll() {
        int fedPigs = 0;
        for (Pig pig : pigs) {
            if (farm.modStorage(pig.feedType, -1)) {
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
    public FarmAnimal[] getAnimals() {
        return pigs;
    }

    @Override
    public int getAnimalNum() {
        return pigs.length;
    }
}
