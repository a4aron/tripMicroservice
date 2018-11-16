package com.altimetric.tripMicroservice.model.Air;

import java.util.HashMap;
import java.util.Map;

public class Itinerary {

    private Outbound outbound;
    private Inbound inbound;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Outbound getOutbound() {
        return outbound;
    }

    public void setOutbound(Outbound outbound) {
        this.outbound = outbound;
    }

    public Inbound getInbound() {
        return inbound;
    }

    public void setInbound(Inbound inbound) {
        this.inbound = inbound;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
