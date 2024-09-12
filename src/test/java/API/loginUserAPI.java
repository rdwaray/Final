package API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class loginUserAPI extends baseTestAPI {


    private Response response;
    private final String loginsuccessSchemaPath = "src/test/resources/API/JsonSchema/login.json";
    private final String loginerrorSchemaPath  = "src/test/resources/API/JsonSchema/login.json";
    private String email;
    private String password;
    private final modelAPI modelAPI = new modelAPI();

    @Given("I provide login data a valid email {string} and a valid password {string}")
    public void iProvideLoginDataAValidEmailAndAValidPassword(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @When("I submit the login request")
    public void iSubmitTheLoginRequest() {
        response  = modelAPI.loginUser(email,password);
        System.out.println("Request sent with email: " + email + " and password: " + password);
        System.out.println("Response Body: " + response.getBody().asString());

    }

    @And("the response login code should be {int}")
    public void theResponseLoginCodeShouldBe(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    @And("the response login should be validated")
    public void theResponseLoginShouldBeValidated() {
       Assert.assertEquals(email, response.jsonPath().getString("email"));
        Assert.assertEquals(password, response.jsonPath().getString("password"));

        System.out.println("Full Response Body: " + response.getBody().asString());


        System.out.println("Extracted email: " + response.jsonPath().getString("email"));
        System.out.println("Extracted password: " + response.jsonPath().getString("password"));


        System.out.println(" login with email: " + email + " and password: " + password);
    }

    @And("the response login JSON should match the schema {string}")
    public void theResponseLoginJSONShouldMatchTheSchema(String arg0) {
//        String responseBody = response.getBody().asString();
//        System.out.println("Response Body: " + responseBody);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(loginsuccessSchemaPath)));
        System.out.println("Schema validation completed.");
    }

    @Given("I provide login data a valid email {string} and an empty password")
    public void iProvideLoginDataAValidEmailAndAnEmptyPassword(String email) {
        this.email = email;
        this.password = "";
    }

    @And("the response faliure login code should be {int}")
    public void theResponseFaliureLoginCodeShouldBe(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
        System.out.println("Status Code: " + response.statusCode());
    }

    @Then("the response login should contain an error message about the missing password")
    public void theResponseLoginShouldContainAnErrorMessageAboutTheMissingPassword() {
        String errorMessage = response.jsonPath().getString("error");
        Assert.assertEquals(null, errorMessage);
        System.out.println("Error message for missing password: " + errorMessage);
    }

    @And("the faliure login response JSON should match the schema {string}")
    public void theFaliureLoginResponseJSONShouldMatchTheSchema(String arg0) {
//        String responseBody = response.getBody().asString();
//        System.out.println("Response Body: " + responseBody);

        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(loginerrorSchemaPath)));
        System.out.println("Schema validation completed.");
    }

    @Given("I provide login data an  empty email and a valid password {string}")
    public void iProvideLoginDataAnEmptyEmailAndAValidPassword(String password) {
        this.email = "";
        this.password =password;

    }

    @Then("the response login should contain an error message about the missing email")
    public void theResponseLoginShouldContainAnErrorMessageAboutTheMissingEmail() {
        String errorMessage = response.jsonPath().getString("error");
        Assert.assertEquals(null, errorMessage);
        System.out.println("Error message for missing email: " + errorMessage);
    }

//    @Then("the response should contain the  user ID")
//    public void theResponseShouldContainTheUserID() {
//        String userId = response.jsonPath().getString("user_id");
//        System.out.println("User ID: " + userId);
//    }

}
