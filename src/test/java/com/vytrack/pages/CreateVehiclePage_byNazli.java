package com.vytrack.pages;


import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
import java.util.List;

public class CreateVehiclePage_byNazli {

public CreateVehiclePage_byNazli(){
    PageFactory.initElements(Driver.getDriver(), this);
}

    /**
     * LOGIN-LOGOUT
     */
    @FindBy(css = "input#prependedInput")
    public WebElement userNameField;

    @FindBy(css = "input#prependedInput2")
    public WebElement passwordField;

    @FindBy(css = "button#_submit")
    public WebElement loginButton;

    @FindBy(xpath = "//li/a[@class='dropdown-toggle']")
    public WebElement logoutDropdown;

    @FindBy(xpath = "//li/a[.='Logout']")
    public WebElement logout;

    /**
     *  #AC-1
     */

    @FindBy(css = "li:nth-of-type(2) > .unclickable > .title.title-level-1")
    public WebElement fleet;

    @FindBy(linkText ="Vehicles" )
    public WebElement selectVehicle;


    @FindBy(css = "[class='btn main-group btn-primary pull-right ']")
    public WebElement createCar;

    @FindBy(css = "[data-name='field__license-plate']")
    public WebElement licencePlateBox;
    
    @FindBy(xpath = "//div/input[@type='checkbox'] [1]")
    public List<WebElement> allCheckBoxes;

    @FindBy(css = ".action-button.btn.btn-success")
    public WebElement saveClose;

    @FindBy(className = "message")
    public WebElement toastMessage;

    @FindBy(css = "[name='custom_entity_type[Driver]']")
    public WebElement driverBox;

    @FindBy(css = "[name='custom_entity_type[Location]']")
    public WebElement locationBox;

    @FindBy(css = " [name='custom_entity_type[ChassisNumber]']")
    public WebElement chassisNumberBox;

    @FindBy(css = " [name='custom_entity_type[ModelYear]']")
    public WebElement modelYearBox;

    @FindBy(xpath = "(//div/input[@type='number'])[2]")
    public WebElement lastOdometerBox;

    @FindBy(xpath = "(//div/input[@type='text'])[5]")
    public WebElement immatriculationDateBox;

    @FindBy(xpath = "//div/button[@data-handler='today']")
    public WebElement todayDateOption;

    @FindBy(xpath = "(//div/input[@type='text'])[6]")
    public WebElement firstContractDateBox;

    @FindBy(xpath = "(//div/input[@type='text'])[7]")
    public WebElement catalogValueBox;

    @FindBy(xpath = "(//div/input[@type='number'])[3]")
    public WebElement seatsNumberBox;

    @FindBy(xpath = "(//div/input[@type='number'])[4]")
    public WebElement doorsNumberBox;

    @FindBy(xpath = "(//div/input[@type='text'])[8]")
    public WebElement colorBox;

    @FindBy(xpath = "(//a/span[text()='Choose a value...'])[1]")
    public WebElement transmissionDropDown;

    @FindBy(xpath = "(//li/div[@class='select2-result-label'])[1]")
    public WebElement transmissionOptionManual;

    @FindBy(xpath = "(//li/div[@class='select2-result-label'])[1]")
    public WebElement transmissionOptionAutomatic;

    @FindBy(xpath = "(//a/span[@class='select2-chosen'])[2]")
    public WebElement fuelTypeDropDown;

    @FindBy(xpath = "(//li/div[@class='select2-result-label'])[2]")
    public WebElement fuelTypeDiesel;

    @FindBy(xpath = " (//div/input[@type='text'])[11]")
    public WebElement emissionBox;

    @FindBy(xpath = "(//div/input[@type='number'])[5]")
    public WebElement horsepowerBox;

    @FindBy(xpath = "(//div/input[@type='text'])[12]")
    public WebElement horsepowerTaxationBox;

    @FindBy(xpath = "(//div/input[@type='number'])[6]")
    public WebElement powerBox;

    /**
     *  #AC-2
     */

    @FindBy(xpath = "(//li/a/span[@class='title title-level-1'])[1]")
    public WebElement fleetBtnDriver;

