package com.streamwork.ch02.job;

import java.net.*;
import java.io.*;
import java.util.List;
import java.util.Random;

import com.streamwork.ch02.api.Event;
import com.streamwork.ch02.api.Source;

class SensorReader extends Source {

    enum VehicleTypes {
        TRUCK, CAR, BIKE
    }

    private final Random random = new Random();

    public SensorReader(String name) {
        super(name);
    }

    @Override
    public void getEvents(List<Event> eventCollector) {
        try {
            String vehicle = randomVehicle();
            Thread.sleep(1000);
            eventCollector.add(new VehicleEvent(vehicle));
            System.out.println();  // An empty line before logging new events
            System.out.println("SensorReader --> " + vehicle);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String randomVehicle() {
        VehicleTypes[] possibleVehicles = VehicleTypes.values();
        int randomIndex = random.nextInt(possibleVehicles.length);
        return possibleVehicles[randomIndex].name().toLowerCase();
    }
}
