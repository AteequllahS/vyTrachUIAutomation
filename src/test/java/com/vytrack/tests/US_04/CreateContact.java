package com.vytrack.tests.US_04;

import com.github.javafaker.Faker;
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
       createContact.createContacts();
       BrowserUtil.waitFor(3);

       Faker faker = new Faker();
       createContact.firstName.click();
       createContact.firstName.sendKeys(faker.name().firstName());
       BrowserUtil.waitFor(2);
       createContact.lastName.click();
       createContact.lastName.sendKeys(faker.name().lastName());
       createContact.emailBox.click();
       createContact.emailBox.sendKeys("John@email.com");
       createContact.phoneNumber.click();
       createContact.phoneNumber.sendKeys(faker.numerify("### ### ####"));




   }

}