    @FindBy(xpath = "//a/span[@class='title title-level-2']")
    public WebElement vehicleBtnDriver;

    @FindBy(xpath = "//div/a[@title='Create Car']")
    public WebElement createCarBtn;


    public void goVyTrackLoginPage(){
        Driver.getDriver().navigate().to( ConfigurationReader.read("url") );
    }

    public void login(String username, String password ){

        // you can access directly using userNameField or this.userNameField
        this.userNameField.sendKeys(username);
        this.passwordField.sendKeys(password);
        this.loginButton.click();

    }

    public List<String> managersCredentials(){
        List<String> allManagers=new ArrayList<>();

        allManagers.add(ConfigurationReader.read("storeManager1"));
        allManagers.add(ConfigurationReader.read("storeManager2"));
        allManagers.add(ConfigurationReader.read("salesManager1"));
        allManagers.add(ConfigurationReader.read("salesManager2"));
        allManagers.add(ConfigurationReader.read("salesManager3"));

        return allManagers;
    }

    public List<String> driversCredentials(){
        List<String> allDrivers=new ArrayList<>();

        allDrivers.add(ConfigurationReader.read("truckDriver1"));
        allDrivers.add(ConfigurationReader.read("truckDriver2"));
        allDrivers.add(ConfigurationReader.read("truckDriver3"));

        return allDrivers;
    }

    public void logOut() {

        BrowserUtil.checkVisibilityOfElement(By.xpath("//li/a[@class='dropdown-toggle']"),10);
        logoutDropdown.click();
        BrowserUtil.waitFor(2);

        logout.click();



    }

    public String createVehicle(){

        BrowserUtil.waitFor(3);
        fleet.click();
        selectVehicle.click();
        BrowserUtil.waitFor(6);
        createCar.click();
        BrowserUtil.waitFor(3);


        licencePlateBox.sendKeys("David Smith");
        allCheckBoxes.get(0).click();
        driverBox.sendKeys("E5-789-23");
        BrowserUtil.waitFor(3);
        locationBox.sendKeys("2335 W Golden Hills Rd, Tucson, AZ 85745");
        chassisNumberBox.sendKeys("98765432");
        modelYearBox.sendKeys("2021");
        BrowserUtil.waitFor(2);
        lastOdometerBox.sendKeys("78430");
        BrowserUtil.waitFor(2);
        immatriculationDateBox.click();
        BrowserUtil.waitFor(2);
        todayDateOption.click();
        BrowserUtil.waitFor(2);
        firstContractDateBox.click();
        BrowserUtil.waitFor(2);
        todayDateOption.click();
        BrowserUtil.waitFor(2);
        catalogValueBox.sendKeys("1596214");
        BrowserUtil.waitFor(2);
        seatsNumberBox.sendKeys("2");
        BrowserUtil.waitFor(2);
        doorsNumberBox.sendKeys("4");
        colorBox.sendKeys("gold");
        transmissionDropDown.click();
        BrowserUtil.waitFor(2);
        transmissionOptionManual.click();
        BrowserUtil.waitFor(2);
        fuelTypeDropDown.click();
        BrowserUtil.waitFor(2);
        fuelTypeDiesel.click();
        BrowserUtil.waitFor(2);
        emissionBox.sendKeys("2596374");
        BrowserUtil.waitFor(2);
        horsepowerBox.sendKeys("963852");
        BrowserUtil.waitFor(2);
        horsepowerTaxationBox.sendKeys("359178");
        BrowserUtil.waitFor(2);
        powerBox.sendKeys("24963178");
        BrowserUtil.waitFor(2);
        saveClose.click();
        BrowserUtil.waitFor(2);

      return toastMessage.getText() ;

    }


    public boolean displayCreateVehicleButton() {

        boolean result=false;

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(fleetBtnDriver).pause(2000).perform();
        BrowserUtil.waitFor(2);

        action.moveToElement(vehicleBtnDriver).pause(2000).click().perform();


          try {
            createCarBtn.isDisplayed();
            result = true;

           } catch (RuntimeException e) {
              //  e.printStackTrace();
              System.out.println("\"Create Car\" button is NOT FOUND "+e.getMessage());

           }

       return result;
    }

}
