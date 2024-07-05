package org.example;

import org.example.animal.*;
import org.example.farm.Farm;

public class Main {
    public static void main(String[] args) {
        //Creates 2 farms
        Farm billies = new Farm(
                "Billies Farm",
                new Animal[]{
                        new Cow("Meggy", 10, 150),
                        new Chicken("Berry", 2, 2),
                        new Kangaroo(20, 100)
                }
        );
        Farm mollies = new Farm(
                "Mollies Farm",
                new Animal[]{
                        new Dog("Jack", 8, 30),
                        new Pig("Jules", 10, 180)
                }
        );
        //Creates an Array of said farms
        Farm[] farms = new Farm[]{billies, mollies};
        //Starts the UI and points it towards the Array
        FarmUI ui = new FarmUI(farms);
    }
}