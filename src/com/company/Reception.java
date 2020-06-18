package com.company;

public class Reception implements Runnable{
    private Doctor doctor;

    public Reception(Doctor doctor) {
        this.doctor = doctor;
    }

    public synchronized void run() {
        System.out.println("Пациент "+doctor.getPatient().getName()+" вошел в кабинет №"+
                doctor.getCabinet().getNumberStr()+" к врачу " + doctor.getName());

        int time = doctor.getTime()*1000;
        try {
            Thread.sleep(time);
            System.out.println("Пациент "+doctor.getPatient().getName()+" вышел от врача " + doctor.getName());
            doctor.setIsFree();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
