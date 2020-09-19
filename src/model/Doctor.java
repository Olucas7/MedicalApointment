package model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Doctor extends User {
    //Atributos
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    private String speciality;

    //Constuctor
    public Doctor(String name, String email){
        super(name,email);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }


    public void addAvailableAppointment(String date, String time){
        this.availableAppointments.add(new AvailableAppointment(date,time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments(){

        return this.availableAppointments;
    }

    public void setAvailableAppointments(ArrayList<AvailableAppointment> availableAppointments) {
        this.availableAppointments = availableAppointments;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSpeciality = " + speciality+
                "\nAvailableAppointments = " + availableAppointments;
    }

    // NESTED CLASS - STATIC
    public static class AvailableAppointment{
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        public AvailableAppointment(String date, String time){
            try {
                this.date =format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }

        public Date getDate(String DATE) {
            return date;
        }

        public String getDate(){
            return format.format(date);

        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return
                    "\n id_Appointment = " + id +
                            "\n date = " + format.format(date) +
                            "\n time = " + time+"\n";
        }
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado del Hospital Todoro Maldonado");
        System.out.println("Hospital: Cruz Roja");
        System.out.println("Departamento: Cancerologia");
    }
}
