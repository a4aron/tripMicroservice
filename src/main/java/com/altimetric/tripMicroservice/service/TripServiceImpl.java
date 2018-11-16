package com.altimetric.tripMicroservice.service;

import com.altimetric.tripMicroservice.model.Inputs;
import com.altimetric.tripMicroservice.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements TripService{

    @Autowired
    private AirService airService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private CarService carService;


    @Override
    public Trip findCheaptestTrip(Inputs param) {
        Trip cheapestTrip = new Trip();
        cheapestTrip.setAir(airService.cheapestFlights(param));
        cheapestTrip.setCar(carService.cheapestCars(param));
        cheapestTrip.setHotel(hotelService.cheapestHotel(param));
        return cheapestTrip;
    }

    @Override
    public Trip findFastestTrip(Inputs param) {
        return new Trip();
    }

    @Override
    public Trip findComfortableTrip(Inputs param) {
        return new Trip();
    }
}
