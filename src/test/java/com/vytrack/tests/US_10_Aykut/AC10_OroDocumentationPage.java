package com.vytrack.tests.US_10_Aykut;

import com.vytrack.pages.VLoginPage;
import com.vytrack.pages.VerifyDocumentationPage_Aykut;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AC10_OroDocumentationPage extends TestBase {

    @Test
    public void verifyPage() {
        VLoginPage vyTrack = new VLoginPage();
        vyTrack.goTo();
        vyTrack.login(ConfigurationReader.read("truckDriver1"), ConfigurationReader.read("password"));
        BrowserUtil.waitFor(3);

        VerifyDocumentationPage_Aykut verify=new VerifyDocumentationPage_Aykut();
        verify.getHelp.click();
        String expectedTitle="Dashboard";
        Assertions.assertEquals(expectedTitle, Driver.getDriver().getTitle());
        BrowserUtil.waitFor(2);
        vyTrack.logOut();
        BrowserUtil.waitFor(2);
    }
}