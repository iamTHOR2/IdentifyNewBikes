@regression
Feature: Display upcoming Honda bikes under 4Lac in India on ZigWheels
  As a user
  I want to see the details of upcoming Honda bikes priced under 4Lac on ZigWheels
  So that I can plan my purchase

  Scenario: View upcoming Honda bikes under 4Lac on ZigWheels
    Given the user is on the ZigWheels website
    When the user hovers over the New Bikes section
    And the user selects Upcoming Bikes from the dropdown
    And the user sets the filter Manufacturer to Honda
    And the user clicks on the View More button
    Then the user should filter out the displayed Honda bikes with a price less than 4Lac
    And for each bike priced under 4Lac should be added to their respective lists
