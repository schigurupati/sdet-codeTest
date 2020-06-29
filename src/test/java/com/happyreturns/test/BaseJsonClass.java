package com.happyreturns.test;

import org.json.JSONObject;



public class BaseJsonClass {

    /**
     In order to run the tests, type the following in the Terminal:
     mvn clean verify -Dtest=JsonTestsIT
     **/

    public String requestBodyTest() {
        JSONObject body = new JSONObject();
        body.put("Test123", 123);
        System.out.println(body.toString());
        return body.toString();
    }


}
