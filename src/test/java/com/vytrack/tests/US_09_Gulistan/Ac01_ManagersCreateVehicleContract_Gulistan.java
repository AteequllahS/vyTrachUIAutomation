package com.vytrack.tests.US_09_Gulistan;

import com.vytrack.pages.CommonPage_Gulistan;
import com.vytrack.pages.VLoginPage;
import com.vytrack.pages.AllVehicleContractPage_Gulistan;
import com.vytrack.pages.VehicleContractPage_Guistan;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class Ac01_ManagersCreateVehicleContract_Gulistan extends TestBase {

    @Test
    public void createContract() {

        VLoginPage vLoginPage = new VLoginPage();
        String username = ConfigurationReader.read("storeManager1");
        String password = ConfigurationReader.read("password");
        vLoginPage.login(username, password);

        CommonPage_Gulistan commonPage = new CommonPage_Gulistan();
        commonPage.navigateToModule("Fleet", "Vehicle Contracts");

        AllVehicleContractPage_Gulistan allVehicleContractPage = new AllVehicleContractPage_Gulistan();
        BrowserUtil.waitFor(5);
        allVehicleContractPage.contractBtn.click();


        VehicleContractPage_Guistan vehicleContractPage = new VehicleContractPage_Guistan();
        vehicleContractPage.fillForm();
        vehicleContractPage.SaveAndCloseBtn.click();

        //Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualMassage = vehicleContractPage.flashMassage.getText();
        Assertions.assertEquals("Entity saved",vehicleContractPage.flashMassage.getText());


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