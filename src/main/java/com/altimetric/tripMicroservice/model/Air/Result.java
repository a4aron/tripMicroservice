package com.altimetric.tripMicroservice.model.Air;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private List<Itinerary> itineraries = null;
    private Fare fare;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    public void setItineraries(List<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
