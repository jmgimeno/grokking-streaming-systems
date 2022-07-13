package com.streamwork.ch02.job;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.streamwork.ch02.api.Event;
import com.streamwork.ch02.api.Operator;

class VehicleCounter extends Operator {
  private static final Map<String, Integer> feesPerType = Map.of("bike", 1, "car", 3, "truck", 5);
  private final Map<String, Integer> countMap = new HashMap<>();
  private int totalFees = 0;
  public VehicleCounter(String name) {  super(name);  }

  @Override
  public void apply(Event vehicleEvent, List<Event> eventCollector) {
    String vehicle = ((VehicleEvent)vehicleEvent).getData();
    Integer count = countMap.getOrDefault(vehicle, 0) + 1;
    countMap.put(vehicle, count);
    totalFees += feesPerType.getOrDefault(vehicle, 0);
    eventCollector.add(new PrintEvent(Collections.unmodifiableMap(countMap), totalFees));
  }
}
