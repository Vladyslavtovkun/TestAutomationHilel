package testNg;

import com.hillel.core.driver.WebDriverFactory;
import com.hillel.listeners.TakeScreenshotsListener;
import com.hillel.util.WebDriverUtils;
import io.qameta.allure.Allure;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

import static com.hillel.core.driver.WebDriverFactory.resetDriver;

@Log4j2
@Listeners(TakeScreenshotsListener.class)
public class BaseTest {

    protected static WebDriver driver;
    @BeforeClass
    public static void beforeClass() {
        driver = WebDriverFactory.getDriver();
    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
        resetDriver();
    }
}
