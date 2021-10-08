package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VyTrack_MainPage {



    @FindBy (css = "a[title='Create Vehicle Costs']")
    private WebElement createVehicleCosts;

    public WebElement getCreateVehicleCosts() {
        return createVehicleCosts;
    }

    @FindBy(xpath = "(//li[@class='dropdown dropdown-level-1'])[1]")
    private WebElement fleetModule;

    public WebElement getFleetModule() {
        return fleetModule;
    }


    @FindBy(xpath = "//span[normalize-space()='Vehicle Costs']")
    private WebElement fleetModule_VehicleCost;

    public WebElement getFleetModule_VehicleCost() {
        return fleetModule_VehicleCost;
    }
}
