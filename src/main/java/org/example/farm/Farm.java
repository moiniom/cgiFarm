package org.example.farm;

import org.example.Feed;
import org.example.animal.Animal;

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
        for (i = 0; i < animalList.length; i++) {
            feed = animalList[i].feedType;
            if (!feedStock.containsKey(feed)) {
                feedStock.put(feed, 3);
            }
        }
    }

    //method to get the stored amount of a feed
    public int getFeedAmount(Feed feed) {
        return feedStock.get(feed);
    }

    //method to get feeds in storage
    public Feed[] getFeeds() {
        return feedStock.keySet().toArray(Feed[]::new);
    }

    //method to change the amount of a feed in Storage
    public boolean modStorage(Feed feed, int amount) {
        if (feedStock.get(feed) + amount < 0) {
            return false;
        }
        feedStock.replace(feed, feedStock.get(feed) + amount);
        return true;
    }

    //method that adds Animal objects to the animalList
    public void addAnimal(Animal animal) {
        setAnimalList(
                Arrays.copyOf(
                        getAnimalList(),
                        getAnimalList().length + 1
                )
        );
        getAnimalList()[getAnimalList().length - 1] = animal;
    }

    public int getMoney() {
        return money;
    }

    public boolean modMoney(int change) {
        if (money + change < 0) {
            return false;
        }
        money += change;
        return true;
    }

    public Animal[] getAnimalList() {
        return animalList.clone();
    }

    private void setAnimalList(Animal[] animalList) {
        this.animalList = animalList;
    }

}
