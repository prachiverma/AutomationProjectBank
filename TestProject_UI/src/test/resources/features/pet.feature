@API
Feature: Create a PET

  Scenario: Create a new PET
    Given I have a new pet with ID "123" and name "Rex" and status "available"
    When I send a POST request to create the pet
    Then the pet should be created successfully with ID "123" and name "Rex" and status "available"


  Scenario: Update PET Name
    Given there is an existing pet with ID "123"
    When I update the pet name to "Buddy"
    Then the pet should be updated successfully with name "Buddy"


  Scenario: Delete a PET
    Given there is an existing pet with ID "123"
    When I send a DELETE request to delete the pet
    Then the pet should be deleted successfully


  Scenario: Verify PET is Deleted
    Given there was a pet with ID "123" which was deleted
    When I send a GET request to retrieve the pet with ID "123"
    Then the response status code should be 404


