package com.vytrack.tests.US_08_Feruza;

import com.vytrack.pages.CreateVehicleOdometer_Feruza;
import com.vytrack.pages.VLoginPage;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.TestBase;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CreateVehicleOdometer extends TestBase {

        /**
         * As a user, I should be create Vehicle Odometer.
         */

    @Test
    public void testCreateVehicleOdometerByDriver(){
         /**AC #1: drivers are able to create Vehicle Odometer.
          * Given driver is on the homePage
          * When user select “Vehicle Odometer” under Fleet module
          * And user click “Create Vehicle Odometer” button
          * When user fill out general information and click
          * “Save and Close” button Then verify “Entity saved” confirm message
         */

        VLoginPage loginPage=new VLoginPage();
        loginPage.goTo();
        BrowserUtil.waitFor(2);
        String password= ConfigurationReader.read("password");
        CreateVehicleOdometer_Feruza createOdometer=new CreateVehicleOdometer_Feruza();

        for(String eachUsername: createOdometer.driversCredentials()) {
            loginPage.login(eachUsername, password);
            assertTrue(createOdometer.creatingVehicleOdometerByDriver() );

            loginPage.logOut();
        }


    }


    @Test
    public void testCreateVehicleOdometerByManager(){
        /**
         *  AC #2: managers should not to create Vehicle Odometer.
         *  Given store/sales manager is on the homePage
         *  When user select “Vehicle Odometer” under Fleet module
         *  Then verify “You do not have permission to perform this action.” message
         *
         */

        VLoginPage loginPage=new VLoginPage();
        loginPage.goTo();
        BrowserUtil.waitFor(2);
        String password= ConfigurationReader.read("password");
        CreateVehicleOdometer_Feruza createOdometer=new CreateVehicleOdometer_Feruza();

        for(String eachUsername: createOdometer.managersCredentials()) {
            loginPage.login(eachUsername, password);
            assertTrue(createOdometer.creatingVehicleOdometerByManager() );

            loginPage.logOut();
        }
    }


}
