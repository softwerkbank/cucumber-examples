Feature: addition

  Scenario: add two positive numbers
    Given number x with value 5
    And number y with value 3
    When add number x and y
    Then result is 8
