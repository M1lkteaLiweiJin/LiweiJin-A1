public class Appointment {
    private String patientName;
    private String patientMobile;
    private String timeSlot;
    private HealthProfessional healthProfessional;

    public Appointment() {}

    public Appointment(String patientName, String patientMobile, String timeSlot, HealthProfessional healthProfessional) {
        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.timeSlot = timeSlot;
        this.healthProfessional = healthProfessional;
    }

    public void printAppointmentDetails() {
        System.out.println("=== Appointment Details ===");
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Mobile: " + patientMobile);
        System.out.println("Appointment Time Slot: " + timeSlot);
        System.out.println("Consulting Health Professional:");
        healthProfessional.printDetails();
        System.out.println("===========================\n");
    }

    public String getPatientMobile() { return patientMobile; }
}