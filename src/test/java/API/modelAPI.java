package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class modelAPI {

    private static final String BASE_URL = "https://reqres.in/api";

    public Response getUser(int userId) {
        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .when()
                .get("/users/" + userId);
    }

    public Response getListAllUser(int page){
        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .queryParam("page", 2)
                .when()
                .get("/users/");
    }

    public Response createUser(int userId, String name, String job) {
        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .basePath("/users/")
                .header("Content-Type","application/json")
                .body("{ \"name\": \"" + name + "\", \"job\": \"" + job + "\" }")
                .post();
    }

    public Response updateUser(int userId, String name, String job) {
        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .basePath("/users/")
                .header("Content-Type","application/json")
                .body("{ \"name\": \"" + name + "\", \"job\": \"" + job + "\" }")
                .put();
    }

    public Response patchUser(int userId, String name, String job) {
        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .basePath("/users/")
                .header("Content-Type","application/json")
                .body("{ \"name\": \"" + name + "\", \"job\": \"" + job + "\" }")
                .patch();
    }

    public Response deleteUser(int userId) {
        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .when()
                .delete("/users/" + userId);
    }

    public Response register(String email, String password) {
        return RestAssured
                .given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}")
                .when()
                .post(BASE_URL+"/register");
    }

    public Response loginUser(String email, String password) {
        return RestAssured
                .given()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}")
                .when()
                .post(BASE_URL+"/login");
    }
}
