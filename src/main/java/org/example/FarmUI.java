package org.example;

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
                print(" "+(displFarms+1)+" > "+farms[displFarms].name);
                displFarms += 1;
            }
            print(" 0 > Exit");
            print("-1 > Add new Farm");
            int input = Input.choice(-1, farmNumber);
            if(input == 0) {return;}
            if(input == -1) {addFarm();}
            else {farmInteraction(farms[input-1]);}
        }
    }

    //Menu letting the user chose with which animal on the Farm they want to Interact with
    private void farmInteraction(Farm farm) {
        while (true) {
            print(farm.name);
            print("Tey have "+farm.getMoney()+" EuroDollars");
            int animalNumber = farm.getAnimalList().length;
            print("There live "+animalNumber+" Animals here:");
            int displAnimals = 0;
            while (displAnimals < animalNumber) {
                String ref;
                if(farm.getAnimalList()[displAnimals] instanceof FarmAnimal) {
                    ref = farm.getAnimalList()[displAnimals].getName();
                } else {
                    ref = "A "+ farm.getAnimalList()[displAnimals].getReference();
                }
                print(" "+(displAnimals+1)+" > "+ref);
                displAnimals += 1;
            }
            print(" 0 > Exit");
            print("-1 > Add new Animal");
            print("-2 > Add Money");
            int input = Input.choice(-2, animalNumber);
            if(input == 0) {return;}
            if(input == -1) {addAnimal(farm);}
            if(input == -2) {print(addMoney(farm));}
            else {animalInteraction(farm.getAnimalList()[input - 1], farm);}
        }
    }

    //Menu letting the user inter act with the animals
    private void animalInteraction(Animal animal, Farm farm) {
        String ref;
        if(animal.getName().isEmpty()) {ref = "the "+animal.getReference();}
        else {ref = animal.getName();}
        while (true) {
            print(ref);
            print("What do you want ot do?");
            print(" 1 > Listen to "+ref);
            print(" 2 > Interact with "+ref);
            print(" 3 > Feed "+ref+" with "+animal.feedType.name+"("+animal.feedType.price+" EUD)");
            print(" 4 > Get Info on "+ref);
            print(" 0 > Exit");
            switch (Input.choice(0,4)) {
                case 0: return;
                case 1: print(animal.doSound()); break;
                case 2: print(animal.doAction()); break;
                case 3: print(feedAnimal(animal, farm)); break;
                case 4: {
                    String[] info = animal.getInfo();
                    String out = info[0]+"\nName: "+info[1]+"\nAge: "+info[2]+"\nWeight: "+info[3]+"\nIs hungry: "+info[4];
                    print(out);
                }
            }
        }
    }

    //method to feed animal
    private String feedAnimal(Animal animal, Farm farm) {
        if(farm.modMoney(-animal.feedType.price)) {
            return animal.feed();
        } else {
            return "Not enough money";
        }
    }

    //method to add money
    private String addMoney(Farm farm) {
        print("Enter amount:");
        int amount = Input.anInt();
        if(farm.modMoney(amount)) {
            return "Successfully added "+amount+" EUD to account";
        } else {
            return "Not enough money";
        }
    }

    //method to create a Farm
    private void addFarm() {
        print("Enter name:");
        String name = Input.aStr();
        farms = Arrays.copyOf(farms, farms.length+1);
        farms[farms.length-1] = new Farm(name, new Animal[] {});
    }

    //Method to create a new animal
    private void addAnimal(Farm farm) {
        print("Select Animal:");
        print(" 1 > Chicken (Farm animal)");
        print(" 2 > Cow (Farm animal)");
        print(" 3 > Dog (Farm animal)");
        print(" 4 > Pig (Farm animal)");
        print(" 5 > Kangaroo (Wild animal)");
        int clsSel = Input.choice(1,5);
        print("Enter name if necessary:");
        String name = Input.aStr();
        print("Enter age:");
        int age = Input.anInt();
        print("Enter Weight:");
        int weight = Input.anInt();
        Animal newAnimalObj;
        switch (clsSel) {
            case 1: newAnimalObj = new Chicken(name, age, weight); break;
            case 2: newAnimalObj = new Cow(name, age, weight); break;
            case 3: newAnimalObj = new Dog(name, age, weight); break;
            case 4: newAnimalObj = new Pig(name, age, weight); break;
            case 5: newAnimalObj = new Kangaroo(age, weight); break;
            default: print("failed"); return;
        }
        farm.setAnimalList(Arrays.copyOf(farm.getAnimalList(), farm.getAnimalList().length + 1));
        farm.getAnimalList()[farm.getAnimalList().length-1] = newAnimalObj;
    }

    private void print(String str) {
        System.out.println(str);
    }
}
