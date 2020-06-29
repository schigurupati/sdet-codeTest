package com.happyreturns.test.Utils;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Variants {


    @SerializedName("varaint_id")
    private int id;

    @SerializedName("varaint_product_id")
    private int product_id;
    @SerializedName("varaint_title")
    private String title;

    @SerializedName("varaint_price")
    private String price;

    @SerializedName("varaint_sku")
    private String sku;
    @SerializedName("varaint_position")
    private int position;
    @SerializedName("varaint_inventory_policy")
    private String inventory_policy;
    @SerializedName("varaint_compare_at_price")
    private String compare_at_price;
    @SerializedName("varaint_fulfillment_service")
    private String fulfillment_service;

    @SerializedName("varaint_inventory_management")
    private String inventory_management;
    @SerializedName("varaint_option1")
    private String option1;
    @SerializedName("varaint_option2")
    private String option2;
    @SerializedName("varaint_option3")
    private String option3;
    @SerializedName("varaint_created_at")
    private String created_at;

    @SerializedName("varaint_updated_at")
    private String updated_at;


    @SerializedName("varaint_taxable")
    private Boolean taxable;
    @SerializedName("varaint_grams")
    private int grams;
    @SerializedName("varaint_barcode")
    private String barcode;
    @SerializedName("varaint_image_id")
    private String image_id;
    @SerializedName("varaint_weight")
    private double weight;
    @SerializedName("varaint_weight_unit")
    private String weight_unit;
    @SerializedName("varaint_inventory_item_id")
    private int inventory_item_id;
    @SerializedName("varaint_inventory_quantity")
    private int inventory_quantity;
    @SerializedName("varaint_old_inventory_quantity")
    private int old_inventory_quantity;
    @SerializedName("varaint_requires_shipping")
    private Boolean requires_shipping;
    @SerializedName("varaint_admin_graphql_api_id")
    private String admin_graphql_api_id;

    @SerializedName("presentment_prices")
    ArrayList<Presentmentprices> presentment_prices = new ArrayList<Presentmentprices>();

}
