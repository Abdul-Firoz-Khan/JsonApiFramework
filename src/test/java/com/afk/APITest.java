import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.afk.constants.Endpoints.GET_ALL_PERSON;
import static io.restassured.RestAssured.given;

public class APITest {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    public void testAPI() {
        given()
                .when()
                .get(GET_ALL_PERSON)
                .then()
                .statusCode(200);
    }
}
