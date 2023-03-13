package com.hillel.core.driver;

import com.hillel.core.Browsers;
import com.hillel.util.ConfigProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    private static final String BROWSER = System.getProperty("browser");
    private static WebDriver driver;

    public static WebDriver getDriver() {
        String browserType = BROWSER != null ? BROWSER : ConfigProvider.BROWSER;

        return getDriver(Browsers.valueOf(browserType.toUpperCase()));
    }

    public static WebDriver getDriver(Browsers browsers) {
        switch (browsers) {
            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFirefoxDriver();
            default:
                throw new IllegalArgumentException("Wrong browser was chosen");
        }
    }

    public static void resetDriver(){
        driver=null;
    }

    private static WebDriver getChromeDriver() {
        if (driver==null) {
            WebDriverManager.chromedriver().browserVersion("111").setup();
            driver = new ChromeDriver();
        //    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }
        return driver;
    }

    private static WebDriver getFirefoxDriver() {
        if (driver==null) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
