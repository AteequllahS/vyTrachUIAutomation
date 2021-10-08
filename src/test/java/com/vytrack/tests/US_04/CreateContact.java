package com.vytrack.tests.US_04;

import com.vytrack.pages.CreateContact_Yahya;
import com.vytrack.pages.VLoginPage;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.TestBase;
import org.junit.jupiter.api.Test;

public class CreateContact extends TestBase {

   @Test
   public void createContactTest(){

       // login in as user
       VLoginPage loginPage=new VLoginPage();
       loginPage.goTo();
       loginPage.login(ConfigurationReader.read("truckDriver1"),
                        ConfigurationReader.read("password"));
       BrowserUtil.waitFor(2);

       // go to contacts tab
       CreateContact_Yahya createContact = new CreateContact_Yahya();
       createContact.createContact();
       BrowserUtil.waitFor(3);




   }

}
