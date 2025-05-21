package core.gassociation.test;

import core.gassociation.domain.Student;
import core.gassociation.domain.School;

public class StudentTest {
    public static void main(String[] args) {
        Student socrates = new Student("Sócrates");
        Student plato = new Student("Platão");
        Student aristoteles = new Student("Aristóteles");
        Student[] greeks = {socrates, plato, aristoteles};

        System.out.println("Objetos relacionados por array: Estudantes gregos");

        for(Student student : greeks) {
            System.out.println(student.getName());
        }

        System.out.println("------------------------------------");

        System.out.println("School Escolástica associada a vários students:");

        Student albertus = new Student("Alberto de Colônia");
        Student thomas = new Student("Tomás de Aquino");
        Student[] students = {albertus, thomas};

        School scholastic = new School("Escolástica", students);

        scholastic.print();

        System.out.println("------------------------------------");

        School antique = new School("Antiguidade");

        System.out.println("Objetos associados à escola Antiguidade");

        socrates.setSchool(antique);
        plato.setSchool(antique);
        aristoteles.setSchool(antique);

        socrates.print();
        plato.print();
        aristoteles.print();
    }
}
