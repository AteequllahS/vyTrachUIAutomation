package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class VerifyDocumentationPage_Aykut {
    public VerifyDocumentationPage_Aykut() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void goTo() {

        Driver.getDriver().get(ConfigurationReader.read("url"));

    }

    @FindBy(css = ".help.no-hash > i[title='Get help']")
    public WebElement getHelp;

    public void verifyPage() {


        List<String> allUser = new ArrayList<>();
        allUser.add(ConfigurationReader.read("storeManager1"));
        allUser.add(ConfigurationReader.read("storeManager2"));
        allUser.add(ConfigurationReader.read("salesManager1"));
        allUser.add(ConfigurationReader.read("salesManager2"));
        allUser.add(ConfigurationReader.read("salesManager3"));
        allUser.add(ConfigurationReader.read("truckDriver1"));
        allUser.add(ConfigurationReader.read("truckDriver2"));
        allUser.add(ConfigurationReader.read("truckDriver3"));
        String password = ConfigurationReader.read("password");

        for (String eachUser : allUser) {
            VLoginPage vyTrack = new VLoginPage();
            vyTrack.goTo();

            vyTrack.login(eachUser, password);
            BrowserUtil.waitFor(3);
            VerifyDocumentationPage_Aykut verify = new VerifyDocumentationPage_Aykut();
            verify.getHelp.click();
            String expectedTitle = "Dashboard";
            Assertions.assertEquals(expectedTitle, Driver.getDriver().getTitle());
            BrowserUtil.waitFor(2);

            Set<String> allHandles=Driver.getDriver().getWindowHandles();
            allHandles=Driver.getDriver().getWindowHandles();
            for (String eachHandle : allHandles) {

                BrowserUtil.waitFor(2);
                Driver.getDriver().switchTo().window(eachHandle);
                Assertions.assertEquals("Welcome to Oro Documentation",Driver.getDriver().getTitle());
                System.out.println("driver.getTitle() = " + Driver.getDriver().getTitle());
            }
            Driver.closeBrowser();
        }

    }
}