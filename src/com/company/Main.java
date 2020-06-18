package com.company;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static int currentTime = 0;
    public static int patCount = 0;
    public static Clinic myClinic;

    public static void main(String[] args) {

        int maxPatientCount = 100;

     // создаем клинику, врачей и кабинеты

        myClinic = new Clinic("Diana Hospital");

        // если в кабинете более двух врачей, отправим одного в отпуск
      /*  for (Cabinet cab: myClinic.getCabinets()) {
            if(cab.getDocCount() > 2) cab.getDoctors().get(2).sendToVacation();
        }*/

        // начинаем
        System.out.println("Welcome to "+ myClinic.getName());
        System.out.println("Now is "+ getTime(currentTime));



        // запускаем часики
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public synchronized void run() {

                currentTime++;
                System.out.println("Now is " + getTime(currentTime));

                if (currentTime <= 960){
                    // Пациенты собираются под кабинетами до 9 вечера.
                    if(currentTime <= 900){
                        if(patCount <= maxPatientCount) {
                         //   System.out.println("Patient#" + String.valueOf(patCount));
                            Patient patient = new Patient("Patient#"+String.valueOf(patCount));
                            myClinic.patientComes(patient);

                            patCount++;
                        }
                    }
                    // Поликлиника открывается в 8 утра
                    if(currentTime >= 120){
                        // Начало приема
                      //  System.out.println("Начало приема");
                        for (Cabinet cab: myClinic.getCabinets()) {
                            if (cab.getNextPatient() != null) { // если есть пациент в очереди
                                Patient pat = cab.getNextPatient();
                                while (cab.getFreeDoctor() != null) {
                                    Doctor doc = cab.getFreeDoctor();
                                    doc.setHasPacient(pat);
                                    Runnable r = new Reception(doc);
                                    Thread newThread = new Thread(r);
                                    newThread.start();
                                }
                            }

                        }
                    }

                }
                else{
                    // finish
                }


            }
        }, 0, 1, TimeUnit.SECONDS);


        if(currentTime >= 960)
            exec.shutdown();

    }


    public static String getTime(int time){
        // 0 = 06:00

        int h = time / 60;
        int m = time - h*60;

        h = h + 6;

        String hh = String.valueOf(h);
        if (hh.length()<2) hh = "0"+hh;
        String mm = String.valueOf(m);
        if (mm.length()<2) mm = "0"+mm;

        return hh + ":" + mm;
    }
}
