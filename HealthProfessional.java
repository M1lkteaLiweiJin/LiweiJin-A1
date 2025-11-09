public class HealthProfessional {
    private int id;
    private String name;
    private String specialtyArea;

    public HealthProfessional() {}

    public HealthProfessional(int id, String name, String specialtyArea) {
        this.id = id;
        this.name = name;
        this.specialtyArea = specialtyArea;
    }

    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Specialty Area: " + specialtyArea);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecialtyArea() { return specialtyArea; }
}