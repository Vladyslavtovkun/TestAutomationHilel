package com.hillel.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
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

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.hillel.util.WaitUtils.waitUntilElementIsClickable;
import static com.hillel.util.WaitUtils.waitUntilElementIsVisible;

public class HomePage extends BasePage{

    private SelenideElement title = $x("//div[@class='section-content']");
    private SelenideElement programmingBtn = $x("//a[@href='https://ithillel.ua/courses/programming']");
    private ElementsCollection commonQuestions = $$x("//ul[@id='accordion-faq']/li");

    @Getter
    private SelenideElement freeConsultBtn = $x("//button[@id='btn-consultation-hero']");

    private ElementsCollection courseCategories = $$x("//div[@class='course-cat-bar_body']/p[@class='course-cat-bar_label']");

    @Step("Open hillel base page")
    @Override
    public void open() {
        Selenide.open(ConfigProvider.BASE_URL);
        ensureOpened();
    }

    @Override
    public void ensureOpened() {
//        WebElement logo = super.driver.findElement(By.xpath(title));
//        waitUntilElementIsVisible(super.driver, logo);
    }

    public void clickProgrammingCourseBtn() {
        programmingBtn.should(Condition.visible);
       // waitUntilElementIsClickable(driver, programmingBtn);
        programmingBtn.click();
    }

    public int getCommonQuestionsSize() {
        return commonQuestions.size();
    }

    public void clickFreeConsultBtn() {
       // waitUntilElementIsClickable(driver, freeConsultBtn);
        freeConsultBtn.should(Condition.visible);
        freeConsultBtn.click();
    }

    public List<String> getCourseCategories() {
        return courseCategories.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
