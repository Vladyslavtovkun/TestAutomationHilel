package junit;

import com.hillel.pages.FreeConsultationPage;
import com.hillel.pages.HomePage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JunitTest extends BaseTest{


    @Parameterized.Parameters(name = "name={0}, email={1}, phone={2}, messenger={3}, course={4}")
    public static List<Object[]> data () {
        return Arrays.asList(new Object[][]{
                {"John", "john@mail.com", "12345", "tg", "PHP"},
                {"Alice", "alice@mail.com", "12346", "vb", "React"},
                {"Tom", "tom@mail.com", "12347", "tg", "Python"}
        });
    }

    @Parameterized.Parameter(0)
    public String name;

    @Parameterized.Parameter(1)
    public String email;

    @Parameterized.Parameter(2)
    public String phone;

    @Parameterized.Parameter(3)
    public String messenger;

    @Parameterized.Parameter(4)
    public String course;

    @Test
    public void freeConsultTest() {
        HomePage homePage = new HomePage();
        FreeConsultationPage freeConsultationPage = new FreeConsultationPage();
        homePage.open();
        homePage.clickFreeConsultBtn();
        freeConsultationPage.setName(name);
        freeConsultationPage.setEmail(email);
        freeConsultationPage.setPhone(phone);
        freeConsultationPage.setMessengers(messenger);
        freeConsultationPage.clickChooseCourseBtn();
        freeConsultationPage.setCourses(course);
        Assert.assertTrue(freeConsultationPage.getUserName().isDisplayed());
    }


    @Test
    public void firstJunitTest() {
        HomePage homePage = new HomePage();
        homePage.open();
        // Assert.assertEquals(9, homePage.getCommonQuestionsSize(), "Questions sizes not equal");
    }
}
