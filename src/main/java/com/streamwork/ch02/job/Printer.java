package com.streamwork.ch02.job;

import com.streamwork.ch02.api.Event;
import com.streamwork.ch02.api.Operator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Printer extends Operator {

    public Printer(String name) {
        super(name);
    }

    @Override
    public void apply(Event event, List<Event> eventCollector) {
        PrintEvent.PrintDTO dto = ((PrintEvent) event).getData();
        printCountMap(dto.counters());
        printTotalFees(dto.totalFees());
    }

    private void printCountMap(Map<String, Integer> counters) {
        System.out.println("VehicleCounter --> ");
        List<String> vehicles = new ArrayList<>(counters.keySet());
        Collections.sort(vehicles);

        for (String vehicle: vehicles) {
            System.out.println("  " + vehicle + ": " + counters.get(vehicle));
        }
    }

    private void printTotalFees(int totalFees) {
        System.out.println("TotalFees --> ");
        System.out.println(totalFees);
    }
}
