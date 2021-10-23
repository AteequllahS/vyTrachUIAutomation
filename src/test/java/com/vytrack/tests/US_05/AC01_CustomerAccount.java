package com.vytrack.tests.US_05;

import com.vytrack.pages.Customer_AccountPage_ByAteeq;
import com.vytrack.pages.VLoginPage;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AC01_CustomerAccount extends TestBase {

    @Test
    public void CustomerAccountTest() {

        VLoginPage loginPage = new VLoginPage();
        loginPage.goTo();
        loginPage.login(ConfigurationReader.read("storeManager2"), ConfigurationReader.read("password"));

        loginPage.loginButton.click();
        BrowserUtil.waitFor(7);


            WebElement customerBtn = driver.findElement(By.xpath("(//span[contains(text(),'Customers')])[1]"));
            WebElement accountBtn = driver.findElement(By.xpath("//span[.='Accounts'][@class='title title-level-2']"));

            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(customerBtn).pause(2000).click().perform();
            actions.moveToElement(accountBtn).pause(2000).click().perform();


        Customer_AccountPage_ByAteeq customerAcc = new Customer_AccountPage_ByAteeq();

        BrowserUtil.waitFor(2);
        customerAcc.checkAllAccounts.click();
        assertTrue(customerAcc.checkAllAccounts.isSelected());
        BrowserUtil.waitFor(1);
        customerAcc.checkAllAccounts.click();


        for (int i = 1; i <= 3; i++) {

            Driver.getDriver().findElement(By.xpath("//td/input[@type='checkbox']["+i+"]")).click();
            assertTrue(customerAcc.singleCheckAccount.isSelected());
            BrowserUtil.waitFor(1);
            customerAcc.singleCheckAccount.click();
            BrowserUtil.waitFor(1);
        }

          System.out.println("TEST FOR CUSTOMER ACCOUNT COMPLETED.");

    }
}
