package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyDocumentationPage_Aykut {
    public VerifyDocumentationPage_Aykut(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public void goTo(){

        Driver.getDriver().get(ConfigurationReader.read("url"));

    }
    @FindBy(css = ".help.no-hash > i[title='Get help']")
    public WebElement getHelp;


}
