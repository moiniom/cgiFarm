package org.example;

import org.example.animal.*;
import org.example.farm.Farm;
import org.example.farm.Stable;

import java.util.ArrayList;
import java.util.List;

public class FarmUI {
    public FarmUI(List<Farm> farms) {
        this.farms = farms;
        welcome();
        mainMenu();
    }

    List<Farm> farms;

    //Welcome Message
    private void welcome() {
        print("Hello");
        print("This is the Farm interface :-)");
    }

    //Menu letting the user choose to which Farm to go or to create a new Farm
    private void mainMenu() {
        while (true) {
            print("Main Menu");
            print("There are three Farms:");
            int farmNumber = farms.size();
            for(int i = 0; i < farmNumber; i++) {
                print(" " + (i + 1) + " > " + farms.get(i).name);
            }
            print(" 0 > Exit");
            print("-1 > Add new Farm");
            int input = Input.choice(-1, farmNumber);
            if (input == 0) {
                return;
            }
            if (input == -1) {
                addFarm();
            } else {
                farmInteraction(farms.get(input-1));
            }
        }
    }

    //Menu letting the user chose with which animal on the Farm they want to Interact with
    private void farmInteraction(Farm farm) {
        while (true) {
            print(farm.name);
            print("They have " + farm.getMoney() + " EuroDollars");
            int animalNumber = farm.getNonStableAnimals().size();
            for(Stable stable : farm.getStables()) {
                animalNumber += stable.getAnimalNum();
            }
            print("There live " + animalNumber + " Animals here:");
            int displOptions = 0;
            String ref;
            while (displOptions < farm.getStables().size()) {
                ref = "Go to " + farm.getStables().get(displOptions).getName();
                print(" " + (displOptions +1) + " > " + ref);
                displOptions += 1;
            }
            while (displOptions < farm.getStables().size()+farm.getNonStableAnimals().size()) {
                if (farm.getNonStableAnimals().get(displOptions-farm.getStables().size()) instanceof FarmAnimal) {
                    ref = farm.getNonStableAnimals().get(displOptions-farm.getStables().size()).getName();
                } else {
                    ref = "Go to " + farm.getNonStableAnimals().get(displOptions-farm.getStables().size()).getReference();
                }
                print(" " + (displOptions + 1) + " > " + ref);
                displOptions += 1;
            }
            print(" 0 > Exit");
            print("-1 > Add new Animal");
            print("-2 > Add Money");
            print("-3 > View feed storage/buy feed");
            int input = Input.choice(-3, displOptions);
            switch (input) {
                case 0: {
                    return;
                }
                case -1: {
                    addAnimal(farm);
                    break;
                }
                case -2: {
                    print(addMoney(farm));
                    break;
                }
                case -3: {
                    storageMenu(farm);
                    break;
                }
                default: {
                    if(input > farm.getStables().size()) {
                        animalInteraction(farm.getNonStableAnimals().get(input - 1 -farm.getStables().size()), farm);
                    } else {
                        stableInteraction(farm.getStables().get(input - 1), farm);
                    }
                    break;
                }
            }
        }
    }

    //Menu letting the user interact with the Stable
    private void stableInteraction(Stable stable, Farm farm) {
        while (true) {
            print(stable.getName());
            print("There are " + stable.getAnimalNum() + " Animals in this Stable:");
            int displOptions = 0;
            String ref;
            while (displOptions < stable.getAnimalNum()) {
                if(stable.getAnimals().get(displOptions) instanceof FarmAnimal) {
                    ref = stable.getAnimals().get(displOptions).getName();
                } else {
                    ref = stable.getAnimals().get(displOptions).getReference();
                }
                print(" " + (displOptions + 1) + " > " + ref);
                displOptions += 1;
            }
            print(" 0 > Exit");
            print("-1 > Feed all");
            int input = Input.choice(-1, displOptions);
            switch (input) {
                case 0: {
                    return;
                } case -1: {
                    int fed = stable.feedAll();
                    print(fed + " out of " + stable.getAnimalNum() + " animals were fed.");
                    break;
                } default: {
                    animalInteraction(stable.getAnimals().get(input - 1), farm);
                }
            }
        }
    }

