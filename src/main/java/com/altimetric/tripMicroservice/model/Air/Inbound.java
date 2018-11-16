package com.altimetric.tripMicroservice.model.Air;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inbound {

    private List<Flight_> flights = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Flight_> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight_> flights) {
        this.flights = flights;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
