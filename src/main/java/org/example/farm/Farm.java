package org.example.farm;

import org.example.Feed;
import org.example.animal.*;

import java.util.Arrays;
import java.util.HashMap;

//Class that contains a Farm Name and a list of Animals
//It also has an account
public class Farm {
    public Farm(String name, Animal[] animals) {
        this.name = name;
        this.animals = animals;
        synchStorage();
        sortAnimals();
    }

    public final String name;
    private Animal[] animals;
    private Stable[] stables;
    private int money = 100;

    private HashMap<Feed, Integer> feedStock = new HashMap<>();

    //method that adds all feeds to storage
    private void synchStorage() {
        int i;
        Feed feed;
        for (i = 0; i < animals.length; i++) {
            feed = animals[i].feedType;
            if (!feedStock.containsKey(feed)) {
                feedStock.put(feed, 3);
            }
        }
    }

    //method that sorts the Farm animals into Stables
    private void sortAnimals() {
        Animal[] wildAnimals = new Animal[animals.length];
        for (int i = 0; i < animals.length; i++) {
            Animal animal = animals[i];
            if (animal instanceof WildAnimal) {
                wildAnimals[i] = animal;
            } else if (animal instanceof Chicken) {

            } else if (animal.getClass().equals(Cow.class)) {

            } else if (animal.getClass().equals(Dog.class)) {

            } else if (animal.getClass().equals(Pig.class)) {

            } else {
                throw new UnsupportedOperationException("*Somebody* needs to add an animal to sorting.");
            }
        }
    }

    //method to check whether a Stable exixsts

    private boolean hasStable(Stable)

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
        animals = Arrays.copyOf(animals, animals.length + 1);
        animals[animals.length - 1] = animal;
        synchStorage();
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

    public Animal[] getAnimals() {
        return animals.clone();
    }

    private void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

}
