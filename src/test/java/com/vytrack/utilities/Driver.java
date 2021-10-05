package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private static WebDriver obj;

    public Driver(){
    }

    public static WebDriver getDriver(){

        String browserName = ConfigurationReader.read("browser");
        if(obj==null){
            switch (browserName.trim().toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    obj = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    obj = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    obj = new SafariDriver();
                    break;
                default:
                    obj = null;
                    System.out.println("UNKNOWN BROWSER TYPE!!!");

            }
            obj.manage().window().maximize();
            return obj;
        }else { //if the object already existed, so does not create one
            return obj;
        }
    }

    //closing browser after test

    public static void closeBrowser(){

        if(obj != null){ // once it quited it cannot be used
            obj.quit();
            obj = null;
        }
    }
}
