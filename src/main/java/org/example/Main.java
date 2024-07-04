package org.example;

public class Main {
    public static void main(String[] args) {
        Farm billies = new Farm(
                "Billies Farm",
                new Animal[] {
                        new Cow("Meggy", 10, 150),
                        new Chicken("Berry", 2, 2),
                        new Kangaroo(20, 100)
                }
        );
        Farm mollys = new Farm(
                "Mollys Farm",
                new Animal[] {
                        new Dog("Jack", 8, 30),
                        new Pig("Jules", 10, 180)
                }
        );
        Farm[] farms = new Farm[] {billies, mollys};
        FarmUI ui = new FarmUI(farms);
    }
}