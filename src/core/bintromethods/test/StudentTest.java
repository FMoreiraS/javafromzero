package core.bintromethods.test;

import core.bintromethods.domain.Student;
import core.bintromethods.domain.PrinterStudent;

public class StudentTest {
    public static void main (String[] args) {
        Student estudante1 = new Student();
        Student estudante2 = new Student();
        PrinterStudent printer = new PrinterStudent();

        estudante1.nome = "João";
        estudante1.idade = 25;
        estudante1.sexo = 'M';

        estudante2.nome = "Maria";
        estudante2.idade = 30;
        estudante2.sexo = 'F';

        printer.print(estudante1);

        printer.print(estudante2);

        PrinterStudent modifier = new PrinterStudent();

        modifier.changeAndPrint(estudante1);

        modifier.printAndChange(estudante2);

        printer.print(estudante1);

        printer.print(estudante2);

        Student estudante3 = new Student();

        estudante3.nome = "Paulo";
        estudante3.idade = 28;
        estudante3.sexo = 'M';

        estudante3.printStudent();
    }
}