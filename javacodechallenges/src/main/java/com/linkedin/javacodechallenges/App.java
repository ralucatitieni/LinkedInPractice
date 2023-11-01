package com.linkedin.javacodechallenges;

import java.util.List;

public class App {

    public static double calculateAverageChangeInvested(List<Double> purchases) {

        return purchases.stream().mapToDouble(purchase -> {
            int upper = purchase.intValue();
            if (purchase - upper != 0) {
                upper += 1;
            }
            return upper - purchase;
        }).average().orElseGet(() -> 0);
    }

    public static void main(String[] args) {
        List<Double> purchases = List.of(12.38, 38.29, 5.27, 3.21);
        System.out.println(calculateAverageChangeInvested(purchases));
    }
}