    //Menu letting the user inter act with the animals
    private void animalInteraction(Animal animal, Farm farm) {
        String ref;
        if (animal.getName().isEmpty()) {
            ref = "the " + animal.getReference();
        } else {
            ref = animal.getName();
        }
        while (true) {
            print(ref);
            print("What do you want ot do?");
            print(" 1 > Listen to " + ref);
            print(" 2 > Interact with " + ref);
            print(" 3 > Feed " + ref + " with " + Feed.getName(animal.feed) + "(" + farm.getFeedAmount(animal.feed) + " in Stock)");
            print(" 4 > Get Info on " + ref);
            print(" 0 > Exit");
            switch (Input.choice(0, 4)) {
                case 0:
                    return;
                case 1:
                    print(animal.doSound());
                    break;
                case 2:
                    print(animal.doAction());
                    break;
                case 3:
                    print(feedAnimal(animal, farm));
                    break;
                case 4: {
                    List<String> info = animal.getInfo();
                    String out = info.get(0) + "\nName: " + info.get(1) + "\nAge: " + info.get(2) + "\nWeight: " + info.get(3) + "\nIs hungry: " + info.get(4);
                    print(out);
                }
            }
        }
    }

    //menu to buy feed
    private void storageMenu(Farm farm) {
        List<Feed.type> feeds = farm.getFeeds();
        while (true) {
            print("Storage");
            for (int i = 0; i < feeds.size(); i++) {
                print(" " + (i + 1) + " > Buy " + Feed.getName(feeds.get(i)) + " for " + Feed.getPrice(feeds.get(i)) + " EUD (" + farm.getFeedAmount(feeds.get(i)) + " remaining)");
            }
            print(" 0 > Exit");
            int input = Input.choice(0, feeds.size());
            if (input == 0) {
                return;
            }
            if (farm.buyFeed(feeds.get(input-1))) {
                print("bought");
            } else {
                print("Not enough money");
            }
        }
    }

    //method to feed animal
    private String feedAnimal(Animal animal, Farm farm) {
        if (farm.modStorage(animal.feed, -1)) {
            return animal.feed();
        } else {
            return "Not enough feed";
        }
    }

    //method to add money
    private String addMoney(Farm farm) {
        print("Enter amount:");
        int amount = Input.anInt();
        if (farm.modMoney(amount)) {
            return "Successfully added " + amount + " EUD to account";
        } else {
            return "Not enough money";
        }
    }

    //method to create a Farm
    private void addFarm() {
        print("Enter name:");
        String name = Input.aStr();
        farms.add(new Farm(name, new ArrayList<>()));
    }

    //Method to create a new animal
    private void addAnimal(Farm farm) {
        print("Select Animal:");
        print(" 1 > Chicken (Farm animal)");
        print(" 2 > Cow (Farm animal)");
        print(" 3 > Dog (Farm animal)");
        print(" 4 > Pig (Farm animal)");
        print(" 5 > Kangaroo (Wild animal)");
        int clsSel = Input.choice(1, 5);
        print("Enter name if necessary:");
        String name = Input.aStr();
        print("Enter age:");
        int age = Input.anInt();
        print("Enter Weight:");
        int weight = Input.anInt();
        Animal newAnimalObj;
        switch (clsSel) {
            case 1:
                newAnimalObj = new Chicken(name, age, weight);
                break;
            case 2:
                newAnimalObj = new Cow(name, age, weight);
                break;
            case 3:
                newAnimalObj = new Dog(name, age, weight);
                break;
            case 4:
                newAnimalObj = new Pig(name, age, weight);
                break;
            case 5:
                newAnimalObj = new Kangaroo(age, weight);
                break;
            default:
                print("failed");
                return;
        }
        farm.addAnimal(newAnimalObj);
    }

    private void print(String str) {
        System.out.println(str);
    }
}
