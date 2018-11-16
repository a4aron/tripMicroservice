package com.altimetric.tripMicroservice.model.Air;

import java.util.HashMap;
import java.util.Map;

public class Fare {

    private String totalPrice;
    private PricePerAdult pricePerAdult;
    private Restrictions restrictions;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PricePerAdult getPricePerAdult() {
        return pricePerAdult;
    }

    public void setPricePerAdult(PricePerAdult pricePerAdult) {
        this.pricePerAdult = pricePerAdult;
    }

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
