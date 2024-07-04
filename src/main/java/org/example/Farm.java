package org.example;

//Class that contains a Farm Name and a list of Animals
//It also has an account
public class Farm {
    public Farm(String name, Animal[] animalList) {
        this.name = name;
        this.animalList = animalList;
    }
    public final String name;
    private Animal[] animalList;
    private int money = 100;

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
