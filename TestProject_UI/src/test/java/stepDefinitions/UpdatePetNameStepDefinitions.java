package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

public class UpdatePetNameStepDefinitions {

    private Response response;
    private String petId;

    @Given("there is an existing pet with ID {string}")
    public void there_is_an_existing_pet_with_ID(String id) {
        this.petId = id;
        // You can perform any setup required here, such as creating the pet in the system
    }

    @When("I update the pet name to {string}")
    public void i_update_the_pet_name_to(String newName) {
        String requestBody = "{ \"name\": \"" + newName + "\" }";
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put("https://petstore.swagger.io/v2/pet/" + petId);
    }

    @Then("the pet should be updated successfully with name {string}")
    public void the_pet_should_be_updated_successfully_with_name(String expectedName) {
        Assert.assertEquals(response.getStatusCode(), 200);
        // You can further verify if the pet's name is actually updated by querying the system or checking the response
    }
}

