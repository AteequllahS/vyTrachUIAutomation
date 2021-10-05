package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FleetPage {

    @FindBy(xpath = "(//span[normalize-space(.)='Fleet'])[1]")
    public WebElement fleet;

    @FindBy(xpath = "(//span[.='Vehicles'])")
    public WebElement vehicles;

    @FindBy(xpath = "//button/input")
    public WebElement checkAll;

    @FindBy(xpath = "(//td/input)")// add index[] at the end to have access one by one.
    public WebElement singleCheck;

    public FleetPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
