package org.example.farm;

import org.example.animal.Animal;
import org.example.animal.Chicken;
import org.example.animal.FarmAnimal;

import java.util.Arrays;

public class ChickenStable implements Stable {

    public ChickenStable(Chicken[] chickens, Farm farm) {
        this.chickens = chickens;
        this.farm = farm;
    }

    private Chicken[] chickens;
    private final Farm farm;

    @Override
    public void addAnimal(Animal animal) {
        if(!(animal instanceof Chicken)) {
            throw new IllegalArgumentException("Tried adding non Pig to PigStable");
        }
        chickens = Arrays.copyOf(chickens, chickens.length+1);
        chickens[chickens.length-1] = (Chicken) animal;
    }

    @Override
    public int feedAll() {
        int fedChickens = 0;
        for (Chicken chicken : chickens) {
            if (farm.modStorage(chicken.feedType, -1)) {
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
    public FarmAnimal[] getAnimals() {
        return chickens;
    }

    @Override
    public int getAnimalNum() {
        return chickens.length;
    }

}
