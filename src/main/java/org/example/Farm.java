package org.example;

//Class that contains a Farm Name and a list of Animals
public class Farm {
    public Farm(String name, Animal[] animalList) {
        this.name = name;
        this.animalList = animalList;
    }
    public String name;
    public Animal[] animalList;
}
