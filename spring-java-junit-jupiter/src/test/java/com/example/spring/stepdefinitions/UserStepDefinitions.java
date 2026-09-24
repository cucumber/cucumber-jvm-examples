package com.example.spring.stepdefinitions;

import com.example.spring.User;
import com.example.spring.UserRepository;
import io.cucumber.java.en.Given;

class UserStepDefinitions {

    private final UserRepository userRepository;

    private User currentUser;

    UserStepDefinitions(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Given("there is a user")
    void there_is_a_user() {
        currentUser = userRepository.save(new User("John Doe"));
    }

    User getCurrentUser() {
        return currentUser;
    }

}
