package com.happyreturns.test.tests;

import com.happyreturns.test.BaseJsonClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JsonTests {


    @Test
    public void assertRequestBody() {
        BaseJsonClass baseJsonClass = new BaseJsonClass();
        Assert.assertEquals(baseJsonClass.requestBodyTest(), "{\"order\":{\"line_items\":[{\"variant_id\":447654529,\"quantity\":1}]}}");
    }
}
