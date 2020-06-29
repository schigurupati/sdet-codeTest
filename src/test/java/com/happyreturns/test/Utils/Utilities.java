package com.happyreturns.test.Utils;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Utility class is used for helpers level methods for testing.
 *
 */
public class Utilities {

    private static WebDriver driver;





    /**
     * Method to verify page url.
     * Passing expected url (by String).
     * Method utilizes Utilities common method (compareActualWithExpected). Actual Url defined in the method (no passing parameter). Method utilized at Message Center page.
     */
    public static void VerifyPageURL(WebDriver driver, String expected_Url) {
        String actualUrl = driver.getCurrentUrl();//get actual Url command
        Assert.assertEquals(expected_Url, actualUrl); System.out.print("Landed URL is as expected");
    }




    /**
     * Method to maximize browser window.
     * No parameters passed, except Webdriver driver.
     */
    public static void MaximizeBrowserWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    /**
     * Method to get page url.
     * Passing driver.
     * return String.
     */
    public static String GetPageURL(WebDriver driver) {
        String actualUrl = driver.getCurrentUrl();//get actual Url command
        return actualUrl;
    }
    public static String BuildUrlAllEnvironments(WebDriver driver)
    {
        String finalUrl;
        finalUrl = "https://google.com";
        System.out.print("Navigation to " + finalUrl + "\n");
        return finalUrl;
    }

 }





