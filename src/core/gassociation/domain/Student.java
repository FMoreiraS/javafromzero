package core.gassociation.domain;

public class Student {
    private String name;
    private School school;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, School school) {
        this.name = name;
        this.school = school;
    }

    public void print() {
        System.out.print("Student " + this.getName());
        if(this.school != null) {
            System.out.println(" da School " + school.getName());
        }
        // O if evita uma nullPointerException, já que school pode não existir.
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getName() {
        return this.name;
    }

}
