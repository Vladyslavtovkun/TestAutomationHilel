package com.hillel.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.hillel.util.ConfigProvider;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.hillel.util.WaitUtils.waitUntilElementIsClickable;
import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class FreeConsultationPage extends BasePage{

    @Getter
    private SelenideElement userName = $x("//input[@id='input-name-consultation']");

    private SelenideElement userEmail = $x("//input[@id='input-email-consultation']");

    @FindBy(xpath = "//input[@id='input-tel-consultation']")
    private WebElement userPhone;

    @FindBy(xpath = "//div[@class='socials-input-triggers']/button")
    private List<WebElement> messengersList;

    private SelenideElement clickChooseCourseBtn = $x("//div[@id='container-input-course-consultation']");

    private ElementsCollection coursesList = $$x("//ul[@class='listbox_opt-list -scrollbar']/li");

    @Override
    public void open() {
        Selenide.open("/");
        ensureOpened();
    }

    @Override
    public void ensureOpened() {

    }

    public void setName(String name) {
        userName.shouldBe(Condition.visible);
       userName.setValue(name);
    }

    public void setEmail(String email) {
        userEmail.setValue(email);
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
       // waitUntilElementIsClickable(driver, clickChooseCourseBtn);
        clickChooseCourseBtn.should(Condition.visible);
        clickChooseCourseBtn.click();
    }

}
