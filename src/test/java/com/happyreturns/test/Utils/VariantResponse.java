package com.happyreturns.test.Utils;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;

@Data
public class VariantResponse {



    @SerializedName("errors")
    ArrayList<Object> errors = new ArrayList<Object>();

    @SerializedName("variants")
    ArrayList<Variants> variants = new ArrayList<Variants>();



}
