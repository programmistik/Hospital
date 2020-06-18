package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class Clinic {
    private String name;
    private int maxCabinetCount = 30;
    private int cabinetCount;
    private ArrayList<Cabinet> cabinets = new ArrayList<Cabinet>();

    public Clinic(String name) {
        this.name = name;
        // create two schedule
        ArrayList<Schedule> schedules = new ArrayList<>(2);
        schedules.add(new Schedule("First",8, 15));
        schedules.add(new Schedule("Second",15, 22));

        Random rand = new Random();
        this.cabinetCount = rand.nextInt(maxCabinetCount) + 1;
        for (int i = 1; i <= cabinetCount; i++){
            Cabinet newCabinet = new Cabinet(i, schedules);
            cabinets.add(newCabinet);
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Cabinet> getCabinets() {
        return cabinets;
    }


    public void patientComes(Patient patient) {
        // to queue

        boolean leave = true;

        for (Cabinet cab: cabinets) {
            if(cab.getQueueSize() < 25) {
                cab.addToQueue(patient);
                patient.setCabinet(cab);
                System.out.println("Пациент " + patient.getName() + " занял очередь перед кабинетом №" + cab.getNumberStr());
                leave = false;
                break;
            }
        }

        if (leave)
            System.out.println("Пациент " + patient.getName() + " покинул поликлинику");


       // notify();
    }

}
