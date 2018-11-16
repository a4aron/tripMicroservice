package com.altimetric.tripMicroservice.model.Air;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Outbound {

    private List<Flight> flights = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
