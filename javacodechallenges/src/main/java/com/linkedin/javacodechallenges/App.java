package com.linkedin.javacodechallenges;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {

    public static final Map<Character, Integer> letterPoints = Map.ofEntries(Map.entry('A', 1),
            Map.entry('B', 3), Map.entry('C', 3), Map.entry('D', 2), Map.entry('E', 1),
            Map.entry('F', 4), Map.entry('G', 2), Map.entry('H', 4), Map.entry('I', 1),
            Map.entry('J', 8), Map.entry('K', 5), Map.entry('L', 1), Map.entry('M', 3),
            Map.entry('N', 1), Map.entry('O', 1), Map.entry('P', 3), Map.entry('Q', 10),
            Map.entry('R', 1), Map.entry('S', 1), Map.entry('T', 1), Map.entry('U', 1),
            Map.entry('W', 4), Map.entry('V', 4), Map.entry('X', 8), Map.entry('Y', 4),
            Map.entry('Z', 10));

    public static int wordScoreCalculator(String word) {
         List<String> cleanWord =  word.chars().filter(Character::isLetter).mapToObj(Character::toString).collect(Collectors.toList());

        int sum = 0;
        for (String letter : cleanWord) {
            System.out.println(letter);
            sum += letterPoints.get(letter.toUpperCase().charAt(0));
        }

        return sum;

    }

    public static void main(String[] args) {
        System.out.println("Enter a word and we'll tell you how many " +
                "points it will earn!");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println("Your word " + word + " will earn "
                + wordScoreCalculator(word));
        sc.close();
    }

}
