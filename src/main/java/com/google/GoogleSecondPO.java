package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSecondPO {

    protected WebDriver wd;
    private WebElement inputField;

    GoogleSecondPO(WebDriver wd) {
        this.wd = wd;
        inputField = wd.findElement(By.xpath("//input[@name='q']"));
    }

    public void googleSearch(String requestStr) {
        inputField.click();
        inputField.sendKeys(requestStr);
        inputField.submit();

    }

}
