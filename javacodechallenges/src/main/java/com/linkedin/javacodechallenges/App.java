package com.linkedin.javacodechallenges;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;


public class App {

    public static void redactTextFile(String fileName,
            String[] redactedWordsArray) {

        File file = new File(fileName);
        try (var in = new BufferedReader(new FileReader(file));
                var out = new BufferedWriter(new FileWriter(new File("lalala.txt")))) {
            String line = "";
            while ((line = in.readLine()) != null) {
                for (String toBeReplaced: redactedWordsArray){
                   line =  StringUtils.replaceIgnoreCase(line,toBeReplaced, "REDACTED");
                }
                out.write(line);
                out.newLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What file would you like to " +
                "redact information from?");
        String fileName = scanner.nextLine();

        System.out.println("What words would you like to redact? " +
                "Separate each word or phrase with a comma. " +
                "If you phrase includes punctuation, include " +
                "that in your input.");
        String redactedWords = scanner.nextLine();
        String[] redactedWordsList = redactedWords.split(",");

        redactTextFile(fileName, redactedWordsList);

        scanner.close();
    }
}
