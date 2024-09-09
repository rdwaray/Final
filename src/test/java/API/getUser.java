    package API;

    import API.modelAPI;
    import io.cucumber.java.After;
    import io.cucumber.java.Before;
    import io.cucumber.java.en.And;
    import io.cucumber.java.en.Given;
    import io.cucumber.java.en.Then;
    import io.cucumber.java.en.When;
    import io.restassured.RestAssured;
    import io.restassured.module.jsv.JsonSchemaValidator;
    import io.restassured.response.Response;
    import org.apache.commons.compress.harmony.unpack200.IMatcher;
    import org.junit.jupiter.api.AfterEach;
    import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
    import org.junit.jupiter.api.BeforeEach;


    import java.io.File;
    import java.util.List;

    import static org.junit.Assert.*;

    public class getUser extends baseTestAPI {

        private Response response;
        File jsonSchemaPath = new File("src/test/resources/API/JsonSchema/list_user.json");
        private int userId;
        private final modelAPI modelAPI = new modelAPI();

//        @BeforeEach
//        public void setUp() {
//            baseTestAPI.setupRestAssured();
//        }
//
//        @AfterEach
//        public void close() {
//            System.out.println("Tes selesai");
//        }


        @Given("I have a user with ID {string}")
        public void iHaveAUserWithID(String id) {

            userId = Integer.parseInt(id);
        }

        @When("I request the details for the user with ID {string}")
        public void iRequestTheDetailsForTheUserWithID(String id) {
            userId = Integer.parseInt(id);
            response = modelAPI.getUser(userId);
            System.out.println("Request user id : " + userId);
            System.out.println("Response Body: " + response.getBody().asString());
        }

        @Then("the response code should be {int}")
        public void theResponseCodeShouldBe(int statusCode) {
            assertEquals(statusCode, response.getStatusCode());
            System.out.println("Status Code: " + response.statusCode());
        }

        @And("the response should contain the user ID {string} details")
        public void theResponseShouldContainTheUserIDDetails(String id) {
            String actualUserId = response.jsonPath().getString("data.id");
            assertEquals(id, actualUserId);
            System.out.println("Searching ID: " + id);
        }

        @Then("validation response json with JSONSchema {string}")
        public void validationResponeJsonWithJSONSchema(String schemaFileName) {
            response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaPath));
            System.out.println("Schema validation completed.");
        }

        @Then("validation response get user")
        public void validationResponseGetUser() {
            Integer userId = response.jsonPath().getInt("data.id");
            String userEmail = response.jsonPath().getString("data.email");
            String firstName = response.jsonPath().getString("data.first_name");
            String lastName = response.jsonPath().getString("data.last_name");
            String avatar = response.jsonPath().getString("data.avatar");



            assertNotNull(response.jsonPath().getString("data.id"), "User ID should not be null");
            assertNotNull(response.jsonPath().getString("data.first_name"), "User name should not be null");
            assertNotNull(response.jsonPath().getString("data.last_name"), "User name should not be null");
            assertNotNull(response.jsonPath().getString("data.email"), "User email should not be null");
            assertNotNull(response.jsonPath().getString("data.avatar"), "User email should not be null");

            System.out.println("User ID: " + userId);
            System.out.println("User Email: " + userEmail);
            System.out.println("User First Name: " + firstName);
            System.out.println("User Last Name: " + lastName);
            System.out.println("User Avatar: " + avatar);



            System.out.println("Response validation passed.");
        }

        @And("the response should be null")
        public void theResponseShouldBeNull() {
            String responseBody = response.getBody().asString().trim();

            // Check for empty JSON object
            boolean isEmptyJsonObject = "{}".equals(responseBody);

            // Optionally check for a specific error message if you expect one
            boolean containsErrorMessage = responseBody.contains("User not found");

            // Assert that the response is either an empty JSON object or contains the error message
            assertTrue("Response body should be an empty JSON object or contain 'User not found' message",
                    isEmptyJsonObject || containsErrorMessage);
            System.out.println("Response is an empty JSON object or contains 'User not found' as expected.");
        }

        @Then("validation response  of non-existent user")
        public void validationResponseOfNonExistentUser() {
            System.out.println("Full Response Body: " + response.getBody().asString());

        }
    }


