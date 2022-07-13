package com.streamwork.ch03.api;

public class FirstCharGrouping implements GroupingStrategy {
    @Override
    public int getInstance(Event event, int parallelism) {
        try {
            return event.getData().toString().codePointAt(0) % parallelism;
        } catch (IndexOutOfBoundsException ex) {
            return 0;
        }
    }
}
