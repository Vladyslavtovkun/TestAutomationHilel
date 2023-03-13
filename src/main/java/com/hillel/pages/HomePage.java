package com.hillel.pages;

import com.hillel.util.ConfigProvider;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

import static com.hillel.util.WaitUtils.waitUntilElementIsClickable;
import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[@class='section-content']")
    private String title;

    @FindBy(xpath = "//a[@href='https://ithillel.ua/courses/programming']")
    private WebElement programmingBtn;

    @FindBy(xpath = "//ul[@id='accordion-faq']/li")
    private List<WebElement> commonQuestions;

    @Getter
    @FindBy(xpath = "//button[@id='btn-consultation-hero']")
    private WebElement freeConsultBtn;

    @FindBy(xpath = "//div[@class='course-cat-bar_body']/p[@class='course-cat-bar_label']")
    private List<WebElement> courseCategories;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Open hillel base page")
    @Override
    public void open() {
        super.driver.get(ConfigProvider.BASE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
//        WebElement logo = super.driver.findElement(By.xpath(title));
//        waitUntilElementIsVisible(super.driver, logo);
    }

    public void clickProgrammingCourseBtn() {
        waitUntilElementIsClickable(driver, programmingBtn);
        programmingBtn.click();
    }

    public int getCommonQuestionsSize() {
        return commonQuestions.size();
    }

    public void clickFreeConsultBtn() {
        waitUntilElementIsClickable(driver, freeConsultBtn);
        freeConsultBtn.click();
    }

    public List<String> getCourseCategories() {
        return courseCategories.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
