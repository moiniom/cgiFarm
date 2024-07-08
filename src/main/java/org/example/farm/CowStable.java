package org.example.farm;

import org.example.animal.Animal;
import org.example.animal.Cow;
import org.example.animal.Pig;

import java.util.ArrayList;
import java.util.List;

public class CowStable implements Stable{
    public CowStable(Farm farm) {
        this.farm = farm;
    }

    private List<Animal> cows = new ArrayList<>();
    private final Farm farm;

    @Override
    public void addAnimal(Animal animal) {
        if(!(animal instanceof Cow)) {
            throw new IllegalArgumentException("Tried adding non Cow to PigStable");
        }
        cows.add(animal);
    }

    @Override
    public int feedAll() {
        int fedCows = 0;
        for (Animal pig : cows) {
            if (farm.modStorage(pig.feed, -1)) {
                System.out.println(pig.feed());
                fedCows += 1;
            } else {
                System.out.println("Not enough food available");
                break;
            }
        }
        return fedCows;
    }

    @Override
    public List<Animal> getAnimals() {
        return cows;
    }

    @Override
    public int getAnimalNum() {
        return cows.size();
    }

    public String getName(){
        return "cow stable";
    }
}
