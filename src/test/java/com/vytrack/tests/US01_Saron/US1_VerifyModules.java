package com.vytrack.tests.US01_Saron;

import com.vytrack.pages.VLoginPage;
import com.vytrack.pages.Verify_Modules;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.TestBase;
import org.junit.jupiter.api.Test;

public class US1_VerifyModules extends TestBase {

    @Test
    public void verifyModules(){
        // login in as user
        VLoginPage loginPage=new VLoginPage();
        loginPage.goTo();
        loginPage.login(ConfigurationReader.read("truckDriver1"), ConfigurationReader.read("password"));
        BrowserUtil.waitFor(2);

        Verify_Modules verify_modules = new Verify_Modules();
        verify_modules.verifyModules();
    }

    @Test
    public void verifyModulesForStoreManager(){
        VLoginPage loginPage=new VLoginPage();
        loginPage.goTo();
        loginPage.login(ConfigurationReader.read("storeManager1"), ConfigurationReader.read("password"));
        BrowserUtil.waitFor(2);

        Verify_Modules verify_modules = new Verify_Modules();
        verify_modules.verifyModulesTwo();
    }
}
