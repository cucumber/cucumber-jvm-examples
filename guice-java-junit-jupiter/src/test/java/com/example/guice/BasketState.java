package com.example.guice;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public final class BasketState {

    private final Basket basket = new Basket();

    public void reset() {
        basket.reset();
    }

    public void addItem(int price) {
        basket.addItem(price);
    }

    public int total() {
        return basket.total();
    }

    public int itemCount() {
        return basket.itemCount();
    }

}