package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class VLoginPage {

    @FindBy(id = "prependedInput")
    public WebElement username;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(id = "_submit")
    public WebElement loginButton;


    @FindBy(xpath = "//li/a[@class='dropdown-toggle']")
    public WebElement  logoutDropdown;

    @FindBy(xpath = "(//li[@class='last'])[3]") //li/a[.='Logout']
    public WebElement logoutBtn;

    public VLoginPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
        BrowserUtil.waitFor(2);
    }

    public void goTo(){

        Driver.getDriver().get(ConfigurationReader.read("url"));

    }

    public void logOut() {
        logoutDropdown.click();
        BrowserUtil.waitFor(2);
        logoutBtn.click();

    }







}
