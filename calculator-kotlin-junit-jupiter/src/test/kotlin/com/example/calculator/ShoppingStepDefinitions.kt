package com.example.calculator

import com.example.calaculator.RpnCalculator
import io.cucumber.java.DataTableType
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import kotlin.test.assertEquals

class ShoppingStepDefinitions {
    private val rpnCalculator = RpnCalculator()

    @Given("the following groceries")
    fun givenTheFollowingGroceries(groceries: List<Grocery>){
        for (grocery in groceries){
            rpnCalculator.push(grocery.price.value)
            rpnCalculator.push("+")
        }
    }

    @When("I pay {int}")
    fun whenIPay(amount: Int) {
        rpnCalculator.push(amount)
        rpnCalculator.push("-")
    }

    @Then("my change should be {int}")
    fun myChangeShouldBe(change: Int) {
        rpnCalculator.peek()?.let { assertEquals(change, -it.toInt()) }
    }

    @DataTableType
    fun groceryEntry(entry: Map<String, String>): Grocery {
        val name = entry["name"] ?: error("Missing name")
        val price = Price.fromString(entry["price"] ?: error("Missing price"))
        return Grocery(name, price)
    }

    data class Grocery(val name: String, val price: Price)

    @JvmInline
    value class Price(val value: Int) {
        companion object {
            fun fromString(value: String): Price {
                return Price(value.toInt())
            }
        }
    }

}
