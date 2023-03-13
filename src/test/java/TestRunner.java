import com.hillel.core.driver.WebDriverFactory;
import com.hillel.util.ConfigProvider;
import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.hillel.util.WaitUtils.waitUntilElementIsClickable;

public class TestRunner {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver();

        WebElement domesticEquipment = driver.findElement(By.xpath("//div/a[contains(@href,'domestic-equipment')]"));
        driver.get(ConfigProvider.BASE_URL);
        waitUntilElementIsClickable(driver, domesticEquipment);

        driver.quit();
    }
}
