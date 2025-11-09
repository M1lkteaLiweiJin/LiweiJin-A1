import java.util.ArrayList;

public class AssignmentOne {
    private static ArrayList<Appointment> appointmentList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("=== Part 3: Health Professional Objects ===");
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr. Smith", "Family Medicine", 20);
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr. Jones", "Primary Care", 18);
        GeneralPractitioner gp3 = new GeneralPractitioner(103, "Dr. Brown", "General Medicine", 22);
        Pediatrician pedia1 = new Pediatrician(201, "Dr. Williams", "Pediatrics", "0-12 Years");
        Pediatrician pedia2 = new Pediatrician(202, "Dr. Davis", "Child Health", "0-18 Years");

        gp1.printDetails();
        System.out.println("------------------------------");
        gp2.printDetails();
        System.out.println("------------------------------");
        gp3.printDetails();
        System.out.println("------------------------------");
        pedia1.printDetails();
        System.out.println("------------------------------");
        pedia2.printDetails();
        System.out.println("------------------------------");

        System.out.println("\n=== Part 5: Appointment Management ===");
        createAppointment("Alice Johnson", "0412345678", "08:30", gp1);
        createAppointment("Bob Williams", "0487654321", "10:15", gp2);
        createAppointment("Charlie Brown", "0423456789", "14:00", pedia1);
        createAppointment("Diana Prince", "0498765432", "16:30", pedia2);

        System.out.println("\n=== All Existing Appointments ===");
        printExistingAppointments();

        String cancelMobile = "0487654321";
        System.out.println("\n=== Canceling Appointment (Mobile: " + cancelMobile + ") ===");
        cancelBooking(cancelMobile);

        System.out.println("\n=== Appointments After Cancellation ===");
        printExistingAppointments();
    }

    public static void createAppointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        if (patientName.isEmpty() || patientMobile.isEmpty() || timeSlot.isEmpty() || doctor == null) {
            System.out.println("Error: Missing required information. Appointment not created.");
            return;
        }
        Appointment newAppt = new Appointment(patientName, patientMobile, timeSlot, doctor);
        appointmentList.add(newAppt);
        System.out.println("Appointment created successfully for " + patientName);
    }

    public static void printExistingAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("No existing appointments.");
            return;
        }
        for (int i = 0; i < appointmentList.size(); i++) {
            System.out.println("Appointment " + (i + 1) + ":");
            appointmentList.get(i).printAppointment();
        }
    }

    public static void cancelBooking(String patientMobile) {
        boolean isCanceled = false;
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getPatientMobile().equals(patientMobile)) {
                appointmentList.remove(i);
                isCanceled = true;
                break;
            }
        }
        if (isCanceled) {
            System.out.println("Appointment canceled successfully.");
        } else {
            System.out.println("Error: No appointment found with mobile number: " + patientMobile);
        }
    }
}
