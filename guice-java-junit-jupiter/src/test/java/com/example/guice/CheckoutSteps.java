package com.example.guice;

import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Then;
import jakarta.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@ScenarioScoped
public final class CheckoutSteps {

    private final BasketState basketState;

    @Inject
    public CheckoutSteps(BasketState basketState) {
        this.basketState = basketState;
    }

    @Then("the basket total should be {int}")
    public void theBasketTotalShouldBe(int expectedTotal) {
        assertThat(basketState.total()).isEqualTo(expectedTotal);
    }

    @Then("the basket contains {int} items")
    public void theBasketContainsItems(int expectedItemCount) {
        assertThat(basketState.itemCount()).isEqualTo(expectedItemCount);
    }

}