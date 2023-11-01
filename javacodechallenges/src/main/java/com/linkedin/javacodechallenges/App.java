package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {

    public static boolean isPasswordComplex(String password) {
        return password.length() >= 6 &&
                password.chars().filter(Character::isDigit).count() >= 1 &&
                password.chars().filter(Character::isUpperCase).count() >= 1 &&
                password.chars().filter(Character::isLowerCase).count() >= 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean again = true;
        while (again) {
            System.out.println("Enter a password: ");
            String userInput = scanner.nextLine();
            System.out.println("Is the password complex? "
                    + isPasswordComplex(userInput));
        }

        scanner.close();
    }
}
