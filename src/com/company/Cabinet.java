package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class Cabinet {
    private int number;
    private int maxDocCount = 4;

    private int docCount;
    private ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    private ArrayList<Patient> patients;

    public Cabinet(int number, ArrayList<Schedule> schedules) {

        this.number = number;
        patients = new ArrayList<Patient>(25);
        Random rand = new Random();
        this.docCount = rand.nextInt(maxDocCount) + 1;
        int j = 0;
        for (int i = 1; i <= docCount; i++){
            Doctor newDoctor = new Doctor(schedules.get(j),this, i);
            doctors.add(newDoctor);
            if (j == 0)
                j++;
            else
                j--;
        }
    }

    public int getNumber() {
        return number;
    }
    public String getNumberStr() {
        return String.valueOf(number);
    }

    public int getDocCount() {
        return docCount;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public int getQueueSize(){
        return patients.size();
    }

    public void addToQueue(Patient patient){
        patients.add(patient);
    }

    public void delFromQueue(Patient patient){
        patients.remove(patient);
    }

    public Doctor getFreeDoctor(){
        for (Doctor doc: doctors) {
            if(doc.IsFree())
                return doc;
        }
        return null;
    }

    public Patient getNextPatient(){
        if(patients.size() > 0)
            return patients.get(0);
        return null;
    }
}
