package com.happyreturns.test;

import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.json.Json;
import com.google.gson.*;
import org.json.simple.*;

import static io.restassured.RestAssured.*;

public class BaseRestAssuredClass {

    private static final String baseuri = "https://happyreturnsqatest.free.beeceptor.com/";

    /**
     * --------======= CHALLENGE NOTES =======---------
     *
     * Per the test, please do the following:
     * 1. Write a method that performs a GET to the endpoint:  https://happyreturnsqatest.free.beeceptor.com/getProductVariants
     * 2. Map a variant object from the variants array from the GET in Step #1 to an object using any JSON library, ie: json-simple, Gson, Jackson, etc.
     * 3. Modify the "weight" field for the variant from 1.25 to 5.
     * 3. Perform a POST with the modified the object from Step #3 to the following endpoint: https://happyreturnsqatest.free.beeceptor.com/order
     *
     * Helpful hints:
     * A couple of example methods have been declared for you.
     * The postVariants() method is a good example of how you should build your REST calls.
     *
     */


    public String getVariants() {
        return null;
    }

    public String postVariants() {
        return with()
                .baseUri(baseuri)
                .header("Content-Type", "application/json")
                .when()
                .body("< !! PUT YOUR REQUEST BODY HERE !! >")
                .request("POST", "order")
                .then()
                .extract()
                .body().jsonPath().prettyPrint();
    }
}
