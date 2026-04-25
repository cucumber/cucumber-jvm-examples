Feature: Scenario-scoped state with Guice

  Scenario: Share state between step classes
    Given an empty basket
    When I add an item priced 4
    And I add an item priced 3
    Then the basket total should be 7
    And the basket contains 2 items

  Scenario: Isolate state between scenarios
    Given an empty basket
    Then the basket total should be 0
    And the basket contains 0 items