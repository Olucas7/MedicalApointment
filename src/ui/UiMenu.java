package ui;
import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

import static ui.UiDoctorMenu.showDoctorMenu;
public class UiMenu {
    public static Doctor doctorLogged;
    public static Patient patientLogeed;
    public static final String[] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

    public static void showMenu(){
        System.out.println("bienvenido al sistema hospitalario".toUpperCase());
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");
            System.out.print("\nyour choice... ");

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    System.out.println("Patient");
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }

    public static void authUser(int userType){
        //Data Base
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Oscar Lucas","oscar.h.l@hotmail.com"));
        doctors.add(new Doctor("Ana Lucas","ana.l@hotmail.com"));
        doctors.add(new Doctor("Bernardo Lucas","bernardo@hotmail.com"));
        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Marisol Canizares","marisolcani@hotmail.com"));
        patients.add(new Patient("Oscar Lucas","ohlm61@hotmail.com"));
        patients.add(new Patient("Lili Martinez","lili@hotmail.com"));


        //Authentication
        boolean emailCorrect = false;
        do{
            System.out.println("Ingrese su Email: [usuario@hotmail.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if (userType == 1) {
                for (Doctor d : doctors) {
                    if (email.equals(d.getEmail())) {
                        System.out.println("Encontrado");
                        emailCorrect = true;
                        doctorLogged = d;
                        System.out.println("Doctor Logged: " + doctorLogged.getName());
                        showDoctorMenu();
                    }
                }
            }

            if (userType == 2){
                for (Patient p: patients) {
                    if(email.equals(p.getEmail())){
                        emailCorrect = true;
                        patientLogeed = p;
                        System.out.println("Patient Logged: " + patientLogeed);
                        showPatientMenu();
                    }
                }
            }
        }while(!emailCorrect);
    }

    public static void showPatientMenu(){

        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("model.Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 0; i < 4 ; i++) {
                        System.out.println(i+1+". " + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
    }
}
