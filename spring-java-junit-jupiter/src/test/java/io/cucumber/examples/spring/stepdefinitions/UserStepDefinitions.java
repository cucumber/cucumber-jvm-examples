package io.cucumber.examples.spring.stepdefinitions;

import io.cucumber.examples.spring.User;
import io.cucumber.examples.spring.UserRepository;
import io.cucumber.java.en.Given;

public class UserStepDefinitions {

    private final UserRepository userRepository;

    private User currentUser;

    public UserStepDefinitions(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Given("there is a user")
    public void there_is_a_user() {
        currentUser = userRepository.save(new User("John Doe"));
    }

    public User getCurrentUser() {
        return currentUser;
    }

}
