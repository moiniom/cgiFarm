package org.example.farm;

import org.example.Feed;
import org.example.animal.*;

import java.util.*;

//Class that contains a Farm Name and a list of Animals
//It also has an account
public class Farm {
    public Farm(String name, List<Animal> animals) {
        this.name = name;
        this.animals = animals;
        synchStorage();
        //sortAnimals();
    }

    public final String name;
    private List<Animal> animals;
    private List<Stable> stables;
    private int money = 100;

    private HashMap<Feed.type, Integer> feedStock = new HashMap<>();

    //method that adds all feeds to storage
    private void synchStorage() {
        for(Animal animal : animals) {
            Feed.type feed = animal.feed;
            if (!feedStock.containsKey(feed)) {
                feedStock.put(feed, 3);
            }
        }
    }

    //method that sorts the Farm animals into Stables
//    private void sortAnimals() {
//        Animal[] wildAnimals = new Animal[animals.length];
//        for (int i = 0; i < animals.length; i++) {
//            Animal animal = animals[i];
//            if (animal instanceof WildAnimal) {
//                wildAnimals[i] = animal;
//            } else if (animal instanceof Chicken) {
//
//            } else if (animal.getClass().equals(Cow.class)) {
//
//            } else if (animal.getClass().equals(Dog.class)) {
//
//            } else if (animal.getClass().equals(Pig.class)) {
//
//            } else {
//                throw new UnsupportedOperationException("*Somebody* needs to add an animal to sorting.");
//            }
//        }
//    }

    //method to change the amount of a feed in Storage
    public boolean modStorage(Feed.type feed, int amount) {
        if (feedStock.get(feed) + amount < 0) {
            return false;
        }
        feedStock.replace(feed, feedStock.get(feed) + amount);
        return true;
    }

    public boolean buyFeed(Feed.type feed) {
        if(modMoney(Feed.getPrice(feed))) {
            modStorage(feed, 1);
            return true;
        } else {
            return false;
        }
    }

    //method that adds Animal objects to the animalList
    public void addAnimal(Animal animal) {
        animals.add(animal);
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
    //method to get the stored amount of a feed
    public int getFeedAmount(Feed.type feed) {
        return feedStock.get(feed);
    }

    //method to get feeds in storage
    public List<Feed.type> getFeeds() {
        return feedStock.keySet().stream().toList();
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Stable> getStables() {
        return stables;
    }
}
