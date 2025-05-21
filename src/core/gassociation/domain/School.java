package core.gassociation.domain;

public class School {
    private String name;
    private Student[] students;

    public School(String name) {
        this.name = name;
    }

    public School(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public void print() {
        System.out.println("Escola " + this.getName());
        if(students == null) return;
        for(Student student: students) {
            System.out.println(student.getName());
        };
    }

    public String getName() {
        return name;
    }
}
