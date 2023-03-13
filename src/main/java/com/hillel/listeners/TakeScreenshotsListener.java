package com.hillel.listeners;

import com.hillel.core.driver.WebDriverFactory;
import com.hillel.util.WebDriverUtils;
import io.qameta.allure.Allure;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Log4j2
public class TakeScreenshotsListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        File screenshot = WebDriverUtils.getScreenshot(WebDriverFactory.getDriver());
        try{
            Allure.addAttachment("screenshot", Files.newInputStream(screenshot.toPath()));
        } catch (IOException e) {
            log.error("We can not get screenshot");
        }
    }
}
