package core.bintromethods.domain;

import core.bintromethods.domain.Student;

public class PrinterStudent {
    public void print (Student estudante) {
        System.out.println("Dados do estudante:");
        System.out.println (estudante.nome);
        System.out.println (estudante.idade);
        System.out.println (estudante.sexo);
    }
    public void changeAndPrint (Student estudante) {
        estudante.nome = "Tiago";
        System.out.println("Dados do estudante:");
        System.out.println (estudante.nome);
        System.out.println (estudante.idade);
        System.out.println (estudante.sexo);
    }
    public void printAndChange (Student estudante) {
        System.out.println("Dados do estudante:");
        System.out.println (estudante.nome);
        System.out.println (estudante.idade);
        System.out.println (estudante.sexo);
        estudante.nome = "Tiago";
    }
}
