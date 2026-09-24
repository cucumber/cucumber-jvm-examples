package com.example.calculator;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ShoppingSteps implements En {

    private final RpnCalculator calc = new RpnCalculator();

    private List<Grocery> shoppingList;
    private List<Grocery> shopStock;
    private int groceriesPrice;

    ShoppingSteps() {

        Given("the following groceries:", (DataTable dataTable) -> {
            List<Grocery> groceries = dataTable.asList(Grocery.class);
            for (Grocery grocery : groceries) {
                calc.push(grocery.price.value);
                calc.push("+");
            }
        });

        When("I pay {amount}", (Amount amount) -> {
            calc.push(amount.price);
            calc.push("-");
        });

        Then("my change should be {}", (Integer change) -> {
            assertThat(-calc.value().intValue()).isEqualTo(change);
        });

        Given("the following shopping list:", (Grocery[] array) -> {
            shoppingList = Arrays.asList(array);
        });

        Given("the shop has following groceries:", (DataTable dataTable) -> {
            this.shopStock = dataTable.asList(Grocery.class);
        });

        When("I count shopping price", () ->
                shoppingList.forEach(grocery -> {
                    for (var shopGrocery : shopStock) {
                        if (grocery.name.equals(shopGrocery.name)) {
                            groceriesPrice += shopGrocery.price.value;
                        }
                    }
                }));

        Then("price would be {int}", (Integer totalPrice) -> assertThat(groceriesPrice).isEqualTo(totalPrice));

        DataTableType((Map<String, String> row) -> new ShoppingSteps.Grocery(
                row.get("name"),
                ShoppingSteps.Price.fromString(row.get("price"))));

        ParameterType("amount", "\\d+\\.\\d+\\s[a-zA-Z]+", (String value) -> {
            String[] arr = value.split("\\s");
            return new Amount(new BigDecimal(arr[0]), Currency.getInstance(arr[1]));
        });

        DocStringType("shopping_list", (String docstring) ->
                Stream.of(docstring.split("\\s"))
                        .map(Grocery::new)
                        .toArray(Grocery[]::new));
    }

    static class Grocery {

        private final String name;
        private Price price;

        Grocery(String name) {
            this.name = name;
        }

        Grocery(String name, Price price) {
            this.name = name;
            this.price = price;
        }

    }

    static final class Price {

        private final int value;

        Price(int value) {
            this.value = value;
        }

        static Price fromString(String value) {
            return new Price(Integer.parseInt(value));
        }

    }

    static final class Amount {

        private final BigDecimal price;
        private final Currency currency;

        Amount(BigDecimal price, Currency currency) {
            this.price = price;
            this.currency = currency;
        }

    }

}
