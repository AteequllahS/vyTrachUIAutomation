package com.vytrack.tests.US_07_Igor;


import com.vytrack.pages.CreateVehicleCosts;
import com.vytrack.pages.VLoginPage;
import com.vytrack.pages.VyTrack_MainPage;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;



class US07_create_vehicle_cost extends TestBase {


    @Test
    public void createVehicleCost_test()  {
        VLoginPage vyTrack = new VLoginPage();
        vyTrack.goTo();
        vyTrack.login(ConfigurationReader.read("truckDriver1"), ConfigurationReader.read("password"));
        BrowserUtil.waitFor(3);
        VyTrack_MainPage mainPage = PageFactory.initElements(driver,VyTrack_MainPage.class);
        CreateVehicleCosts createVehicleCosts = PageFactory.initElements(driver,CreateVehicleCosts.class);

        mainPage.getFleetModule().click();
        mainPage. getFleetModule_VehicleCost().click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()",mainPage.getCreateVehicleCosts());
        BrowserUtil.waitFor(3);
        createVehicleCosts.selectOptionDropdown(3);
        createVehicleCosts.setTotalPrice("79 000");
        createVehicleCosts.setDate(10);
        createVehicleCosts.setCostDescription("2012 PETERBILT 365");
        createVehicleCosts.getSaveAndClose().click();
        createVehicleCosts.entitySavedIsDisplayed();
        BrowserUtil.waitFor(2);

    }


     /*
    7. Story: As a user, I should be able to create vehicle costs.
 AC #1: users are able to create vehicle costs.
Given user is on the homePage
When user select “Vehicle Costs” under Fleet module
And user click “Create Vehicle Costs” button
When user fill out general information and click “Save and Close” button Then verify “Entity saved” confirm message
     */

       /*
         wait.until(ExpectedConditions.visibilityOf(vehicleCosts.getCreateVehicleCosts()));
         vehicleCosts.getCreateVehicleCosts().click();
         Works with action class, but not with explicit wait
        */

    // Actions actions = new Actions(driver);
    // WebElement element = driver.findElement(By.xpath("//button[@aria-invalid='false']"));
    // jse.executeScript("arguments[0].click()",element);

    // List<WebElement> elements = driver.findElements(By.xpath("//input[@type='checkbox']"));
    // elements.get(10).click();
    //jse.executeScript("arguments[0].click()",)

    //WebDriverWait wait = new WebDriverWait(driver,10);

    /*
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.Wait;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import java.util.List;
    import org.openqa.selenium.NoSuchElementException;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import org.openqa.selenium.By;
     */


}
