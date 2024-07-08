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
        for (Animal animal : pigs) {
            if(animal.isHungry()){
                if (farm.modStorage(animal.feed, -1)) {
                    System.out.println(animal.feed());
                    fedPigs += 1;
                } else {
                    System.out.println("Not enough food available");
                    break;
                }
            } else {
                System.out.println(animal.getName()+" isn't hungry. You can't feed them right now.");
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
