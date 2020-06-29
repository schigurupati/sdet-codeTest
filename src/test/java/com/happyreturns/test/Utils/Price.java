package com.happyreturns.test.Utils;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Price {

    @SerializedName("price_currency_code")
    private String currency_code;
    @SerializedName("price_amount")
    private String amount;
}
