package com.example.guice;

import java.util.ArrayList;
import java.util.List;

public final class Basket {

    private final List<Integer> itemPrices = new ArrayList<>();

    public void reset() {
        itemPrices.clear();
    }

    public void addItem(int price) {
        itemPrices.add(price);
    }

    public int total() {
        return itemPrices.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int itemCount() {
        return itemPrices.size();
    }

}