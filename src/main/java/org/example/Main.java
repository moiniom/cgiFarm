package org.example;

import org.example.animal.*;
import org.example.farm.Farm;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Creates 2 farms
        List<Animal> billiesAnimals = new ArrayList<>();
        billiesAnimals.add(new Cow("Meggy", 10, 150));
        billiesAnimals.add(new Chicken("Berry", 2, 2));
        billiesAnimals.add(new Kangaroo(20, 100));
        Farm billies = new Farm(
                "Billies Farm",
                billiesAnimals
        );

        List<Animal> molliesAnimals = new ArrayList<>();
        molliesAnimals.add(new Dog("Jack", 8, 30));
        molliesAnimals.add(new Pig("Jules", 10, 180));
        Farm mollies = new Farm(
                "Mollies Farm",
                molliesAnimals
        );

        //Creates a List of said farms
        List<Farm> farms = new ArrayList<>();
        farms.add(billies);
        farms.add(mollies);
        //Starts the UI and points it towards the List
        FarmUI ui = new FarmUI(farms);
    }
}