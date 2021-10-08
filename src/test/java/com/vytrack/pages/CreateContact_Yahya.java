package com.vytrack.pages;

import com.github.javafaker.Faker;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContact_Yahya {
    /**
     * AC #1: users are able to create contacts.
     * Given user is on the homePage
     * When user select “Contacts” under Customers module
     * And user click “Create Contact” button
     * When user fill out general information
     * And click “Save and Close” button
     * Then verify “contact saved” confirm message
     * */

    @FindBy(id = "prependedInput")
    public WebElement userNameField;

    @FindBy(id = "prependedInput2")
    public WebElement passwordField;

    @FindBy(id = "submit")
    public WebElement loginButton;


    @FindBy(xpath = "(//span[normalize-space(.)='Customers'])")
    public WebElement customersBtn;

    @FindBy(xpath = "//div/ul/li/a/span[.='Contacts']")
    public WebElement contacts;

    @FindBy(xpath = "(//a[normalize-space(.)='Create Contact'])")
    public WebElement createContactBtn;


    // elements for form
    @FindBy(name = "oro_contact_form[firstName]")
    public WebElement firstName;
    @FindBy(name = "oro_contact_form[lastName]")
    public WebElement lastName;
    @FindBy(name = "oro_contact_form[emails][0][email]")
    public WebElement emailBox;
    @FindBy(name = "oro_contact_form[phones][0][phone]")
    public WebElement phoneNumber;


    public CreateContact_Yahya(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void createContacts(){

        customersBtn.click();
        BrowserUtil.waitFor(2);
        contacts.click();
        BrowserUtil.waitFor(2);
        createContactBtn.click();
        BrowserUtil.waitFor(2);

    }
}
