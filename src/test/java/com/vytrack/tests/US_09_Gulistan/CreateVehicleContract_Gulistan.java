package com.vytrack.tests.US_09_Gulistan;

import com.vytrack.pages.*;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateVehicleContract_Gulistan extends TestBase {

    @Test
    public void managerCreateContract() {

        CreateVehiclePage_byNazli createVehiclePage = new CreateVehiclePage_byNazli();

        for (String manager : createVehiclePage.managersCredentials()) {

            VLoginPage vLoginPage = new VLoginPage();
            String username = manager;
            String password = ConfigurationReader.read("password");
            vLoginPage.login(username, password);

            CommonPage_Gulistan commonPage = new CommonPage_Gulistan();
            commonPage.navigateToModule("Fleet", "Vehicle Contracts");


            AllVehicleContractPage_Gulistan allVehicleContractPage = new AllVehicleContractPage_Gulistan();
            BrowserUtil.waitFor(5);
            allVehicleContractPage.contractBtn.click();


            VehicleContractPage_Gulistan vehicleContractPage = new VehicleContractPage_Gulistan();
            //vehicleContractPage.chooseCalenderDate();
            vehicleContractPage.fillForm();
            vehicleContractPage.SaveAndCloseBtn.click();

            //Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String actualMassage = vehicleContractPage.flashMassage.getText();
            Assertions.assertEquals("Entity saved",vehicleContractPage.flashMassage.getText());

            createVehiclePage.logOut();
        }
    }






    @Test
    public void driverNotCreateContract(){

        CreateVehiclePage_byNazli createVehiclePage = new CreateVehiclePage_byNazli();

        for (String driver : createVehiclePage.driversCredentials()) {

            VLoginPage vLoginPage = new VLoginPage();
            String username = ConfigurationReader.read("truckDriver1");
            String password = ConfigurationReader.read("password");
            vLoginPage.login(username, password);

            CommonPage_Gulistan commonPage = new CommonPage_Gulistan();
            commonPage.navigateToModule("Fleet", "Vehicle Contracts");

            //Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            Assertions.assertEquals("You do not have permission to perform this action.", commonPage.alertMassage.getText());
            createVehiclePage.logOut();
        }




    }
}







/*
9. Story: As a user, I should be create Vehicle Contract. AC #1: managers are able to Create Vehicle Contract.
        Given store/sales manager is on the homePage
        When user select “Vehicle Contract” under Fleet module
        And user click “Create Vehicle Contract” button
        When user fill out general information and click “Save and Close” button
        Then verify “Entity saved” confirm message

 */