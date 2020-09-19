package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UiPatient {
    public static void showPatientMenu(){
        int response = 0;
        do{
            System.out.println("\n\n");
            System.out.println("Patiente");
            System.out.printf("Welcome %s\n",UiMenu.patientLogeed.getName());

            System.out.println("1. Book an appoinment");
            System.out.println("2. My appointment");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());
            switch (response){
                case 1:
                    response = 0;
                    showBookAppointmentMenu();
                    break;
                case 2:
                    response = 0;
                    showPatientMyAppointment();
                    break;
                case 0:
                    UiMenu.showMenu();
                    break;
            }
        }while(response != 0);
    }

    private static void showBookAppointmentMenu(){
        int response = 0;
        do {
            System.out.println("::Book an appointment");
            System.out.println("Select date: ");
            /*(Integer) = Numeracion de lista de doctores :
            (Map) <Integer>(Integer de la fecha que seleccione el paciente) <Doctor>(roll completo de doctor)*/
            Map<Integer,Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UiDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments = UiDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();
                Map<Integer, Doctor> doctorAppointment = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    doctorAppointment.put(Integer.valueOf(j), UiDoctorMenu.doctorsAvailableAppointments.get(i));

                    doctors.put(Integer.valueOf(k), doctorAppointment);
                }
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer,Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("","");
            for (Map.Entry<Integer,Doctor> doc : doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }
            System.out.println(doctorSelected.getName() +
                    ".Date " + doctorSelected.getAvailableAppointments().get(indexDate).getDate()+
                    ". Time: "+ doctorSelected.getAvailableAppointments().get(indexDate).getTime());

            System.out.println("Confirm your appoinment: \n1. Yes \n2. Change Data");
            response = Integer.valueOf(sc.nextLine());


            if(response == 1) {
                UiMenu.patientLogeed.addAppointmentDoctors(doctorSelected, doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());
                showPatientMenu();
            }
        }while(response != 0);
    }

    private  static void showPatientMyAppointment(){
        int response = 0;
        do{
            System.out.println("::My Appointments");
            if(UiMenu.patientLogeed.getAppointmentDoctors().size() == 0){
                System.out.println("Dont have appointment");
                break;
            }
            for (int i = 0; i < UiMenu.patientLogeed.getAppointmentDoctors().size(); i++) {
                int j = i +1;
                System.out.println(j + ". " +"Date: "
                        + UiMenu.patientLogeed.getAppointmentDoctors().get(i).getDate() + "\nTime" + UiMenu.patientLogeed.getAppointmentDoctors().get(i).getTime()
                        + "\nDoctor " + UiMenu.patientLogeed.getAppointmentDoctors().get(i).getDoctor().getName());

            }
            System.out.println("0. Return");
        }while(response != 0 );
    }

}
