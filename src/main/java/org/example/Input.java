package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
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

    public static String str() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
