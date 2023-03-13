package restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class GetMethodTest extends BaseApiTest{


//    @Test
//    public void getAllStudentsTest() {
//// with param
//
//        RestAssured.given().baseUri("http://localhost:8080/student")
//
//               // .given()
//             //   .queryParam("", "")
//                .when()
//                .log().method().get("/list")
//                .then()
//                .statusCode(200);
//    }

    @Test
    public void getAllStudentsTest() {
// with param

//        RestAssured.given().baseUri("http://localhost:8080/student")
//
//                // .given()
//                //   .queryParam("", "")
//                .when()
//                .log().method().get("/list")
//                .then()
//                .statusCode(200);

        Response response = RestAssured
                .given()
                .pathParam("id", 3)
//                .queryParam("lastName", "Holmes")
//                .queryParam("limit", 1)
                .queryParams("lastName", "Holmes", "limit", 1)
                .when()
                .get("http://localhost:8080/student/{id}");
        response.prettyPrint();
    }
}
