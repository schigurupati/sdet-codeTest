package com.happyreturns.test.HappyReturnsFlow;

import com.happyreturns.test.DriverBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class SearchAT extends DriverBase {

    /**
     *  CHALLENGE :
     *  For our challenge, we need to create a Selenium test that navigates to Google.com
     *  and performs a search for "Happy Returns".
     *
     *  After the results are displayed, assert that www.happyreturns.com is the first result
     *  returned from Google.
     *
     *  Notes : Feel free to create classes, rename this class, approach this challenge however you'd like.
     *  Keep it simple or get fancy with it if you have time.
     *
     *  Time: 30 minutes
     *
     *
     * If any errors appear in module settings use module 8 for lambdas and java 8 features for arrays
     * and also in the target under java compiler use 1.8 instead of 5 this will solve the issues
     **/



    public static Boolean searchGoogle() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver dr = new ChromeDriver();
        dr.get("https://google.com");


        WebElement searchButton = dr.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
        searchButton.sendKeys("Happy Returns" + Keys.ENTER);

        List<WebElement> links = new ArrayList<>();
        links = dr.findElements(By.xpath("//cite"));
        String expected = "www.happyreturns.com/";
        String actualLink = links.get(0).getText().toString();
        System.out.println("actualLink = " + actualLink);

        if (expected.contains(actualLink)) {
            return true;

        } else {
            return false;
        }

    }

    public static void main(String[] args) throws Exception {

        searchGoogle();

    }
}

