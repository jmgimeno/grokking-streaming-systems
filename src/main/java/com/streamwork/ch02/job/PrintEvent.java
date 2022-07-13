package com.streamwork.ch02.job;

import com.streamwork.ch02.api.Event;

import java.util.Map;

public class PrintEvent extends Event {

    private final Map<String, Integer> counters;
    private final int totalFees;

    record PrintDTO(Map<String, Integer> counters, int totalFees) { }

    public PrintEvent(Map<String, Integer> counters, int totalFees) {
        this.counters = counters;
        this.totalFees = totalFees;
    }

    @Override
    public PrintDTO getData() {
        return new PrintDTO(counters, totalFees);
    }
}
