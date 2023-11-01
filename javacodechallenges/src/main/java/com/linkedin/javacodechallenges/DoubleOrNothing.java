package com.linkedin.javacodechallenges;

import java.util.Random;
import java.util.Scanner;

public class DoubleOrNothing {

    private int points = 10;
    private Random random = new Random();

    public boolean askIfDouble() {
        System.out.println("Do you want to double?");
        Scanner scanner = new Scanner((System.in));
        boolean doAgain = scanner.nextBoolean();

        return doAgain;
    }


    public void playGame() {
        boolean doubleOrNothing = false;
        if (askIfDouble()) {
            doubleOrNothing = random.nextBoolean();
            System.out.println("Double your win?  " + doubleOrNothing);
            if (doubleOrNothing) {
                points *= 2;
                System.out.println("You doubled your points. Points available: " + points);
                playGame();
            } else {
                System.out.println("You lost all points.");
                System.exit(1);
            }
        } else {
            System.out.println("You decided to leave the game with the balance: " + points);
        }
    }

}