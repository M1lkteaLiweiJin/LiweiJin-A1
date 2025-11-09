import java.util.ArrayList;
import java.util.Scanner;

public class AssignmentOne {
    private static ArrayList<Appointment> appointmentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr. Smith", "General Medicine", 20);
    private static GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr. Jones", "Family Medicine", 18);
    private static Pediatrician pedia1 = new Pediatrician(201, "Dr. Williams", "Pediatrics", "0-12 Years");
    private static Pediatrician pedia2 = new Pediatrician(202, "Dr. Davis", "Child Health", "0-18 Years");

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=====================================");
            System.out.println("Health Service Appointment System - Menu");
            System.out.println("=====================================");
            System.out.println("1. Create New Appointment");
            System.out.println("2. Cancel Existing Appointment");
            System.out.println("3. Print All Existing Appointments");
            System.out.println("4. Exit System");
            System.out.print("Please select an option (1-4): ");
            
            int choice = Integer.parseInt(scanner.nextLine().trim());
            switch (choice) {
                case 1:
                    createAppointment();
                    break;
                case 2:
                    cancelAppointment();
                    break;
                case 3:
                    printAllAppointments();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void createAppointment() {
        System.out.println("\n--- Create New Appointment ---");
        System.out.println("Select Health Professional Type:");
        System.out.println("1. General Practitioner");
        System.out.println("2. Pediatrician");
        int typeChoice = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Enter Patient Name: ");
        String patientName = scanner.nextLine().trim();

        System.out.println("Enter Patient Mobile Number (e.g., 0412345678): ");
        String patientMobile = scanner.nextLine().trim();

        System.out.println("Enter Appointment Time Slot (e.g., 08:30, 14:15): ");
        String timeSlot = scanner.nextLine().trim();

        HealthProfessional selectedProfessional = null;
        if (typeChoice == 1) {
            System.out.println("Select a General Practitioner:");
            System.out.println("1. Dr. Smith (General Medicine)");
            System.out.println("2. Dr. Jones (Family Medicine)");
            int gpChoice = Integer.parseInt(scanner.nextLine().trim());
            selectedProfessional = (gpChoice == 1) ? gp1 : gp2;
        } else if (typeChoice == 2) {
            System.out.println("Select a Pediatrician:");
            System.out.println("1. Dr. Williams (0-12 Years)");
            System.out.println("2. Dr. Davis (0-18 Years)");
            int pediaChoice = Integer.parseInt(scanner.nextLine().trim());
            selectedProfessional = (pediaChoice == 1) ? pedia1 : pedia2;
        }

        if (isInputValid(patientName, patientMobile, timeSlot, selectedProfessional)) {
            Appointment newAppointment = new Appointment(patientName, patientMobile, timeSlot, selectedProfessional);
            appointmentList.add(newAppointment);
            System.out.println("Appointment created successfully!");
        } else {
            System.out.println("Invalid input. Appointment not created.");
        }
    }

    private static boolean isInputValid(String name, String mobile, String time, HealthProfessional prof) {
        return !name.isEmpty() && !mobile.isEmpty() && !time.isEmpty() && prof != null;
    }

    private static void printAllAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }
        System.out.println("\n--- All Existing Appointments ---");
        for (int i = 0; i < appointmentList.size(); i++) {
            System.out.println("Appointment " + (i + 1) + ":");
            appointmentList.get(i).printAppointmentDetails();
        }
    }

    private static void cancelAppointment() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments to cancel.");
            return;
        }
        System.out.println("\n--- Cancel Appointment ---");
        System.out.println("Enter the patient's mobile number to cancel: ");
        String mobile = scanner.nextLine().trim();
        boolean canceled = false;
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getPatientMobile().equals(mobile)) {
                appointmentList.remove(i);
                canceled = true;
                break;
            }
        }
        if (canceled) {
            System.out.println("Appointment canceled successfully.");
        } else {
            System.out.println("No appointment found with mobile number: " + mobile);
        }
    }
}
