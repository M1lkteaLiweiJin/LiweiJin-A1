public class GeneralPractitioner extends HealthProfessional {
    private int maxPatientsPerDay;

    public GeneralPractitioner() {}

    public GeneralPractitioner(int id, String name, String specialtyArea, int maxPatientsPerDay) {
        super(id, name, specialtyArea);
        this.maxPatientsPerDay = maxPatientsPerDay;
    }

    @Override
    public void printDetails() {
        System.out.println("Health Professional Type: General Practitioner");
        super.printDetails();
        System.out.println("Max Patients Per Day: " + maxPatientsPerDay);
    }

    public int getMaxPatientsPerDay() { return maxPatientsPerDay; }
}