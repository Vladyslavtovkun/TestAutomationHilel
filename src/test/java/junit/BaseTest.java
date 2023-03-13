package junit;

import com.hillel.core.driver.WebDriverFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import static com.hillel.core.driver.WebDriverFactory.resetDriver;

public class BaseTest {

    protected static WebDriver driver;
    @BeforeClass
   public static void beforeClass() {
        driver = WebDriverFactory.getDriver();
    }


    @AfterClass()
    public static void afterClass() {
        driver.quit();
        resetDriver();
    }
}
