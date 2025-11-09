public class Pediatrician extends HealthProfessional {
    private String ageRange;

    public Pediatrician() {}

    public Pediatrician(int id, String name, String specialtyArea, String ageRange) {
        super(id, name, specialtyArea);
        this.ageRange = ageRange;
    }

    @Override
    public void printDetails() {
        System.out.println("Health Professional Type: Pediatrician");
        super.printDetails();
        System.out.println("Suitable Age Range: " + ageRange);
    }

    public String getAgeRange() { return ageRange; }
}