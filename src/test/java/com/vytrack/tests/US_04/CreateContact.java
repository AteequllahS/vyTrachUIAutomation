package com.vytrack.tests.US_04;

import com.github.javafaker.Faker;
import com.vytrack.pages.CreateContact_Yahya;
import com.vytrack.pages.VLoginPage;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CreateContact extends TestBase {

   @Test
   public void createContactTest(){

       // login in as user
       VLoginPage loginPage=new VLoginPage();
       loginPage.goTo();
       loginPage.login(ConfigurationReader.read("truckDriver1"), ConfigurationReader.read("password"));
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
       createContact.faxNumber.click();
       createContact.faxNumber.sendKeys(faker.numerify("### ### ####"));
       createContact.skype.click();
       createContact.skype.sendKeys("@user4");
       createContact.twitter.click();
       createContact.facebook.sendKeys("user4user4");
       createContact.jobTitle.click();
       createContact.jobTitle.sendKeys("SDET");
//       createContact.birthDay.click();
//       createContact.birthDay.sendKeys("2021 Oct 7");
       createContact.gender.click();
       Select gender = new Select(Driver.getDriver().findElement(By.name("oro_contact_form[gender]")));
       gender.selectByIndex(1);
       createContact.primary.click();
       createContact.label.click();
       createContact.label.sendKeys(faker.letterify("### #### #######"));
       createContact.firstName2.click();
       createContact.firstName2.sendKeys(faker.name().firstName());
       createContact.lastName2.click();
       createContact.lastName2.sendKeys(faker.name().lastName());
       createContact.organization.click();
       createContact.organization.sendKeys("VyTrack");
       createContact.country.click();
       createContact.country.sendKeys("United States");
       createContact.street.click();
       createContact.street.sendKeys(faker.address().streetAddress());
       createContact.city.click();
       createContact.city.sendKeys(faker.address().city());
       createContact.state.click();
       createContact.state.sendKeys(faker.address().state());
       createContact.zipCode.click();
       createContact.zipCode.sendKeys(faker.address().zipCode());
       createContact.billing.click();
       createContact.submit.click();



   }

}
