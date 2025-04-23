package core.aintroclasses.test;

import core.aintroclasses.domain.Student;

public class StudentTest {
    public static void main(String[] args) {
        Student estudante = new Student();
        estudante.nome = "Plato";
        estudante.idade = 18;
        estudante.sexo = 'M';

        /* Fazendo isso, criamos objeto com valores para as variáveis comportadas pela classe Student,
         * referenciado pela variável refers "estudante". Essa variável é do mesmo tipo do da classe,
         * mas poderia não sê-lo (depois se falará sobre).
         *
         * Para imprimir os dados gerados, é preciso indicá-los no print, pois a variável de referência
         * indica somente o espaço em memória.
         */
        System.out.println(estudante.nome);
        System.out.println(estudante.idade);
        System.out.println(estudante.sexo);
        System.out.println(estudante);

        /* Um objeto poderia ser criado sem a enunciação de uma variável de referência,
         * mas seria inacessível.
         * Outra observação: se atributos de uma classe são incializados diretamente nela,
         * o valor padrão para tais atributos serão os mesmos para todos os objetos, por
         * isso as inicializações preferencialmente no ato e no local da criação dos objetos.
         */
    }
}