package com.vytrack.pages;

import com.github.javafaker.Faker;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CreateVehicleOdometer_Feruza {
    /**
     * As a user, I should be create Vehicle Odometer.
     *
     * AC #1: drivers are able to create Vehicle Odometer.
     * Given driver is on the homePage
     * When user select “Vehicle Odometer” under Fleet module
     * And user click “Create Vehicle Odometer” button
     * When user fill out general information and click
     * “Save and Close” button Then verify “Entity saved” confirm message
     *
     *
     * AC #2: managers should not to create Vehicle Odometer.
     * Given store/sales manager is on the homePage
     * When user select “Vehicle Odometer” under Fleet module
     * Then verify “You do not have permission to perform this action.” message
     */



    @FindBy(xpath = "//li/a/span[@class='title title-level-1']")
    public WebElement fleetBtn;

    @FindBy(xpath = "//div/ul/li/a/span[.='Vehicle Odometer']")
    public WebElement vehicleOdometer;

    @FindBy(xpath = "//div/a[@title='Create Vehicle Odometer']")
    public WebElement createVehicleOdometer;

    @FindBy(xpath = "(//div/input[@type='text'])[1]")
    public WebElement odometerBox;

    @FindBy(xpath = "(//div/input[@type='text'])[2]")
    public WebElement dataOption;

    @FindBy(xpath = "//div/button[@data-handler='today']")
    public WebElement todayDate;

    @FindBy(xpath = "(//div/input[@type='text'])[3]")
    public WebElement driverBox;

    @FindBy(xpath = "(//div/a/span[@class='select2-chosen'])[1]")
    public WebElement unitOption;

    @FindBy(xpath = "(//li/div[@class='select2-result-label'])[1]")
    public WebElement milesOption;

    @FindBy(xpath = "(//div/a/span[@class='select2-chosen'])[2]")
    public WebElement modelOption;

    @FindBy(xpath = "//div/button[@class='btn btn-medium add-btn']")
    public WebElement addButton;

    @FindBy(xpath = "(//tbody/tr/td/input[@type='checkbox'])[5]")
    public WebElement element_4LicenceNumber;

    @FindBy(xpath = "//div/span/button[@type='button']")
    public WebElement selectBtn;

    @FindBy(xpath = "//div/input[@type='radio']")
    public WebElement radioBoxLicence;

    @FindBy(css = ".action-button.btn.btn-success")
    public WebElement saveBtn;

    @FindBy(className = "message")
    public WebElement flashMessage;


    public CreateVehicleOdometer_Feruza(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void creatingVehicleOdometersByDriver(){

        Actions action=new Actions(Driver.getDriver());
        Faker faker=new Faker();
        BrowserUtil.waitFor(2);

        action.moveToElement(fleetBtn).perform();
        BrowserUtil.waitFor(2);
        action.moveToElement(vehicleOdometer).pause(2000).click().perform();
        BrowserUtil.waitFor(5);
        action.click(createVehicleOdometer).click().perform();
        BrowserUtil.waitFor(2);
        odometerBox.sendKeys(String.valueOf(faker.number().numberBetween(2000,200000) ));
        BrowserUtil.waitFor(2);
        action.click(dataOption).perform();
        BrowserUtil.waitFor(2);
        todayDate.click();
        BrowserUtil.waitFor(2);
        action.click(driverBox).pause(2000).sendKeys(faker.name().fullName()).perform();
        BrowserUtil.waitFor(2);
        action.click(unitOption).perform();
        BrowserUtil.waitFor(2);
        milesOption.click();
        BrowserUtil.waitFor(2);
        action.click(modelOption).pause(2000).sendKeys(faker.expression("Civic")).pause(3000).click().perform();
        BrowserUtil.waitFor(2);
        addButton.click();
        BrowserUtil.waitFor(2);
        element_4LicenceNumber.click();
        BrowserUtil.waitFor(3);

        selectBtn.click();
        BrowserUtil.waitFor(3);

        radioBoxLicence.click();
        BrowserUtil.waitFor(2);

        saveBtn.click();
        BrowserUtil.waitFor(5);


    }



    @FindBy(xpath = "(//li/a/span[@class='title title-level-1'])[2]")
    public WebElement fleet2Btn;


    @FindBy(xpath = "//*[@id='flash-messages']/div/div/div/div")
    public WebElement notPermissionMsg;


   public boolean creatingVehicleOdometerByDriver(){

       boolean result=false;
       Faker faker=new Faker();
       Actions action=new Actions(Driver.getDriver());

          BrowserUtil.waitFor(3);
          action.moveToElement(fleetBtn).pause(2000).perform();
          BrowserUtil.waitFor(2);
          action.moveToElement(vehicleOdometer).click().perform();
          BrowserUtil.waitFor(4);
          createVehicleOdometer.click();
          BrowserUtil.waitFor(2);
          odometerBox.sendKeys("123455678");
          BrowserUtil.waitFor(2);
          dataOption.click();
          BrowserUtil.waitFor(2);
          todayDate.click();
          BrowserUtil.waitFor(2);
          action.click(driverBox).pause(2000).sendKeys(faker.name().fullName()).perform();
          BrowserUtil.waitFor(2);
          addButton.click();
          BrowserUtil.waitFor(2);
          element_4LicenceNumber.click();
          BrowserUtil.waitFor(3);

          selectBtn.click();
          BrowserUtil.waitFor(3);

          radioBoxLicence.click();
          BrowserUtil.waitFor(2);

          saveBtn.click();

         // System.out.println(flashMessage.getText());
         result=flashMessage.isDisplayed();

          BrowserUtil.waitFor(4);


       return  result;


   }




    public boolean creatingVehicleOdometerByManager(){

        BrowserUtil.waitFor(5);
        Actions  action=new Actions(Driver.getDriver());

        action.moveToElement(fleet2Btn).perform();
        BrowserUtil.waitFor(2);
        action.moveToElement(vehicleOdometer).pause(2000).click().perform();
        BrowserUtil.waitFor(3);

        return notPermissionMsg.isDisplayed();


    }








    /**
     * Creating driver credentials method with login, so
     * each time when i need to login as driver  with those credentials
     * I can use that method
     * @return
     */
    public List<String> driversCredentials(){
        List<String> allDrivers=new ArrayList<>();

        allDrivers.add(ConfigurationReader.read("truckDriver1"));
        allDrivers.add(ConfigurationReader.read("truckDriver2"));
        allDrivers.add(ConfigurationReader.read("truckDriver3"));

        return allDrivers;
    }




    /**
     * Creating managers credentials method with login, so
     * each time when i need to login as manager with those credentials
     * I can use that method
     * @return
     */

    public List<String> managersCredentials(){
        List<String> allManagers=new ArrayList<>();

        allManagers.add(ConfigurationReader.read("storeManager1"));
        allManagers.add(ConfigurationReader.read("storeManager2"));
        allManagers.add(ConfigurationReader.read("salesManager1"));
        allManagers.add(ConfigurationReader.read("salesManager2"));
        allManagers.add(ConfigurationReader.read("salesManager3"));

        return allManagers;
    }



}
