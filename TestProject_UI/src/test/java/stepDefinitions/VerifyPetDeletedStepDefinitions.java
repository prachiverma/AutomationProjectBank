package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class VerifyPetDeletedStepDefinitions {

    private Response response;

    @Given("there was a pet with ID {string} which was deleted")
    public void there_was_a_pet_with_ID_which_was_deleted(String id) {
        // Assume the pet with ID was deleted
    }

    @When("I send a GET request to retrieve the pet with ID {string}")
    public void i_send_a_GET_request_to_retrieve_the_pet_with_ID(String id) {
        response = RestAssured.get("https://petstore.swagger.io/v2/pet/" + id);
    }

    @Then("the response status code should be 404")
    public void the_response_status_code_should_be_404() {
        Assert.assertEquals(response.getStatusCode(), 404);
    }
}

