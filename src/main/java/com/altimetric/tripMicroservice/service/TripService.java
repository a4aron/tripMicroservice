package com.altimetric.tripMicroservice.service;

import com.altimetric.tripMicroservice.model.Inputs;
import com.altimetric.tripMicroservice.model.Trip;

public interface TripService {
    Trip findCheaptestTrip(Inputs param);
    Trip findFastestTrip(Inputs param);
    Trip findComfortableTrip(Inputs param);
}
