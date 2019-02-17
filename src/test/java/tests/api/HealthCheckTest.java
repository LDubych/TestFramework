package tests.api;

import commonLibs.api.BaseAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static commonLibs.api.BaseAPI.getBasicURL;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.is;

public class HealthCheckTest extends BaseTest {
    private static Response responsePositive;
    private static Response responseNegative;

    @BeforeSuite
    public static void makeRequestGetHealthcheck() {
        String url = "/healthcheck";
        responsePositive = BaseAPI.get(url);
        responseNegative = BaseAPI.post(url);
    }

    @Test()
    public void getHealthcheckResponse_live() {
        responsePositive.then().assertThat().body(is("live"));
    }

    @Test()
    public void getHealthcheckStatusCode_200() {
        responsePositive.then().assertThat().statusCode(is(200));
    }

    @Test()
    public void postHealthcheckStatusCode_405() {
        responseNegative.then().assertThat().statusCode(is(405));
    }


}
