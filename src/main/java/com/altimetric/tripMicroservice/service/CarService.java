package com.altimetric.tripMicroservice.service;

import com.altimetric.tripMicroservice.model.Car;
import com.altimetric.tripMicroservice.model.Inputs;

public interface CarService {
     Car cheapestCars(Inputs inputs);
}
