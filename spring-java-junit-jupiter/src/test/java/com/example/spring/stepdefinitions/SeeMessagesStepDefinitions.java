package com.example.spring.stepdefinitions;

import com.example.spring.User;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SeeMessagesStepDefinitions {

    private final MockMvc mockMvc;
    private final UserStepDefinitions userStepDefinitions;

    private ResultActions resultActions;

    public SeeMessagesStepDefinitions(MockMvc mockMvc, UserStepDefinitions userStepDefinitions) {
        this.mockMvc = mockMvc;
        this.userStepDefinitions = userStepDefinitions;
    }

    @When("I visit the page for the User")
    public void i_visit_the_page_for_the_user() throws Exception {
        User user = userStepDefinitions.getCurrentUser();
        resultActions = mockMvc
                .perform(get("/users/" + user.getId()))
                .andExpect(status().isOk());
    }

    @Then("I should see {string}")
    public void i_should_see(String content) throws Exception {
        resultActions.andExpect(content().string(containsString(content)));
    }

}
