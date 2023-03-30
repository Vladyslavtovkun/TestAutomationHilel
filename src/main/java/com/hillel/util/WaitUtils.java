package com.hillel.util;

import org.awaitility.Awaitility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class WaitUtils {
    private WaitUtils() {}

    public static void waitUntilElementIsClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void awaitilityWait(WebElement element) {

        Awaitility.await()
                .atMost(60, TimeUnit.SECONDS)
                .pollInterval(3, TimeUnit.SECONDS)
                .ignoreExceptions()
                .untilTrue(new AtomicBoolean(element.isDisplayed()));
    }
}
