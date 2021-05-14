package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class GoogleSecondAfterSearchPO extends GoogleSecondPO {

    private List<WebElement> resultSearch;

    GoogleSecondAfterSearchPO(WebDriver wd) {
        super(wd);
        resultSearch = wd.findElements(By.xpath("//div[@class='g']//div/cite"));
    }

    public List<WebElement> getResultSearch() {
        return resultSearch;
    }

}
