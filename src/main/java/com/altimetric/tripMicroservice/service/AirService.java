package com.altimetric.tripMicroservice.service;

import com.altimetric.tripMicroservice.model.Airport;
import com.altimetric.tripMicroservice.model.Inputs;

import java.util.List;

public interface AirService {
    public Airport cheapestFlights(Inputs params);
}
