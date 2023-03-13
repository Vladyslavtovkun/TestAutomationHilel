package restAssured;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;


public class DeleteMethodTest extends BaseApiTest{

    @Test
    public void deleteStudent() {

        RestAssured
                .given()
                .when()
                .delete("/1")
                .then()
                .statusCode(204);
    }
}
