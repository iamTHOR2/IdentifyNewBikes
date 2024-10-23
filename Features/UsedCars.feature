@sanity
Feature: Display popular used car models in Chennai
  As a user
  I want to see the popular models of used cars in Chennai
  So that I can make an informed decision about my purchase

  Scenario: View popular used car models in Chennai
    Given the user has the car sales website open in their browser
    When the user hovers over the Used Cars link
    And the user selects Chennai from the dropdown
    And the user scrolls down to the list of popular models
    Then the user should extract all the popular models in a List
    And the user displays the same in the console
