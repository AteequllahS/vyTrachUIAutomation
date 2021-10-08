package com.vytrack.pages;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateVehicleCosts {

    @FindBy(xpath = "//input[@name='custom_entity_type[TotalPrice]']")
    private WebElement totalPrice;

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        getTotalPrice().click();
        getTotalPrice().sendKeys(totalPrice);
    }

    @FindBy(xpath = "//input[@placeholder='Choose a date']")
    private WebElement date;

    public WebElement getDate() {
        return date;
    }

    public void setDate(int date) {
        getDate().click();
        List<WebElement> elements = getDate().findElements(By.xpath("//a[@class='ui-state-default']"));
        //System.out.println("elements.size() = " + elements.size());
        elements.get(date).click();
    }

    @FindBy(xpath = "//textarea[@name='custom_entity_type[CostDescriptions]']")
    private WebElement costDescription;

    public WebElement getCostDescription() {
        return costDescription;
    }

    public void setCostDescription(String description) {
        getCostDescription().click();
        getCostDescription().sendKeys(description);
    }

    @FindBy(xpath = "//span[@class='select2-arrow']")
    //dropdown without select class can't be performed with select class
    private WebElement typeDropdown;

    public WebElement getTypeDropdown() {
        return typeDropdown;
    }

    public void selectOptionDropdown(int option) {
        typeDropdown.click();
        List<WebElement> options = typeDropdown.findElements(By.xpath("//div[@class='select2-result-label']"));
        options.get(option).click();
    }

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    private WebElement saveAndClose;

    public WebElement getSaveAndClose() {
        return saveAndClose;
    }

    @FindBy(css = ".message")
    private WebElement entitySaved;

    public WebElement getEntitySaved() {
        return entitySaved;
    }

    public void entitySavedIsDisplayed(){
        String savedGetText = getEntitySaved().getText();
        String entitySaved = "Entity saved";
        Assertions.assertEquals(savedGetText,entitySaved);
    }





}


