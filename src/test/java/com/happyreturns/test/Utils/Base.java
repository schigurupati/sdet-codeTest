package com.happyreturns.test.Utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

import java.util.ResourceBundle;

public abstract class Base {




    public abstract ResourceBundle getResourceBundle();


    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://happyreturnsqatest.free.beeceptor.com";

        RequestSpecification requestSpecification = new RequestSpecBuilder().
                addHeader("Content-Type", "application/json")
                .build();

        RestAssured.requestSpecification = requestSpecification;
    }






}


