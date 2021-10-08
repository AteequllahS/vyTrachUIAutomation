package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Verify_Modules {

    @FindBy(xpath = "(//span[normalize-space(.)='Customers'])")
    public WebElement customersBtn;

    public void goTo() {
        Driver.getDriver().get(ConfigurationReader.read("url"));
    }

    public void verifyModules(){

        List<WebElement> numberOfModules = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));
        System.out.println("numberOfModules.size() = " + numberOfModules.size());

        int expectedSize = 4;
        int actualSize = numberOfModules.size();
        assertEquals(expectedSize, actualSize);
        BrowserUtil.waitFor(3);
    }

    public void verifyModulesTwo(){
        List<WebElement> numberOfModules = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));
        System.out.println("numberOfModules.size() = " + numberOfModules.size());

        int expectedSize = 8;
        int actualSize = numberOfModules.size();
        assertEquals(expectedSize, actualSize);
        BrowserUtil.waitFor(3);
    }
}