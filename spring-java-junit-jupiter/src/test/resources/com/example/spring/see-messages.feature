Feature: See Messages

  Scenario: See another user's messages
    Given there is a user
    When the user has posted the message "this is my message"
    Then I should see "this is my message" in the users messages
