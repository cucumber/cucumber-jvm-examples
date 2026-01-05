package com.example.spring.stepdefinitions;

import com.example.spring.User;
import io.cucumber.java.en.Then;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SeeMessagesStepDefinitions {

    private final MockMvc mockMvc;
    private final UserStepDefinitions userStepDefinitions;

    public SeeMessagesStepDefinitions(MockMvc mockMvc, UserStepDefinitions userStepDefinitions) {
        this.mockMvc = mockMvc;
        this.userStepDefinitions = userStepDefinitions;
    }

    @Then("I should see {string} in the users messages")
    public void i_should_see(String content) throws Exception {
        User user = userStepDefinitions.getCurrentUser();
        mockMvc.perform(get("/users/{id}/messages", user.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.messages[0].content", equalTo(content)));
    }

}
