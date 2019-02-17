package commonLibs.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class BaseAPI {
    private static String basicURL = "http://localhost:8182";

    public static String getBasicURL() {
        return basicURL;
    }

    public static Response get(String url) {
        return RestAssured.get(basicURL+ url);
    }

    public static Response post(String url) {
        return RestAssured.post(basicURL+ url);
    }

}
