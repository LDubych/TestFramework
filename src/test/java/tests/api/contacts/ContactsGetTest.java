package tests.api.contacts;

import commonLibs.api.BaseAPI;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;

public class ContactsGetTest extends ContactBaseTest {
    private static Response responsePositive;

    @BeforeSuite
    public static void makeRequestGetContacts() {
        responsePositive = BaseAPI.get(basicContactsUrl);
    }

    @Test()
    public void getContactsStatusCode_200() {
        responsePositive.then().assertThat().statusCode(is(200));
    }
}
