package com.altimetric.tripMicroservice.model.Air;

import java.util.HashMap;
import java.util.Map;

public class PricePerAdult {

    private String totalFare;
    private String tax;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(String totalFare) {
        this.totalFare = totalFare;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
