package com.company;

public class Patient {
    private String name;
    private Cabinet waitingCabinet;
    private boolean hasPriority;
    private PatientPriority priority;

    public Patient(String name) {
        this.name = name;
        waitingCabinet = null;
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
}
