package com.happyreturns.test.tests;


import com.happyreturns.test.BaseRestAssuredClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredTests {


    @Test
    public void postTest() {
        BaseRestAssuredClass restAssuredClass = new BaseRestAssuredClass();
        Assert.assertEquals(restAssuredClass.postVariants(), "{\n" +
                "    \"status\": \"Awesome!\"\n" +
                "}");
    }
}
