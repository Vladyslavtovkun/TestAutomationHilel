package testNg;

import com.hillel.core.data.DataProviderMethods;
import com.hillel.listeners.RetryListenerExample;
import com.hillel.pages.FreeConsultationPage;
import com.hillel.pages.HomePage;
import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
@Epic("Hillel home Page tests")
@Feature("Home page opened")
public class TestNgClass extends BaseTest{

    /**
     * Verify that question size equals 9
     */
    @Description(useJavaDoc = true)
    @Link("https://example.org/issue/")
    @Test(description = "Open page test", priority = 2, groups = "regression")
    public void firstTestNgTest(){
        HomePage homePage = new HomePage(driver);
        homePage.open();
         Assert.assertEquals(9, homePage.getCommonQuestionsSize(), "Questions sizes not equal");
    }

    @Story("User check courses number")
    @Issue("Jira111")
    @Test(priority = 1, groups = "smoke", retryAnalyzer = RetryListenerExample.class)
    public void checkCoursesNumber() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        log.info("Home hillel page is opened");
        Assert.assertEquals(homePage.getCourseCategories().size(), 6, "Incorrect number of courses");
    }

    @Test(dataProvider = "data", dataProviderClass = DataProviderMethods.class, dependsOnMethods = "checkCoursesNumber",
    alwaysRun = true)
    public void freeConsultTest(String name, String email, String phone, String messenger, String course) {
        HomePage homePage = new HomePage(driver);
        FreeConsultationPage freeConsultationPage = new FreeConsultationPage(driver);
        homePage.open();
        homePage.clickFreeConsultBtn();
        freeConsultationPage.setName(name);
        freeConsultationPage.setEmail(email);
        freeConsultationPage.setPhone(phone);
        freeConsultationPage.setMessengers(messenger);
        freeConsultationPage.clickChooseCourseBtn();
        freeConsultationPage.setCourses(course);
        org.junit.Assert.assertTrue(freeConsultationPage.getUserName().isDisplayed());
    }
}
