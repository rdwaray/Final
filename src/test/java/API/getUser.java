package API;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class getUser extends baseTestAPI {
    private static final String Json_Schema = "jsonSchema/listSchema.json";
    private Response response;
    private String userId;

    @BeforeEach
    public void setUp() {
        baseTestAPI.setupRestAssured();
    }

    @AfterEach
    public void close() {
        System.out.println("Tes selesai");
    }


    @Given("I have a user with ID {string}")
    public void iHaveAUserWithID(String id) {
        this.userId = id;
    }

    @When("I request the details for the user with ID {string}")
    public void iRequestTheDetailsForTheUserWithID(String id) {
        this.userId = id; // Set userId from the step definition
        this.response = RestAssured.given()
                .baseUri(BASE_URL) // Make sure BASE_URL is set correctly
                .basePath("/users/" + userId) // Ensure endpoint path is correct
                .when()
                .get();
        System.out.println("Response: " + response.getBody().asString());
    }

    @Then("the response code should be {int}")
    public void theResponseCodeShouldBe(int statusCode) {
        assertEquals((int) statusCode, response.getStatusCode());
        System.out.println("Status Code: " + response.statusCode());
    }

    @And("the response should contain the user ID {string} details")
    public void theResponseShouldContainTheUserIDDetails(String id) {
        String actualUserId = response.jsonPath().getString("data.id");
        assertEquals(id, actualUserId);
        System.out.println("Pencarian ID: " + id);
    }
}

