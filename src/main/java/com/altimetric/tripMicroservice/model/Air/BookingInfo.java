package com.altimetric.tripMicroservice.model.Air;

import java.util.HashMap;
import java.util.Map;

public class BookingInfo {

    private String travelClass;
    private String bookingCode;
    private Integer seatsRemaining;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public Integer getSeatsRemaining() {
        return seatsRemaining;
    }

    public void setSeatsRemaining(Integer seatsRemaining) {
        this.seatsRemaining = seatsRemaining;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
