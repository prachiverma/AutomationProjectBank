package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class DeletePetStepDefinitions {

    private Response response;
    private String petId;

  @Given("there is an existing pet with ID {string}")
    public void there_is_an_existing_pet_with(String id) {
      this.petId = id;
   }

    @When("I send a DELETE request to delete the pet")
    public void i_send_a_DELETE_request_to_delete_the_pet() {
        response = RestAssured.delete("https://petstore.swagger.io/v2/pet/" + petId);
    }

    @Then("the pet should be deleted successfully")
    public void the_pet_should_be_deleted_successfully() {
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}

