package ui;
import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;
public class UiDoctorMenu {
    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<Doctor>();
    public static void showDoctorMenu(){
        int response = 0;
        do{
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome "+ UiMenu.doctorLogged.getName());
            System.out.println("1. Add Available Appointment");
            System.out.println("2. My Scheduled Appointment");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response =(Integer) sc.nextInt();

            switch (response){
                case 1:
                    response = 0;
                    showAddAvailableAppointmentMenu();
                    break;
                case 2:
                    response =0;
                    showMyAvailableAppointment();
                    break;
                case 0:
                    UiMenu.showMenu();
            }
        }while(response!=0);
    }

    private static void showAddAvailableAppointmentMenu(){
        int response = 0;
        do{
            System.out.println();
            System.out.println("::Add Available Appointment");
            System.out.println(":: Select a month");

            for (int i = 0;  i < 3; i++) {
                int j = i + 1;
                System.out.println(j + ". " + UiMenu.MONTHS[i]);
            }
            System.out.println("0. Return");
            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());
            if(response > 0 && response <4) {
                //1,2,3 Month
                int monthSelected = response - 1;
                System.out.println(monthSelected + 1 + " . " + UiMenu.MONTHS[monthSelected]);
                //Date
                System.out.println("Insert the date available: [dd/mm/yyyy]");
                String date = sc.nextLine();
                System.out.println("You date is: " + date + "\n1. Correct \n2. Change Date");
                int responseDate = Integer.parseInt(sc.nextLine());
                if (responseDate == 2) continue;
                //Time
                int responseTime = 0;
                String time = "";
                do {
                    System.out.printf("Insert the time available for date %s [16:00]\n", date);
                    time = sc.nextLine();
                    System.out.printf("Your time is : %s for the date %s \n1.Correct\n2.Change time\n",date,time);
                    responseTime = Integer.parseInt(sc.nextLine());
                } while (responseTime == 2);
                //Date Asssignment Available
                UiMenu.doctorLogged.addAvailableAppointment(date, time);
                checkDoctorAvailableAppointment(UiMenu.doctorLogged);
            }else if(response == 0){
                showDoctorMenu();
            }
        }while(response != 0);
    }

    private static void checkDoctorAvailableAppointment(Doctor doctor){
        if(doctor.getAvailableAppointments().size()> 0 && !doctorsAvailableAppointments.contains(doctor)){
            doctorsAvailableAppointments.add(doctor);
        }
    }

    private static void showMyAvailableAppointment(){
        System.out.println(UiMenu.doctorLogged.getAvailableAppointments());
        showDoctorMenu();
    }
}
