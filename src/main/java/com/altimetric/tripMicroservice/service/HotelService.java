package com.altimetric.tripMicroservice.service;

import com.altimetric.tripMicroservice.model.Hotel;
import com.altimetric.tripMicroservice.model.Inputs;

public interface HotelService {
    Hotel cheapestHotel(Inputs param);
}
