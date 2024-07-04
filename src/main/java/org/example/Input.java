package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    //method to take an int input only between given values
    public static int choice(int lower, int upper) {
        Scanner scan = new Scanner(System.in);
        int input;
        while (true) {
            try {
                input = scan.nextInt();
                if(input>=lower && input <=upper) {
                    break;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid Input");
                scan.nextLine();
            }
        }
        return input;
    }

    //method to take any int input
    public static int anInt() {
        Scanner scan = new Scanner(System.in);
        int input;
        while (true) {
            try {
                input = scan.nextInt();
                break;
            } catch (InputMismatchException exception) {
                System.out.println("Invalid Input");
                scan.nextLine();
            }
        }
        return input;
    }

    //method to take any str input
    public static String aStr() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
