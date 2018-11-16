package com.altimetric.tripMicroservice.model;

import com.altimetric.tripMicroservice.model.Air.Air;

public class Trip {
    private Airport air;
    private Car car;
    private Hotel hotel;
//    private double price;

    public Trip() {
    }

    public Airport getAir() {
        return air;
    }

    public void setAir(Airport air) {
        this.air = air;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
