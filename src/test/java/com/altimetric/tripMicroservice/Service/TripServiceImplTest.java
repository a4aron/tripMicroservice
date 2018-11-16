package com.altimetric.tripMicroservice.Service;

import com.altimetric.tripMicroservice.model.*;
import com.altimetric.tripMicroservice.service.AirService;
import com.altimetric.tripMicroservice.service.CarService;
import com.altimetric.tripMicroservice.service.HotelService;
import com.altimetric.tripMicroservice.service.TripServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
class TripServiceImplTest {

    @InjectMocks
    TripServiceImpl tripService;

    @Mock
    private AirService airService;

    @Mock
    private HotelService hotelService;

    @Mock
    private CarService carService;

    @Mock
    private Inputs input;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

    }
    @Test
    void findCheaptestTrip() {
        //stub
        Trip t = new Trip();
        Airport airport = new Airport();
        Hotel hotel = new Hotel();
        Car car = new Car();

        when(airService.cheapestFlights(any())).thenReturn(airport);
        when(carService.cheapestCars(any())).thenReturn(car);
        when(hotelService.cheapestHotel(any())).thenReturn(hotel);

        assertNotNull(tripService.findCheaptestTrip(input));


    }
}