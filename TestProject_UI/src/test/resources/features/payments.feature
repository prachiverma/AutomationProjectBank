@UI
Feature: Verify Non-cash Payments Section

  Scenario: Verify Navigation to Non-cash Payments Section
    Given I am on the homepage of the website
    When I click on the "Payments & Infrastructure" link
    Then I should see the page with the title "Payments & Infrastructure"
    When I click on the "Payments System" link
    And I click on the "Non-cash Payments" link
    Then I verify that I am taken to the "Non-cash Payments" section

