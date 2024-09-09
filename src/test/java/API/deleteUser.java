package API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class deleteUser {

    private Response response;
    private int userId;
    private final modelAPI modelAPI = new modelAPI();

//    @BeforeEach
//    public void setUp() {
//        baseTestAPI.setupRestAssured();
//    }
//
//    @AfterEach
//    public void close() {
//        System.out.println("Tes selesai");
//    }


    @Given("I have a user with ID {int}")
    public void iHaveAUserWithID(int id) {
        userId = id;

    }

    @When("I send a DELETE request to remove the user")
    public void iSendADELETERequestToRemoveTheUser() {
        response = modelAPI.deleteUser(userId);
        System.out.println("Request delete user : " + userId);
        System.out.println("Response Body: " + response.getBody().asString());
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
        System.out.println("Status Code: " + response.statusCode());
    }

    @And("the response body should be empty")
    public void theResponseBodyShouldBeEmpty() {
        assertTrue(response.getBody().asString().isEmpty());

    }

    @And("the user with ID {int} should no longer exist")
    public void theUserWithIDShouldNoLongerExist(int id) {
        Response checkResponse = modelAPI.getUser(id); // Assuming getUser method exists
        System.out.println(checkResponse);
    }
}
