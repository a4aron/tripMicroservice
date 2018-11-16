package com.altimetric.tripMicroservice.model.Air;

import java.util.HashMap;
import java.util.Map;

public class Flight_ {

    private String departsAt;
    private String arrivesAt;
    private Origin_ origin;
    private Destination_ destination;
    private String marketingAirline;
    private String operatingAirline;
    private String flightNumber;
    private String aircraft;
    private BookingInfo_ bookingInfo;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getDepartsAt() {
        return departsAt;
    }

    public void setDepartsAt(String departsAt) {
        this.departsAt = departsAt;
    }

    public String getArrivesAt() {
        return arrivesAt;
    }

    public void setArrivesAt(String arrivesAt) {
        this.arrivesAt = arrivesAt;
    }

    public Origin_ getOrigin() {
        return origin;
    }

    public void setOrigin(Origin_ origin) {
        this.origin = origin;
    }

    public Destination_ getDestination() {
        return destination;
    }

    public void setDestination(Destination_ destination) {
        this.destination = destination;
    }

    public String getMarketingAirline() {
        return marketingAirline;
    }

    public void setMarketingAirline(String marketingAirline) {
        this.marketingAirline = marketingAirline;
    }

    public String getOperatingAirline() {
        return operatingAirline;
    }

    public void setOperatingAirline(String operatingAirline) {
        this.operatingAirline = operatingAirline;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public BookingInfo_ getBookingInfo() {
        return bookingInfo;
    }

    public void setBookingInfo(BookingInfo_ bookingInfo) {
        this.bookingInfo = bookingInfo;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
