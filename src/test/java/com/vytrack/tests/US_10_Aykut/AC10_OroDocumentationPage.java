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


        VerifyDocumentationPage_Aykut verifyDocumentationPage_aykut=new VerifyDocumentationPage_Aykut();
        verifyDocumentationPage_aykut.verifyPage();




    }
}