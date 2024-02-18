package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

public class CreatePetStepDefinitions {

    private Response response;

    @Given("I have a new pet with ID {string} and name {string} and status {string}")
    public void i_have_a_new_pet_with_ID_and_name_and_status(String id, String name, String status) {
        String requestBody = "{ \"id\": " + id + ", \"name\": \"" + name + "\", \"status\": \"" + status + "\" }";
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("https://petstore.swagger.io/v2/pet");
    }

    @When("I send a POST request to create the pet")
    public void i_send_a_POST_request_to_create_the_pet() {
        // The POST request is already sent in the Given step
    }

    @Then("the pet should be created successfully with ID {string} and name {string} and status {string}")
    public void the_pet_should_be_created_successfully_with_ID_and_name_and_status(String id, String name, String status) {
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getBody().jsonPath().getString("id"), id);
        Assert.assertEquals(response.getBody().jsonPath().getString("name"), name);
        Assert.assertEquals(response.getBody().jsonPath().getString("status"), status);
    }
}

