package core.aintroclasses.test;
import core.aintroclasses.domain.Teacher;

public class TeacherTest {
    public static void main(String[] args) {
        // Teste: imprimir todas as informações do objeto tipo professor numa linha.
        Teacher girafales = new Teacher();
        girafales.nome = "Girafales";
        girafales.idade = 50;
        girafales.sexo = 'M';
        System.out.println("Professor "+girafales.nome+", idade: "+girafales.idade+", sexo "+girafales.sexo);
    }
}