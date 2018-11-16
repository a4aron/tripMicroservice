package com.altimetric.tripMicroservice.controller;

import com.altimetric.tripMicroservice.model.Inputs;
import com.altimetric.tripMicroservice.model.Trip;
import com.altimetric.tripMicroservice.service.AirService;
import com.altimetric.tripMicroservice.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class TripController {

    @Autowired
    private TripService tripService;

     @GetMapping(value = "/trip")
    public HashMap<String, Trip> getTrip(@RequestParam String origin, @RequestParam String destination,
                                 @RequestParam String startDate, @RequestParam int days){
        Inputs userInput = new Inputs(origin, destination, startDate, days);
        if(userInput.isDateValid(startDate)){
            HashMap<String, Trip> trips = new HashMap<>();
            trips.put("cheapest", tripService.findCheaptestTrip(userInput));
            trips.put("fastest", tripService.findFastestTrip(userInput));
            trips.put("comfort", tripService.findComfortableTrip(userInput));
            return trips;
        }
        return null; // throw Exception json
    }

}
