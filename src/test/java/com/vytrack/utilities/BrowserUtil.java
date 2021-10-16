package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BrowserUtil {

    public static void waitFor(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //wait until the element is visible method

    public static boolean checkVisibilityOfElement(By locator, int timeToWait) {

        boolean result = false;

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWait);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            result = true;
        } catch (TimeoutException e) {
            System.out.println("THE MESSAGE ELEMENT DID NOT SHOW!");
        }
        return result;
    }

    public static boolean checkVisibilityOfElement(List<WebElement> allVehicles) {

        for (WebElement element : allVehicles) {
            if (!element.isDisplayed()) {
                System.err.println(element.getText() + " is not displayed");
                return false;
            }
        }
        return true;
    }
}