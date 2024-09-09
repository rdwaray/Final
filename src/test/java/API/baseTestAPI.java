package API;

import io.restassured.RestAssured;

public class baseTestAPI {
    //URL dasar API
    public static final String BASE_URL = "https://reqres.in";

    //Mengembalikan URL dasar API
    public static String getBaseUrl() {
        return BASE_URL;
    }

    //Mendapatkan endpoint getUser
    public static String getUserEndpont(){
        return BASE_URL + "/api/users";
    }

    public static void setupRestAssured() {
        RestAssured.baseURI = getBaseUrl();
    }
}