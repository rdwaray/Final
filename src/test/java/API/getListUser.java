package API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.util.List;
import java.util.Map;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class getListUser {

    private Response response;
    File jsonSchemaPath = new File("src/test/resources/API/JsonSchema/list_all_user.json");
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

    @Given("I ask all user detail on page {int}")
    public void iAskAllUserDetailOnPage(int page) {
        response = modelAPI.getListAllUser(page);
    }

    @When("I request the details for theall user detail on page {int}")
    public void iRequestTheDetailsForTheallUserDetailOnPage(int page) {
        response = modelAPI.getListAllUser(page);
        System.out.println("Request detali on page : " + page );
        System.out.println("Response Body: " + response.getBody().asString());
    }

    @And("the response should contain of all user detail on page {int}")
    public void theResponseShouldContainOfAllUserDetailOnPage(int page) {

        int actualPage = response.jsonPath().getInt("page");
        Assert.assertEquals(page, actualPage);
        System.out.println("Expected Page: " + page);
        System.out.println("Actual Page: " + actualPage);

    }


    @Then("validation response get all user")
    public void validationResponseGetAllUser() {
        List<Map<String, ?>> users = response.jsonPath().getList("data");

        for (Map<String, ?> user : users) {

            assertNotNull(response.jsonPath().getString("data.id"), "User ID should not be null");
            assertNotNull(response.jsonPath().getString("data.first_name"), "User name should not be null");
            assertNotNull(response.jsonPath().getString("data.last_name"), "User name should not be null");
            assertNotNull(response.jsonPath().getString("data.email"), "User email should not be null");
            assertNotNull(response.jsonPath().getString("data.avatar"), "User email should not be null");


            System.out.println("User ID: " + user.get("id"));
            System.out.println("User Email: " + user.get("email"));
            System.out.println("User First Name: " + user.get("first_name"));
            System.out.println("User Last Name: " + user.get("last_name"));
            System.out.println("User Avatar: " + user.get("avatar"));
        }

    }

    @Then("the response code getAllUser should be {int}")
    public void theResponseCodeGetAllUserShouldBe(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
        System.out.println("Status Code: " + response.statusCode());
    }

    @Then("validation response getAllUser json with JSONSchema {string}")
    public void validationResponseGetAllUserJsonWithJSONSchema(String arg0) {
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaPath));
        System.out.println("Schema validation completed.");
    }
}
