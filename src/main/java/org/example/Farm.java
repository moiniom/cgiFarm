package org.example;

import java.util.Arrays;
import java.util.HashMap;

//Class that contains a Farm Name and a list of Animals
//It also has an account
public class Farm {
    public Farm(String name, Animal[] animalList) {
        this.name = name;
        this.animalList = animalList;
        synchStorage();
    }
    public final String name;
    private Animal[] animalList;
    private int money = 100;

    private HashMap<Feed, Integer> feedStock = new HashMap<>();

    //method that adds all feeds to storage
    public void synchStorage() {
        int i;
        Feed feed;
        for (i=0; i<animalList.length; i++) {
            feed = animalList[i].feedType;
            if(!feedStock.containsKey(feed)) {
                feedStock.put(feed, 3);
            }
        }
    }

    //method that adds Animal objects to the animalList
    public void addAnimal(Animal animal) {
        setAnimalList(Arrays.copyOf(getAnimalList(), getAnimalList().length + 1));
        getAnimalList()[getAnimalList().length-1] = animal;
    }

    public int getMoney() {
        return money;
    }

    public boolean modMoney(int change) {
        if(money + change < 0) {
            return false;
        }
        money += change;
        return true;
    }

    public Animal[] getAnimalList() {
        return animalList;
    }

    public void setAnimalList(Animal[] animalList) {
        this.animalList = animalList;
    }

}
