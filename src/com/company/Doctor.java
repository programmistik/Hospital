package com.company;

import java.util.Random;

public class Doctor {
    private String name;
    private int timePerPatient; // in minutes
    private boolean hasLanch;
    private boolean hasPacient;
    private Schedule schedule;
    private Cabinet cabinet;
    private Patient patient;
    private boolean atWork; // in case he(she) has vacation or sick

    public Doctor(Schedule schedule, Cabinet cabinet, int count) {
        this.schedule = schedule;
        this.cabinet = cabinet;
        hasPacient = false;
        patient = null;

        name = "Doctor#" + count + " from cab." + String.valueOf(cabinet.getNumber());

        Random rand = new Random();
        timePerPatient = rand.nextInt(15) + 5; // 5-20 min.

        if(schedule.getName().equals("First"))
            hasLanch = true;
        else
            hasLanch = false;

        atWork = true;
    }

    public void sendToVacation() {
        this.atWork = false;
    }

    public void setHasPacient(Patient pacient) {
        this.hasPacient = true;
        this.patient = pacient;
        cabinet.delFromQueue(patient);
    }

    public void setIsFree() {
        this.hasPacient = false;
        patient = null;
    }

    public boolean isAtWork() {
        return atWork;
    }

    public boolean IsFree() {
        return !hasPacient;
    }

    public Patient getPatient() {
        return patient;
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return timePerPatient;
    }
}
