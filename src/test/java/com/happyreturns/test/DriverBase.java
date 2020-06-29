package com.happyreturns.test;


import com.happyreturns.test.config.DriverFactory;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverBase {

    private static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<DriverFactory>());
    private static ThreadLocal<DriverFactory> driverFactoryThread;

    @BeforeSuite(alwaysRun = true)
    public static void instantiateDriverObject() {
        System.out.println("\n\n\n\n========================================================\n\nINFO: Starting test run!!\n\n========================================================\n\n\n\n");
        driverFactoryThread = ThreadLocal.withInitial(() -> {
            DriverFactory driverFactory = new DriverFactory();
            webDriverThreadPool.add(driverFactory);
            return driverFactory;
        });
    }


    public static RemoteWebDriver getDriver() throws Exception {
        return driverFactoryThread.get().getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public static void clearCookies() {
        try {
            driverFactoryThread.get().getStoredDriver().manage().deleteAllCookies();
        } catch (Exception ignored) {
            System.out.println("Unable to clear cookies, driver object is not viable...");
        }
    }

    @AfterMethod(alwaysRun = true)
    public static void closeDriverObjects() {
        for (DriverFactory driverFactory : webDriverThreadPool) {
            driverFactory.quitDriver();
        }
        System.out.println("\n\n\n\n========================================================\n\nINFO: Test complete!!\n\n========================================================\n\n\n\n");
    }

    @AfterSuite(alwaysRun = true)
    public static void endTest() {
        System.out.println("\n\n\n\n========================================================\n\nINFO: Test run finished!!\nINFO : Results are in /target/surefire-reports/index.html\n\n========================================================\n\n\n\n");

    }
}