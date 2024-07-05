package org.example;

import org.example.animal.*;
import org.example.farm.Farm;

import java.util.Arrays;

public class FarmUI {
    public FarmUI(Farm[] farms) {
        this.farms = farms;
        welcome();
        mainMenu();
    }

    Farm[] farms;

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
            int farmNumber = farms.length;
            int displFarms = 0;
            while (displFarms < farmNumber) {
                print(" " + (displFarms + 1) + " > " + farms[displFarms].name);
                displFarms += 1;
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
                farmInteraction(farms[input - 1]);
            }
        }
    }

    //Menu letting the user chose with which animal on the Farm they want to Interact with
    private void farmInteraction(Farm farm) {
        while (true) {
            print(farm.name);
            print("They have " + farm.getMoney() + " EuroDollars");
            int animalNumber = farm.getAnimals().length;
            print("There live " + animalNumber + " Animals here:");
            int displAnimals = 0;
            while (displAnimals < animalNumber) {
                String ref;
                if (farm.getAnimals()[displAnimals] instanceof FarmAnimal) {
                    ref = farm.getAnimals()[displAnimals].getName();
                } else {
                    ref = "A " + farm.getAnimals()[displAnimals].getReference();
                }
                print(" " + (displAnimals + 1) + " > " + ref);
                displAnimals += 1;
            }
            print(" 0 > Exit");
            print("-1 > Add new Animal");
            print("-2 > Add Money");
            print("-3 > View feed storage/buy feed");
            int input = Input.choice(-3, animalNumber);
            switch (input) {
                case 0: {
                    return;
                }
                case -1: {
                    addAnimal(farm);
                }
                case -2: {
                    print(addMoney(farm));
                }
                case -3: {
                    storageMenu(farm);
                }
                default: {
                    animalInteraction(farm.getAnimals()[input - 1], farm);
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
            print(" 3 > Feed " + ref + " with " + animal.feedType.name + "(" + farm.getFeedAmount(animal.feedType) + " ins Stock)");
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
                    String[] info = animal.getInfo();
                    String out = info[0] + "\nName: " + info[1] + "\nAge: " + info[2] + "\nWeight: " + info[3] + "\nIs hungry: " + info[4];
                    print(out);
                }
            }
        }
    }

    //menu to buy feed
    private void storageMenu(Farm farm) {
        Feed[] feeds = farm.getFeeds();
        while (true) {
            print("Storage");
            int i;
            for (i = 0; i < feeds.length; i++) {
                print(" " + (i + 1) + " > Buy " + feeds[i].name + " for " + feeds[i].price + " EUD (" + farm.getFeedAmount(feeds[i]) + " remaining)");
            }
            print(" 0 > Exit");
            int input = Input.choice(0, feeds.length);
            if (input == 0) {
                return;
            }
            if (farm.modMoney(-feeds[input - 1].price)) {
                farm.modStorage(feeds[input - 1], 1);
            } else {
                print("Not enough money");
            }
        }
    }

    //method to feed animal
    private String feedAnimal(Animal animal, Farm farm) {
        if (farm.modStorage(animal.feedType, -1)) {
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
        farms = Arrays.copyOf(farms, farms.length + 1);
        farms[farms.length - 1] = new Farm(name, new Animal[]{});
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
