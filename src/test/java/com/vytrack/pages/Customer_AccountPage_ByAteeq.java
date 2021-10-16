package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customer_AccountPage_ByAteeq {

    @FindBy(xpath = "(//span[normalize-space(.)='Customers'])[1]")
    public WebElement customers;

    @FindBy(xpath = "//span[.='Accounts'][@class='title title-level-2']")
    public WebElement Accounts;//span[.='Accounts'][@class='title title-level-2']

    @FindBy(xpath = "//button/input[@type='checkbox']")
    public WebElement checkAllAccounts;

    @FindBy(xpath = "//td/input[@type='checkbox']") // add index
    public WebElement singleCheckAccount;

    public Customer_AccountPage_ByAteeq(){

        PageFactory.initElements(Driver.getDriver(), this);

    }


}
