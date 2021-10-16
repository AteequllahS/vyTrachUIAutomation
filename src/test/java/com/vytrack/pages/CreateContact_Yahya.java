package com.vytrack.pages;

import com.github.javafaker.Faker;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
    @FindBy(name = "oro_contact_form[fax]")
    public WebElement faxNumber;
    @FindBy(name = "oro_contact_form[skype]")
    public WebElement skype;
    @FindBy(name = "oro_contact_form[twitter]")
    public WebElement twitter;
    @FindBy(name = "oro_contact_form[facebook]")
    public WebElement facebook;
    @FindBy(name = "oro_contact_form[jobTitle]")
    public WebElement jobTitle;
    // 2021 Oct 7
//    @FindBy(name = "date_selector_oro_contact_form_birthday-uid-615fcf57a04a2")
//    public WebElement birthDay;
    @FindBy(name = "oro_contact_form[gender]")
    public WebElement gender;
    @FindBy(name = "oro_contact_form[addresses][0][primary]")
    public WebElement primary;

    // Address info
    @FindBy(name = "oro_contact_form[addresses][0][label]")
    public WebElement label;
    @FindBy(name = "oro_contact_form[addresses][0][firstName]")
    public WebElement firstName2;
    @FindBy(name = "oro_contact_form[addresses][0][lastName]")
    public WebElement lastName2;
    @FindBy(name = "oro_contact_form[addresses][0][organization]")
    public WebElement organization;
    @FindBy(xpath = "//span[text()='Choose a country...']")
    public WebElement country;
    @FindBy(name = "oro_contact_form[addresses][0][street]")
    public WebElement street;
    @FindBy(name = "oro_contact_form[addresses][0][city]")
    public WebElement city;
    @FindBy(xpath = "//span[text()='Choose a state...']")
    public WebElement state;
    @FindBy(name = "oro_contact_form[addresses][0][postalCode]")
    public WebElement zipCode;
    @FindBy(name = "oro_contact_form[addresses][0][types][]")
    public WebElement billing;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

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

        Faker faker = new Faker();
        firstName.click();
        firstName.sendKeys(faker.name().firstName());
        BrowserUtil.waitFor(2);
        lastName.click();
        lastName.sendKeys(faker.name().lastName());
        emailBox.click();
        emailBox.sendKeys("John@email.com");
        phoneNumber.click();
        phoneNumber.sendKeys(faker.numerify("### ### ####"));
        faxNumber.click();
        faxNumber.sendKeys(faker.numerify("### ### ####"));
        skype.click();
        skype.sendKeys("@user4");
        twitter.click();
        facebook.sendKeys("user4user4");
        jobTitle.click();
        jobTitle.sendKeys("SDET");
        gender.click();
        Select gender = new Select(Driver.getDriver().findElement(By.name("oro_contact_form[gender]")));
        gender.selectByIndex(1);
        primary.click();
        label.click();
        label.sendKeys(faker.letterify("LABEL1234"));
        firstName2.click();
        firstName2.sendKeys(faker.name().firstName());
        lastName2.click();
        lastName2.sendKeys(faker.name().lastName());
        organization.click();
        organization.sendKeys("VyTrack");
        country.click();
        //Select country = new Select(Driver.getDriver().findElement(By.xpath("//span[text()='Choose a country...']")));
        WebElement country1 = new Driver().getDriver().findElement(By.xpath("//div[text()='United States']"));
        country1.click();
        street.click();
        street.sendKeys(faker.address().streetAddress());
        city.click();
        city.sendKeys(faker.address().city());
        state.click();
        WebElement state1 = new Driver().getDriver().findElement(By.xpath("//li/div[text()='Washington']"));
        state1.click();
        zipCode.click();
        zipCode.sendKeys(faker.address().zipCode());
        billing.click();
        submit.click();

    }
}
