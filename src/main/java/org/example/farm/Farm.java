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
        sortAnimals();
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
    private void sortAnimals() {
        List<Animal> nonStableAnimals = new ArrayList<>();
        Stable stable;
        for(Animal animal : animals){
            if(animal instanceof FarmAnimal) {
                stable = getApprStable(animal);
                stable.addAnimal(animal);
            } else {
                nonStableAnimals.add(animal);
            }
        }
        animals = nonStableAnimals;
    }

    //This returns the appropriate Stable for an Animal. If the farm doesn't have an appropriate stable one gets created
    public Stable getApprStable(Animal animal) {
        enum stableType {
            CHICKEN,
            COW,
            DOG,
            PIG,
        }
        List<stableType> available = new ArrayList<>();
        stableType required;
        Stable returnStable;
        for(Stable stable : stables){
            if(stable instanceof ChickenStable) {
                available.add(stableType.CHICKEN);
            } else if (stable instanceof CowStable) {
                available.add(stableType.COW);
            } else if (stable instanceof DogStable) {
                available.add(stableType.DOG);
            } else if (stable instanceof PigStable) {
                available.add(stableType.PIG);
            } else {
                throw new UnsupportedOperationException("Given Animal not implemented");
            }
        }
        if(animal instanceof Chicken) {
            required = stableType.CHICKEN;
        } else if (animal instanceof Cow) {
            required = stableType.COW;
        } else if (animal instanceof Dog) {
            required = stableType.DOG;
        } else if (animal instanceof Pig) {
            required = stableType.PIG;
        } else {
            throw new UnsupportedOperationException("Given Animal not implemented");
        }
        if(!available.contains(required)) {
            if(required == stableType.CHICKEN) {
                returnStable = new ChickenStable(this);
            } else if (required == stableType.COW) {
                returnStable = new CowStable(this);
            } else if (required == stableType.DOG) {
                returnStable = new DogStable(this);
            } else if (required == stableType.PIG) {
                returnStable = new PigStable(this);
            } else {
                throw new UnsupportedOperationException("Given Animal not implemented");
            }
            stables.add(returnStable);
        } else {
            returnStable = stables.get(available.indexOf(required));
        }
        return returnStable;
    }

    //method to change the amount of a feed in Storage
    public boolean modStorage(Feed.type feed, int amount) {
        if (feedStock.get(feed) + amount < 0) {
            return false;
        }
        feedStock.replace(feed, feedStock.get(feed) + amount);
        return true;
    }

    //Buys Feed adding one of the given Feed to Storage and subtracting the given price from the account
    public boolean buyFeed(Feed.type feed) {
        if(modMoney(-Feed.getPrice(feed))) {
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
