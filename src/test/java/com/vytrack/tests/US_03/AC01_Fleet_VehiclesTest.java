package com.vytrack.tests.US_03;

import com.vytrack.pages.FleetPage_ByAteeq;
import com.vytrack.pages.VLoginPage;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.TestBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    AC #1:
    user can select all the cars by checking the first checkbox
        Given user is on the homePage
        When user select “Vehicles” under Fleet module
        And user checks the first checkbox
        Then verify all the checkbox is checked
 */

public class AC01_Fleet_VehiclesTest extends TestBase {

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
        fleetButton.checkAll.click();
        BrowserUtil.waitFor(2);
        assertTrue(fleetButton.checkAll.isSelected());
        BrowserUtil.waitFor(2);
        fleetButton.checkAll.click();


        BrowserUtil.waitFor(2);


    }


}
