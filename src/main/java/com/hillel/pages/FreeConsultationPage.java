package com.hillel.pages;

import com.hillel.util.ConfigProvider;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static com.hillel.util.WaitUtils.waitUntilElementIsClickable;

public class FreeConsultationPage extends BasePage{

    @Getter
    @FindBy(xpath = "//input[@id='input-name-consultation']")
    private WebElement userName;

    @FindBy(xpath = "//input[@id='input-email-consultation']")
    private WebElement userEmail;

    @FindBy(xpath = "//input[@id='input-tel-consultation']")
    private WebElement userPhone;

    @FindBy(xpath = "//div[@class='socials-input-triggers']/button")
    private List<WebElement> messengersList;

    @FindBy(xpath = "//div[@id='container-input-course-consultation']")
    private WebElement clickChooseCourseBtn;

    @FindBy(xpath = "//ul[@class='listbox_opt-list -scrollbar']/li")
    private List<WebElement> coursesList;

    public FreeConsultationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        super.driver.get(ConfigProvider.BASE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {

    }

    public void setName(String name) {
       userName.sendKeys(name);
    }

    public void assertNameIsDisplayed() {

    }

    public void setEmail(String email) {
        userEmail.sendKeys(email);
    }

    public void setPhone(String phone) {
        userPhone.sendKeys(phone);
    }

    public void setMessengers(String messengers) {
        for (WebElement element: this.messengersList) {
            if(element.getAttribute("data-name").equals(messengers)){
                element.click();
            }
        }
    }

    public void setCourses(String courses) {
        for (WebElement element: this.coursesList) {
            if(element.getText().equals(courses)){
                element.click();
            }
        }
    }

    public void clickChooseCourseBtn() {
        waitUntilElementIsClickable(driver, clickChooseCourseBtn);
        clickChooseCourseBtn.click();
    }

    //List actual = 10+el



}
