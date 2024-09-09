package API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class registerUserAPI extends baseTestAPI {

    private Response response;
    private final String successSchemaPath = "src/test/resources/API/JsonSchema/register.json";
    private final String errorSchemaPath  = "src/test/resources/API/JsonSchema/error_register.json";
    private String email;
    private String password;
    private final modelAPI modelAPI = new modelAPI();

    @Given("I provide a valid email {string} and a valid password {string}")
    public void iProvideAValidEmailAndAValidPassword(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @When("I submit the registration request")
    public void iSubmitTheRegistrationRequest() {
        response  = modelAPI.register(email,password);
        System.out.println("Request sent with email: " + email + " and password: " + password);
        System.out.println("Response Body: " + response.getBody().asString());
    }

    @And("the response register code should be {int}")
    public void theResponseRegisterCodeShouldBe(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
        System.out.println("Status Code: " + response.statusCode());
    }

    @Then("the response should contain the newly created user ID")
    public void theResponseShouldContainTheNewlyCreatedUserID() {
        String userId = response.jsonPath().getString("user_id");
        System.out.println("User ID: " + userId);
    }

    @And("the response should be validated")
    public void theResponseShouldBeValidated() {
        Assert.assertEquals(email, response.jsonPath().getString("email"));
        Assert.assertEquals(password, response.jsonPath().getString("password"));

        System.out.println(" created with email: " + email + " and password: " + password);
    }

    @And("the response JSON should match the schema {string}")
    public void theResponseJSONShouldMatchTheSchema(String schemaType) {
//        String responseBody = response.getBody().asString();
//        System.out.println("Response Body: " + responseBody); cek response json schema
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(successSchemaPath)));
        System.out.println("Schema validation completed.");

    }

    @Given("I provide an invalid email {string} and a valid password {string}")
    public void iProvideAnInvalidEmailAndAValidPassword(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @And("the response faliure register code should be {int}")
    public void theResponseFaliureRegisterCodeShouldBe(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
        System.out.println("Status Code: " + response.statusCode());

    }

    @Then("the response should contain an error message about the invalid email")
    public void theResponseShouldContainAnErrorMessageAboutTheInvalidEmail() {
        String errorMessage = response.jsonPath().getString("error");
        Assert.assertEquals(null, errorMessage);
        System.out.println("Error message for invalid email: " + errorMessage);
    }

    @Given("I provide a valid email {string} and an empty password")
    public void iProvideAValidEmailAndAnEmptyPassword(String email) {
        this.email = email;
        this.password = "";
    }

    @Then("the response should contain an error message about the missing password")
    public void theResponseShouldContainAnErrorMessageAboutTheMissingPassword() {
        String errorMessage = response.jsonPath().getString("error");
        Assert.assertEquals(null, errorMessage);
        System.out.println("Error message for missing password: " + errorMessage);
    }

    @Given("I provide an  empty email and a valid password {string}")
    public void iProvideAnEmptyEmailAndAValidPassword(String password) {
        this.email = "";
        this.password =password;
    }

    @Then("the response should contain an error message about the missing email")
    public void theResponseShouldContainAnErrorMessageAboutTheMissingEmail() {
        String errorMessage = response.jsonPath().getString("error");
        Assert.assertEquals(null, errorMessage);
        System.out.println("Error message for missing email: " + errorMessage);
    }


    @And("the faliure response JSON should match the schema {string}")
    public void theFaliureResponseJSONShouldMatchTheSchema(String arg0) {
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(errorSchemaPath)));
        System.out.println("Schema validation completed.");
    }
}
