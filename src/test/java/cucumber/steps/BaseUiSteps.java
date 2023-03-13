package cucumber.steps;

import com.hillel.core.driver.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import org.openqa.selenium.WebDriver;

import static com.hillel.core.driver.WebDriverFactory.resetDriver;

public class BaseUiSteps {

    protected static final WebDriver driver = WebDriverFactory.getDriver();


}
