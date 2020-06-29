package com.happyreturns.test.Utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestUtilities {
    public static RequestSpecification vRequestSpecfication = null;

    public static Response getResponseWithoutHeader(RequestSpecification reqSpec, String type, Object payload , String endPoint)   {
        Response response = null;

        try {
            if (type.equalsIgnoreCase("get")) {
                response = given().spec(reqSpec).log().all().when().get(endPoint);
            } else if (type.equalsIgnoreCase("post")) {

                response = given().spec(reqSpec).log().all().body(payload).when().post(endPoint);
            } else if (type.equalsIgnoreCase("put")) {

                response = given().spec(reqSpec).log().all().body(payload).when().put(endPoint);
            } else if (type.equalsIgnoreCase("delete")) {

                response = given().spec(reqSpec).log().all().when().delete(endPoint);
            } else {
                System.out.println("Type is not supported");
            }
            response.then().log().all().extract().response();
        }
        catch(Exception e) {
            System.out.println("Unable to extract the response"+" "+e.getMessage());
        }
        return response;
    }


    public static RequestSpecification variantspec() {
        return vRequestSpecfication = new RequestSpecBuilder()
                .setBaseUri("https://happyreturnsqatest.free.beeceptor.com").addHeader("Content-Type", "application/json")
                .build();
    }
}
