package restAssured;

import com.hillel.util.ConfigProvider;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest {

    @BeforeAll
    public static void initialize() {
        RestAssured.baseURI = ConfigProvider.BASE_API_URL;
        RestAssured.port = Integer.parseInt(ConfigProvider.PORT);
        RestAssured.basePath = ConfigProvider.PATH;
    }
}
