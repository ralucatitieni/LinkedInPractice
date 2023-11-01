package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {

    public static double calculateWaterBill(double gallonsUsage) {
        double totalCharge = 18.84;
        double minGallons = 1496;
        double chargePerCCF = 3.9;

        if (gallonsUsage < minGallons) {
            return totalCharge;
        } else {
            double additionalGallons = gallonsUsage - minGallons;
            int ccf = (int) additionalGallons / 748;

            if (additionalGallons % 748 != 0) {
                ccf += 1;
            }

            return totalCharge + chargePerCCF * ccf;

        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many gallons of water did you " +
                "use this month?");
        double usage = scanner.nextDouble();
        System.out.println("Your water bill is " +
                calculateWaterBill(usage));
        scanner.close();
    }
}
