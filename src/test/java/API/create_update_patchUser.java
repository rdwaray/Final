package API;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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

import static org.junit.Assert.assertEquals;

public class create_update_patchUser extends baseTestAPI {

    private Response response;
    File jsonSchemaPath = new File("src/test/resources/API/JsonSchema/create_update_patch.json");
    private int userId;
    private String name;
    private String job;
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


    @Given("I have user {int} data with name {string} and job {string}")
    public void iHaveUserDataWithNameAndJob(int id, String name, String job){
        this.userId = id;
        this.name = name ;
        this.job = job;
    }



    @And("the response should match the JSON schema {string}")
    public void theResponseShouldMatchTheJSONSchema(String arg0) {
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaPath));
        System.out.println("Schema validation completed.");
    }

    @And("the response should contain the user updated data")
    public void theResponseShouldContainTheUserUpdatedData() {
        Assert.assertEquals(name, response.jsonPath().getString("name"));
        Assert.assertEquals(job, response.jsonPath().getString("job"));
        System.out.println("User " + userId + " updated with name: " + name + " and job: " + job);
    }

    @When("I send a PUT request to update the user")
    public void iSendAPUTRequestToUpdateTheUser() {
        response = modelAPI.updateUser(userId,name,job);
        System.out.println("Request sent with user : " + userId + ", name : " + name + " and job: " + job);
        System.out.println("Response Body: " + response.getBody().asString());

    }


    @When("I send a POST request to create the user")
    public void iSendAPOSTRequestToCreateTheUser() {
        response = modelAPI.createUser(userId,name,job);
        System.out.println("Request sent with user : " + userId + ", name : " + name + " and job: " + job);
        System.out.println("Response Body: " + response.getBody().asString());

    }

    @And("the response should contain the created user data")
    public void theResponseShouldContainTheCreatedUserData() {
        Assert.assertEquals(name, response.jsonPath().getString("name"));
        Assert.assertEquals(job, response.jsonPath().getString("job"));
        System.out.println("User " + userId + " created with name: " + name + " and job: " + job);
    }

    @Then("the response update code post should be {int}")
    public void theResponseUpdateCodePostShouldBe(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
        System.out.println("Status Code: " + response.statusCode());
    }

    @Then("the response create code should be {int}")
    public void theResponseCreateCodeShouldBe(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
        System.out.println("Status Code: " + response.statusCode());
    }

    @When("I send a PATCH request to update the user")
    public void iSendAPATCHRequestToUpdateTheUser() {
        response = modelAPI.patchUser(userId,name,job);
        System.out.println("Request sent with user : " + userId + ", name : " + name + " and job: " + job);
        System.out.println("Response Body: " + response.getBody().asString());

    }

    @Then("the response patch code post should be {int}")
    public void theResponsePatchCodePostShouldBe(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
        System.out.println("Status Code: " + response.statusCode());
    }

    @And("the response should contain the user patch data")
    public void theResponseShouldContainTheUserPatchData() {
        Assert.assertEquals(name, response.jsonPath().getString("name"));
        Assert.assertEquals(job, response.jsonPath().getString("job"));
        System.out.println("User " + userId + " created with name: " + name + " and job: " + job);
    }
}
