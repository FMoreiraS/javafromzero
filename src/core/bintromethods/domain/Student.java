package core.bintromethods.domain;

public class Student {
    public String nome;
    public int idade;
    public char sexo;

    public void printStudent() {
        System.out.println("Dados do estudante:");
        System.out.println(this.nome);
        System.out.println(this.idade);
        System.out.println(this.sexo);
    }
}
