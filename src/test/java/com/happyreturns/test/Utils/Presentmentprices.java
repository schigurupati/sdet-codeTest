package com.happyreturns.test.Utils;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Presentmentprices {



    @SerializedName("pp_price")
    private Price price;

    @SerializedName("pp_compare_at_price")
    private String compare_at_price;
}
