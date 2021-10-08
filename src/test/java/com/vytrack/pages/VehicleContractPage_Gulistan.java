package com.vytrack.pages;

import com.github.javafaker.Faker;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VehicleContractPage_Gulistan {

    public VehicleContractPage_Gulistan(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//div/button[@type=\"submit\"]")
    public WebElement SaveAndCloseBtn;

    @FindBy(xpath = "(//span[@class='select2-arrow'])[1]")
    public WebElement TypeArrow;

    @FindBy(xpath = "(//span[@class='select2-arrow'])[2]")
    public WebElement ChooseAValueArrow;

    @FindBy(xpath = "(//span[@class='select2-arrow'])[3]")
    public WebElement ActiveArrow;

    @FindBy(xpath = "//ul[@class = 'select2-results']/li[1]")
    public WebElement typeDropDownOptions;

    @FindBy(xpath = "//div/input[contains(@id,'custom_entity_type_Responsible-uid-')]")
    public WebElement responsibleBox;

    @FindBy(xpath = "//div/input[contains(@id,'custom_entity_type_ActivationCost-uid-')]")
    public WebElement activationCostBox;

    @FindBy(xpath ="//div/input[contains(@id,'custom_entity_type_RecurringCostAmount-uid-')]")
    public WebElement recurringCostAmountBox;

    @FindBy(xpath="//div/input[contains(@id,'custom_entity_type_OdometerDetails-uid-')]")
    public WebElement odometerDetailsBox;

    @FindBy(xpath="//div/input[contains(@id,'custom_entity_type_Vendor-uid-')]")
    public WebElement vendorBox;

    @FindBy(xpath="//div/input[contains(@id,'custom_entity_type_Driver-uid-')]")
    public WebElement driverBox;

    @FindBy(xpath="//div/input[contains(@id,'custom_entity_type_ContractReference-uid-')]")
    public WebElement contractReferenceBox;

    @FindBy(xpath="//div/textarea[contains(@id,'custom_entity_type_TermsandConditions-uid-')]")
    public WebElement termsAndConditionsBox;

    @FindBy(xpath = "//input[contains(@id,'date_selector_custom_entity_type_InoviceDate-uid-')]")
    public WebElement invoiceDateCal;

    @FindBy(xpath = "//input[contains(@id,'date_selector_custom_entity_type_ContractStartDate-uid-')]")
    public WebElement contractStartDate;

    @FindBy(xpath = "//input[contains(@id,'date_selector_custom_entity_type_ContractExpirationDate-uid-')]")
    public WebElement contractExpirationDate;

    @FindBy(xpath = "//div/select[@class='ui-datepicker-month']")
    public WebElement monthPicker;

    @FindBy(xpath = "//div/select[@class='ui-datepicker-year']")
    public WebElement yearPicker;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement flashMassage;

    @FindBy(xpath = "//input[contains(@id,'date_selector_custom_entity_type')]")
    public List<WebElement> calenderList;


    public void chooseCalenderDate(){

        calenderList.addAll(calenderList);
        for (int i = 0; i < calenderList.size(); i++) {
            if(i == 0){
                invoiceDateCal.click();
            }else if(i == 1){
                contractStartDate.click();
            }else {
                contractExpirationDate.click();
            }
            BrowserUtil.waitFor(1);
            monthPicker.click();
            Select month = new Select(monthPicker);
            List<WebElement> monthsOptions = Driver.getDriver().findElements(By.xpath("//div/select[@class='ui-datepicker-month']/option"));
            BrowserUtil.waitFor(1);
            monthsOptions.get((int)(Math.random()*12)).click();
            BrowserUtil.waitFor(1);
            Select year = new Select(yearPicker);
            List<WebElement> yearOptions = Driver.getDriver().findElements(By.xpath("//div/select[@class='ui-datepicker-year']/option"));
            BrowserUtil.waitFor(1);
            yearOptions.get((int)(Math.random()*82)).click();

            List<WebElement> days = Driver.getDriver().findElements(By.xpath("//tr/td[@data-handler='selectDay']"));
            if(days.size() == 31){
                days.get((int)(Math.random()*30)).click();
            }else if(days.size() == 30){
                days.get((int)(Math.random()*29)).click();
            }else if(days.size() == 28){
                days.get((int)(Math.random()*27)).click();
            }else{
                days.get((int)(Math.random()*28)).click();
            }

        }



    }


    @FindBy(xpath = "//select[contains(@id, 'custom_entity_type_Type-uid-')]")
    public WebElement dropdownElement;

    public void paymentType(){
        BrowserUtil.waitForClickablility(By.xpath("(//span[@class='select2-arrow'])[1]"),8);
        TypeArrow.click();
        BrowserUtil.waitFor(2);
        Select paymentDropDown = new Select(dropdownElement);
        BrowserUtil.waitFor(2);
        List<WebElement> options = Driver.getDriver().findElements(By.xpath("//select[contains(@id, 'custom_entity_type_Type-uid-')]/option"));
        options.get((int)(Math.random()*4)).click();

    }

    public void chooseCostAmount(){
        ChooseAValueArrow.click();
        List<WebElement> costOptions = Driver.getDriver().findElements(By.xpath("//ul[@class='select2-results']/li"));
        costOptions.get((int)(Math.random()*5)).click();

    }

    public void chooseStatus(){
        ActiveArrow.click();
        List<WebElement> status =  Driver.getDriver().findElements(By.xpath("//ul[@class='select2-results']/li/div"));
        status.get((int)(Math.random()*2)).click();
    }

    public void invoiceDate(){

    }


    public void fillForm() {

        Faker faker = new Faker();
        paymentType();

        responsibleBox.sendKeys(faker.company().name());
        activationCostBox.sendKeys(String.valueOf(faker.number().numberBetween(100,400)));
        recurringCostAmountBox.sendKeys(String.valueOf(faker.number().numberBetween(400,4000)));
        chooseCostAmount();
        odometerDetailsBox.sendKeys(String.valueOf(faker.number().numberBetween(200,500)));
        chooseCalenderDate();
        vendorBox.sendKeys("VyTrack");
        driverBox.sendKeys(faker.name().fullName());
        contractReferenceBox.sendKeys(faker.company().name());
        termsAndConditionsBox.sendKeys(faker.toString());
        BrowserUtil.waitFor(2);
        chooseStatus();
    }
}
