package com.linkedin.javacodechallenges;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class StoreItem {

    String name;
    double retailPrice;
    double discount;

    public StoreItem(String name, double retailPrice, double discount) {
        this.name = name;
        this.retailPrice = retailPrice;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public static Optional<StoreItem> findLeastExpensive(Collection<StoreItem> items) {

        return items.stream().min(Comparator.comparing(item -> item.getRetailPrice() * (1- item.getDiscount())));

     //   varianta mai complicata aici jos!!
      /* Map<StoreItem, Double> products =  items.stream()
               .collect(Collectors.toMap(item-> item, item -> item.getRetailPrice() * (1 - item.getDiscount())));

        Double cheapestProduct = Collections.min( products.values());

        return products.entrySet().stream().filter(entry -> entry.getValue().equals(cheapestProduct)).map(Entry::getKey).findAny();*/
    }

    @Override
    public String toString() {
        return "Name: " + name + ", " + "Retail price: " + retailPrice + ", " + "Discount " + discount;
    }
}





