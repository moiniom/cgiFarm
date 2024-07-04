package org.example;

//Class that contains a Farm Name and a list of Animals
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

    public String modMoney(int change) {
        if(money + change < 0) {
            return "Not enough money";
        }
        money += change;
        return "Money changed to "+money+" EUD";
    }

    public Animal[] getAnimalList() {
        return animalList;
    }

    public void setAnimalList(Animal[] animalList) {
        this.animalList = animalList;
    }

}
