package com.vytrack.tests.US_03;

import com.vytrack.pages.FleetPage_ByAteeq;
import com.vytrack.pages.VLoginPage;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    AC #2:
    user can select any car
        Given user is on the homePage
        When user select “Vehicles” under Fleet module
        And user checks any car’s checkbox
        Then verify the checkbox is checked
 */

public class AC02_Fleet_VehiclesTest extends TestBase {

    @Test
    public void fleetTest() {

        VLoginPage vyTrack = new VLoginPage();
        vyTrack.goTo();
        vyTrack.login(ConfigurationReader.read("storeManager1"), ConfigurationReader.read("password"));
        BrowserUtil.waitFor(3);

        FleetPage_ByAteeq fleetButton = new FleetPage_ByAteeq();
        fleetButton.fleet.click();
        BrowserUtil.waitFor(2);
        fleetButton.vehicles.click();
        BrowserUtil.waitFor(4);

        for (int i=1; i <= 25; i++) {
            WebElement checkOneByOne = Driver.getDriver().findElement(By.xpath("(//td/input)["+i+"]"));
            checkOneByOne.click();
            BrowserUtil.waitFor(1);

            assertTrue(checkOneByOne.isSelected());

            checkOneByOne.click();
            BrowserUtil.waitFor(1);
        }

        BrowserUtil.waitFor(2);
    }

}
