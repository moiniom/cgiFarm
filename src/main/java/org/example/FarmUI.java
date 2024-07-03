package org.example;

public class FarmUI {
    public FarmUI(Farm[] farms) {
        this.farms = farms;
        init();
        mainMenu();
    }

    Farm[] farms;

    private void init() {
        print("Hello");
        print("This is the Farm interface :-)");
    }

    private void mainMenu() {
        int farmNumber = farms.length;
        while (true) {
            print("Main Menu");
            print("There are three Farms:");
            int displFarms = 0;
            while (displFarms < farmNumber) {
                print(" "+(displFarms+1)+" > "+farms[displFarms].name);
                displFarms += 1;
            }
            print(" 0 > Exit");
            int input = Input.choice(0, farmNumber);
            if(input == 0) {return;}
            farmInteraction(farms[input-1]);
        }
    }

    private void farmInteraction(Farm farm) {
        int animalNumber = farm.animalList.length;
        while (true) {
            print(farm.name);
            print("There live "+animalNumber+" Animals here:");
            int displAnimals = 0;
            while (displAnimals < animalNumber) {
                String ref;
                if(farm.animalList[displAnimals] instanceof FarmAnimal) {
                    ref = farm.animalList[displAnimals].name;
                } else {
                    ref = "A "+farm.animalList[displAnimals].reference;
                }
                print(" "+(displAnimals+1)+" > "+ref);
                displAnimals += 1;
            }
            print(" 0 > Exit");
            int input = Input.choice(0, animalNumber);
            if(input == 0) {return;}
            animalInteraction(farm.animalList[input-1]);
        }
    }

    private void animalInteraction(Animal animal) {
        String ref;
        if(animal.name.isEmpty()) {ref = "the "+animal.reference;}
        else {ref = animal.name;}
        while (true) {
            print(ref);
            print("What do you want ot do?");
            print(" 1 > Listen to " + ref);
            print(" 2 > Interact with " + ref);
            print(" 3 > Feed " + ref);
            print(" 4 > Get Info on " + ref);
            print(" 0 > Exit");
            switch (Input.choice(0,4)) {
                case 0: return;
                case 1: print(animal.doSound()); break;
                case 2: print(animal.doAction()); break;
                case 3: print(animal.feed()); break;
                case 4: {
                    String[] info = animal.getInfo();
                    String out = info[0]+"\nName: "+info[1]+"\nAge: "+info[2]+"\nWeight: "+info[3]+"\nIs hungry: "+info[4];
                    print(out);
                }
            }
        }
    }

    private void addFarm() {

    }

    private void addAnimal() {

    }

    private void print(String str) {
        System.out.println(str);
    }
}
