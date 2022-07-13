package com.streamwork.ch02.job;

import com.streamwork.ch02.api.Job;
import com.streamwork.ch02.api.Stream;
import com.streamwork.ch02.engine.JobStarter;

public class VehicleCountJob {

  public static void main(String[] args) {
    Job job = new Job("vehicle_count");

    Stream bridgeStream = job.addSource(new SensorReader("sensor-reader"));
    Stream counterStream = bridgeStream.applyOperator(new VehicleCounter("vehicle-counter"));
    counterStream.applyOperator(new Printer("printer"));
    System.out.println("This is a streaming job that counts vehicles in real time. " +
        "Please enter vehicle types like 'car' and 'truck' in the input terminal " +
        "and look at the output");
    JobStarter starter = new JobStarter(job);
    starter.start();
  }
}
