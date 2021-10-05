package com.vytrack.pages;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;

public class VerifyDocumentationPage_Aykut {
    public void goTo(){

        Driver.getDriver().get(ConfigurationReader.read("url"));

    }
    
}
