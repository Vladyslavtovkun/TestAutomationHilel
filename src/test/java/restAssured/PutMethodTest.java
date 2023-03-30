package restAssured;

import com.hillel.api.StudentPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PutMethodTest extends BaseApiTest {

    @Test
    public void updateStudent() {

        List<String> courses = new ArrayList<>();
        courses.add("JAVA");
        courses.add("C++");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Borys");
        studentPojo.setLastName("Borysov");
        studentPojo.setEmail("borys@gmail.com.ua");
        studentPojo.setProgramme("ComputerScience");
        studentPojo.setCourses(courses);

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .body(studentPojo)
                .put("/2")
                .then()
                .statusCode(200);
    }

    @Test
    public void updateStudentsField() {

        List<String> courses = new ArrayList<>();
        courses.add("JAVA");
        courses.add("C++");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Borys");
        studentPojo.setLastName("Borysov");
        studentPojo.setEmail("borys2023@gmail.com.ua");
        studentPojo.setProgramme("ComputerScience1");
        studentPojo.setCourses(courses);

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .body(studentPojo)
                .put("/101")
                .then()
                .statusCode(200);
    }
}
