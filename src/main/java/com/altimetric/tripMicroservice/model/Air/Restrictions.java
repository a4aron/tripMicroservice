package com.altimetric.tripMicroservice.model.Air;

import java.util.HashMap;
import java.util.Map;

public class Restrictions {

    private Boolean refundable;
    private Boolean changePenalties;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Boolean getRefundable() {
        return refundable;
    }

    public void setRefundable(Boolean refundable) {
        this.refundable = refundable;
    }

    public Boolean getChangePenalties() {
        return changePenalties;
    }

    public void setChangePenalties(Boolean changePenalties) {
        this.changePenalties = changePenalties;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
