package com.happyreturns.test.HappyReturnsFlow;

import com.google.gson.Gson;
import com.happyreturns.test.Utils.*;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.ResourceBundle;
import static java.util.ResourceBundle.getBundle;

import java.util.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static java.util.ResourceBundle.getBundle;

import java.util.ResourceBundle;

import static java.util.ResourceBundle.getBundle;

/** * If any errors appear in module settings use module 8 for lamdas and java 8 features for arrays
        * and also in the target under java compiler use 1.8 instead of 5 this will solve the issues
 *
 * Verified the response for 201 code
        **/


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
 * For now Have added the Tests they can be run as it is but need to add the **AT files to the TestNG.xml
 *  *
 *      * If any errors appear in module settings use module 8 for lamdas and java 8 features for arrays
 *      * and also in the target under java compiler use 1.8 instead of 5 this will solve the issues
 *      The tests can be run by right clicking and Running the tests
 *      Can Map the Response payload to a hashmap but due to lack of time i am just using the restassured built in functionality to pass it
 *      I was having issues with the hashmap to include the nested List presentment_prices so avoided using storing the payload in a hashmap
 *
 *  NOTE:I am not sure why Even after changing the Weight it is not changing it is still giving 1.25 only might be
 *  I have not casted boolean for weight properly but the Response for Post Orders is giving 201 created.
 *
 *
 *  **/


public class HappyReturnsAT extends Base {

    private final ResourceBundle resourceBundle;
    private final String baseUri;

    public HappyReturnsAT() {

        resourceBundle = getBundle("TestData");
        baseUri = this.getResourceBundle().getString("baseUri");
    }

    @Override
    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public String getbaseUri() {
        return baseUri;
    }

    @BeforeClass
    public void getProperties() throws Exception {
        PropertiesManager.initializeProperties();
        //PropertiesManager.getProperty("consentBaseUri");

    }

    protected Gson gson = new Gson();
    protected JacksonObjectMapper mapper;
    protected SoftAssert logger;


    @BeforeClass
    public void prepareData() {
        mapper = new JacksonObjectMapper();
    }

    @Test
    public void getVariants() {

        Response rest = RestUtilities.getResponseWithoutHeader(RestUtilities.variantspec(), "get",
                null, Resources.getProductVariants);
        VariantResponse variantslist = (VariantResponse) mapper.deserializeJsonResponse(rest, VariantResponse.class);
        System.out.println(variantslist);

        for (int i = 0; i < variantslist.getVariants().size(); i++) {

            if ((double) variantslist.getVariants().get(i).getWeight() == 1.25) {
                String orderurl = baseUri+"/order";
                String response =
                        given().
                                header("Content-Type", "application/json").

                                body("{\n" +
                                        "      \"id\": "+(Integer) variantslist.getVariants().get(i).getId()+",\n" +
                                        "      \"product_id\": "+(Integer) variantslist.getVariants().get(i).getProduct_id()+",\n" +
                                        "      \"title\": "+variantslist.getVariants().get(i).getTitle()+",\n" +
                                        "      \"price\": "+variantslist.getVariants().get(i).getPrice()+",\n" +
                                        "      \"sku\":"+variantslist.getVariants().get(i).getSku()+",\n" +
                                        "      \"position\":"+(Integer) variantslist.getVariants().get(i).getPosition()+",\n" +
                                        "      \"inventory_policy\":"+variantslist.getVariants().get(i).getInventory_policy()+",\n" +
                                        "      \"compare_at_price\":"+variantslist.getVariants().get(i).getCompare_at_price()+",\n" +
                                        "      \"fulfillment_service\":"+variantslist.getVariants().get(i).getFulfillment_service()+",\n" +
                                        "      \"inventory_management\":"+variantslist.getVariants().get(i).getInventory_management()+",\n" +
                                        "      \"option1\":"+variantslist.getVariants().get(i).getOption1()+",\n" +
                                        "      \"option2\":"+variantslist.getVariants().get(i).getOption2()+",\n" +
                                        "      \"option3\":"+variantslist.getVariants().get(i).getOption3()+",\n" +
                                        "      \"created_at\":"+variantslist.getVariants().get(i).getCreated_at()+",\n" +
                                        "      \"updated_at\":"+variantslist.getVariants().get(i).getUpdated_at()+",\n" +
                                        "      \"taxable\":"+variantslist.getVariants().get(i).getTaxable()+",\n" +
                                        "      \"barcode\":"+variantslist.getVariants().get(i).getBarcode()+",\n" +
                                        "      \"grams\":"+(Integer) variantslist.getVariants().get(i).getGrams()+",\n" +
                                        "      \"image_id\":"+variantslist.getVariants().get(i).getImage_id()+",\n" +
                                        "      \"weight\": 5.00,\n" +
                                        "      \"weight_unit\":"+variantslist.getVariants().get(i).getWeight_unit()+",\n" +
                                        "      \"inventory_item_id\"::"+variantslist.getVariants().get(i).getInventory_item_id()+",\n" +
                                        "      \"inventory_quantity\":"+variantslist.getVariants().get(i).getInventory_quantity()+",\n" +
                                        "      \"old_inventory_quantity\":"+variantslist.getVariants().get(i).getOld_inventory_quantity()+",\n" +
                                        "      \"requires_shipping\":"+variantslist.getVariants().get(i).getRequires_shipping()+",\n" +
                                        "      \"admin_graphql_api_id\":"+variantslist.getVariants().get(i).getAdmin_graphql_api_id()+",\n" +
                                        "      \"presentment_prices\": [\n" +
                                        "        {\n" +
                                        "          \"price\": {\n" +
                                        "            \"currency_code\":"+variantslist.getVariants().get(i).getPresentment_prices().get(i).getPrice().getCurrency_code()+",\n" +
                                        "            \"amount\":"+variantslist.getVariants().get(i).getPresentment_prices().get(i).getPrice().getAmount()+",\n" +
                                        "          },\n" +
                                        "          \"compare_at_price\":"+variantslist.getVariants().get(i).getPresentment_prices().get(i).getCompare_at_price()+",\n" +
                                        "        }\n" +
                                        "      ]\n" +
                                        "    }").
                                when().post(orderurl).
                                then().log().ifError().
                                assertThat().statusCode(201).
                                extract().body().asString();
                System.out.print("PostTrustServiceRequests Response is :  ----    " + response  +  "\n");   // VerifyGetProductVariants();

            }


        }




    }





/*    @Test
    public void VerifyGetProductVariants() {

        String url = baseUri+"/getProductVariants";
        String response =
                given().
                        header("Content-Type", "application/json").
                        when().get(url).
                        then().
                        assertThat().
                        //statusCode(200).
                                extract().body().asString();

        System.out.print("Get variants Response is :  ----    " + response  + "\n");

        }*/

