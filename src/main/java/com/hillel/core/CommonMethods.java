package com.hillel.core;

import org.openqa.selenium.WebElement;

public class CommonMethods {

    private static WebElement field;

    public CommonMethods(WebElement element) {
        field = element;
    }

    public String getValue() {
        return field.getAttribute("value");
    }

    public static void setValue(String value) {
        field.clear();
        field.sendKeys(value);
    }
}
