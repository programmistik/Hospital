package com.company;

import java.util.Random;

public class Patient {
    private String name;
    private Cabinet waitingCabinet;
   // private boolean hasPriority;
    private PatientPriority priority;

    public Patient(String name) {
        this.name = name;
        waitingCabinet = null;
        Random rand = new Random();
        priority = PatientPriority.values()[rand.nextInt(6)]; // 5-20 min.

        System.out.println("Пациент "+ getName() + " зашел в клинику.");
    }

    public String getName() {
        return name;
    }

    public void setCabinet(Cabinet cabinet) {

        this.waitingCabinet = cabinet;
    }

    public Cabinet getCabinet() {
        return waitingCabinet;
    }

    public PatientPriority getPriority() {
        return priority;
    }
}
