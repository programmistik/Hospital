package com.company;

public class Schedule {
    private String name;
    private int startHour;
    private int endHour;

    public Schedule(String name, int startHour, int endHour) {
        this.name = name;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public String getName() {
        return name;
    }
}
