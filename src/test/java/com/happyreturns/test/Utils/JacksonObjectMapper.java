package com.happyreturns.test.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JacksonObjectMapper {

    Object responseobject;

    /*
     * Input: Response , Class to parse
     * Output returns the class object
     */

    public  Object deserializeJsonResponse(Response res, Class<?> class1)  {
        try {
            //Convert Json Response to a string
            String jsonString = res.asString();

            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            responseobject = objectMapper.readValue(jsonString, class1);

        }
        catch (Exception e) {
            System.out.println("unable to MAP JSON Object"+" "+e);
            //throw new APIException("unable to MAP Json object", e);
        }

        return responseobject;

    }
    public static Object getResponseValue(Response res, String path) {
        //convert raw to String
        try {
            String respon = res.asString();
            //convert String to JSON
            JsonPath json=new JsonPath(respon);
            Object responseVal = json.get(path);
            System.out.println("value of"+" "+path+" "+ "is extracted from response"+" "+responseVal);
            return responseVal;
        }
        catch(Exception e) {
            System.out.println("Unable to extract the response"+" "+e.getMessage());
            return null;
        }

    }


}
