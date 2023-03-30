//package cucumber.steps;
//
//import com.hillel.pages.BasePage;
//import com.hillel.pages.FreeConsultationPage;
//import com.hillel.pages.HomePage;
//import com.hillel.util.WaitUtils;
//import io.cucumber.java.Transpose;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.List;
//import java.util.Map;
//
//import static com.hillel.util.WaitUtils.waitUntilElementIsClickable;
//
//public class HomePageSteps extends BaseUiSteps {
//
//    BasePage page = null;
//
//    @Given("^I am on the (Home|FreeConsult) page$")
//    public void openPage(String pageName) {
//        switch (pageName) {
//            case "Home":
//                page = new HomePage(driver);
//                break;
//            case "FreeConsult":
//                page = new FreeConsultationPage(driver);
//                break;
//            default:
//                throw new IllegalArgumentException("No such page" + pageName);
//        }
//        page.open();
//    }
//
//    @Then("I can see Free Consult button")
//    public void verifyCanSeeFreeConsultButton() {
//        Assert.assertTrue(((HomePage)page).getFreeConsultBtn().isDisplayed(),
//                "Free Consult button not displayed");
//    }
//
//    @Then("Information is found")
//    public void informationIsFound() {
//
//    }
//
//    @When("I fill the following parameters:")
//    public void iFillTheFollowingParameters(@Transpose Map<String, String> params) {
//
//        FreeConsultationPage freeConsultationPage = new FreeConsultationPage(driver);
//        WaitUtils.waitUntilElementIsVisible(driver, freeConsultationPage.getUserName());
//        freeConsultationPage.setName(params.get("name"));
//        freeConsultationPage.setEmail(params.get("email"));
//        freeConsultationPage.setPhone(params.get("phone"));
//        freeConsultationPage.setMessengers(params.get("messenger"));
//        freeConsultationPage.setCourses(params.get("course"));
//    }
//
//    @When("Click free consult button")
//    public void clickFreeConsultButton() {
//        HomePage homePage = new HomePage(driver);
//        homePage.clickFreeConsultBtn();
//    }
//}
