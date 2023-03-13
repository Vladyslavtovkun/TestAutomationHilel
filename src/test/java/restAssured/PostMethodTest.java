package restAssured;

import com.hillel.api.StudentPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PostMethodTest extends BaseApiTest {

    @Test
    public void createStudent() {

        List <String> courses = new ArrayList<>();
        courses.add("JAVA");
        courses.add("C++");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Borys");
        studentPojo.setLastName("Borysov");
        studentPojo.setEmail("borys@gmail.com");
        studentPojo.setProgramme("ComputerScience");
        studentPojo.setCourses(courses);

       RestAssured
                .given()//.baseUri("http://localhost:8080/student/list")
                .contentType(ContentType.JSON)
                .when()
                .body(studentPojo)
                .post()
                .then()
                .statusCode(201);
    }
}