   /* public void VerifyPostTrustServiceRequests() {
        String orderurl = baseUri+"/order";


        String response =
                given().
                        header("Content-Type", "application/json").

                        body("{\n" +
                                "      \"id\": 39072856,\n" +
                                "      \"product_id\": 632910392,\n" +
                                "      \"title\": \"Green\",\n" +
                                "      \"price\": \"199.00\",\n" +
                                "      \"sku\": \"IPOD2008GREEN\",\n" +
                                "      \"position\": 3,\n" +
                                "      \"inventory_policy\": \"continue\",\n" +
                                "      \"compare_at_price\": null,\n" +
                                "      \"fulfillment_service\": \"manual\",\n" +
                                "      \"inventory_management\": \"shopify\",\n" +
                                "      \"option1\": \"Green\",\n" +
                                "      \"option2\": null,\n" +
                                "      \"option3\": null,\n" +
                                "      \"created_at\": \"2020-02-06T12:33:39-05:00\",\n" +
                                "      \"updated_at\": \"2020-02-06T12:33:39-05:00\",\n" +
                                "      \"taxable\": true,\n" +
                                "      \"barcode\": \"1234_green\",\n" +
                                "      \"grams\": 567,\n" +
                                "      \"image_id\": null,\n" +
                                "      \"weight\": 1.25,\n" +
                                "      \"weight_unit\": \"lb\",\n" +
                                "      \"inventory_item_id\": 39072856,\n" +
                                "      \"inventory_quantity\": 30,\n" +
                                "      \"old_inventory_quantity\": 30,\n" +
                                "      \"requires_shipping\": true,\n" +
                                "      \"admin_graphql_api_id\": \"gid://shopify/ProductVariant/39072856\",\n" +
                                "      \"presentment_prices\": [\n" +
                                "        {\n" +
                                "          \"price\": {\n" +
                                "            \"currency_code\": \"USD\",\n" +
                                "            \"amount\": \"199.00\"\n" +
                                "          },\n" +
                                "          \"compare_at_price\": null\n" +
                                "        }\n" +
                                "      ]\n" +
                                "    }").
                        when().post(orderurl).
                        then().log().ifError().
                        assertThat().statusCode(200).
                        extract().body().asString();
        System.out.print("PostTrustServiceRequests Response is :  ----    " + response  +  "\n");
    }*/
}
