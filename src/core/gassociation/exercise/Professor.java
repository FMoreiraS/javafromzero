package core.gassociation.exercise;

public class Professor {
    private String name;
    private String specialty;
    private Seminary[] seminaries;

    public Professor(String name) {
        this.name = name;
        //this.specialty = specialty;
    }

    public Professor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public void print() {
        System.out.println("--------------------------------");
        System.out.println("Professor " + this.getName() + ", especialidade: " + this.getSpecialty());
        if(this.seminaries != null) {
            System.out.println("Seminários assumidos:");
            for (Seminary seminary : this.seminaries) {
                System.out.println(seminary.getTitle());
            }
        }
            System.out.println("--------------------------------");
    }

    public void setSeminaries(Seminary... seminaries) {
        this.seminaries = seminaries;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }
}
