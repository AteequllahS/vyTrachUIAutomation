package com.vytrack.pages;

import com.github.javafaker.Faker;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllVehicleContractPage_Gulistan {


//   @FindBy(xpath = "//div/a[normalize-space(.)='Create Vehicle Contract']")
//   public WebElement contractBtn;

public AllVehicleContractPage_Gulistan(){
    PageFactory.initElements(Driver.getDriver(),this);
}

@FindBy(xpath = "//div/a[normalize-space(.)='Create Vehicle Contract']")
    public WebElement contractBtn;

//public void contractBtn(){
//    Driver.getDriver().findElement(By.xpath("//div/a[normalize-space(.)='Create Vehicle Contract']")).click();
//
//}



}





