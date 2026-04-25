package com.example.guice;

import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import jakarta.inject.Inject;

@ScenarioScoped
public final class BasketSteps {

    private final BasketState basketState;

    @Inject
    public BasketSteps(BasketState basketState) {
        this.basketState = basketState;
    }

    @Given("an empty basket")
    public void anEmptyBasket() {
        basketState.reset();
    }

    @When("I add an item priced {int}")
    public void iAddAnItemPriced(int price) {
        basketState.addItem(price);
    }

}