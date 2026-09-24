package com.example.calculator;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class DateStepDefinitions {

    private String result;
    private DateCalculator calculator;

    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    LocalDate iso8601Date(String year, String month, String day) {
        return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }

    @Given("today is {iso8601Date}")
    void today_is(LocalDate date) {
        calculator = new DateCalculator(date);
    }

    @When("I ask if {iso8601Date} is in the past")
    void I_ask_if_date_is_in_the_past(LocalDate date) {
        result = calculator.isDateInThePast(date);
    }

    @Then("^the result should be (yes|no)$")
    void the_result_should_be(String expectedResult) {
        assertThat(result).isEqualTo(expectedResult);
    }

}
