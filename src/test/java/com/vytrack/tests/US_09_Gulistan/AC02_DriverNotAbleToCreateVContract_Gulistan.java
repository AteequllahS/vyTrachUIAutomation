package com.vytrack.tests.US_09_Gulistan;

import com.vytrack.pages.CommonPage_Gulistan;
import com.vytrack.pages.VLoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class AC02_DriverNotAbleToCreateVContract_Gulistan extends TestBase {

    @Test
    public void DriverNotCreateContract(){

        VLoginPage vLoginPage = new VLoginPage();
        String username = ConfigurationReader.read("truckDriver1");
        String password = ConfigurationReader.read("password");
        vLoginPage.login(username, password);

        CommonPage_Gulistan commonPage = new CommonPage_Gulistan();
        commonPage.navigateToModule("Fleet", "Vehicle Contracts");

        //Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Assertions.assertEquals("You do not have permission to perform this action.", commonPage.alertMassage.getText());



    }
}
