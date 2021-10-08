package com.vytrack.tests.US_02_byNazli;

import com.vytrack.pages.CreateVehiclePage_byNazli;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserStory2_CreateVehiclesPOM extends TestBase {

    /**
     * AC #1: only store/sales manager able to create car
     * Given store/sales manager is on the homePage
     * When user select “Vehicles” under Fleet module
     * And user click “create car” button
     * When user fill out general information
     * And click “Save and Close” button
     *
     * Then verify “Entity saved” confirm message
     */


    @Test
    public void testCreateVehicles() {

        CreateVehiclePage_byNazli managers = new CreateVehiclePage_byNazli();
        managers.goVyTrackLoginPage();

        String password = ConfigurationReader.read("password");

        for (String eachManagerCredential : managers.managersCredentials()) {
            BrowserUtil.waitFor(2);
            managers.login(eachManagerCredential, password);
            BrowserUtil.waitFor(2);

            String expectedResult = "Entity saved";
            Assertions.assertEquals(expectedResult,managers.createVehicle());
            BrowserUtil.waitFor(2);
            managers.logOut();

        }

    }

    /**
     * AC #2: drivers should not able to create a car
     * Given driver is on the homePage
     * When user select “Vehicles” under Fleet module
     *
     * Then “create car” button should not be visible
     */


    @Test
    public void testDriversShouldNotAbleToCreateACar() {

        CreateVehiclePage_byNazli drivers = new CreateVehiclePage_byNazli();
        drivers.goVyTrackLoginPage();
        BrowserUtil.waitFor(2);

        String password = ConfigurationReader.read("password");

        for (String eachDriverCredential : drivers.driversCredentials()) {
            BrowserUtil.waitFor(2);
            drivers.login(eachDriverCredential, password);
            BrowserUtil.waitFor(2);

            BrowserUtil.waitFor(2);
            Assertions.assertFalse(drivers.displayCreateVehicleButton());

            BrowserUtil.waitFor(2);
            drivers.logOut();
            System.out.println("========================================");

        }

    }


}
