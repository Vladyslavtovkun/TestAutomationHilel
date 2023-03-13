package restAssured;

import com.hillel.util.ConfigProvider;
import static io.restassured.RestAssured.*;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Extract {

    private static String jsonResponse;

    @BeforeAll
    public static void initialize() {
        baseURI = ConfigProvider.BASE_URL;
        port = Integer.parseInt(ConfigProvider.PORT);
        basePath = ConfigProvider.PATH;
        jsonResponse = given().when().get("/list").asString();
    }

    @Test
    public void getName() {
        String name = JsonPath.read(jsonResponse, "$.firstName");
        System.out.println(name);
    }

    @Test
    public void getAllStudents() {
        List<HashMap<String, ?>> data = JsonPath.read(jsonResponse, "$");
        data.stream().forEach(System.out::println);
    }

    @Test
    public void getFirstStudent() {
        Map<String, Object> firstStudent = JsonPath.read(jsonResponse, "$.id[1]");
        System.out.println(firstStudent);
    }

    @Test
    public void getLastStudent() {
        Map<String, Object> lastStudent = JsonPath.read(jsonResponse, "$.id[-1]");
        System.out.println(lastStudent);
    }
}
