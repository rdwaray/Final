package API;

import io.restassured.RestAssured;

public class baseTestAPI {
    public static final String BASE_URL = "https://reqres.in/api";

    public static String getBaseUrl() {
        return BASE_URL;
    }
    public static void setupRestAssured() {
        RestAssured.baseURI = getBaseUrl();
    }
}