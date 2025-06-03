package core.gassociation.exercise;

public class Solution {
    public static void main(String[] args) {
        System.out.println("TESTE");
        Local endereco = new Local("Rua El Dorado");
        Aluno aluno = new Aluno("João", 22);
        Professor professor = new Professor("Alberto", "Metafísica");

        Aluno[] alunosDoSeminario = {aluno};

        Seminario seminario = new Seminario("O que é metafísica", endereco, alunosDoSeminario);

        Seminario[] seminariosDisponiveis = {seminario};

        professor.setSeminarios(seminariosDisponiveis);

        professor.imprime();
    }
    // Quis deixar tudo aqui por praticidade, já que há pouco código.
    public static class Seminario {
        private String titulo;
        private Local local;
        private Aluno[] alunos;

        public Seminario(String titulo) {
            this.titulo = titulo;
        }

        public Seminario(String titulo, Local endereco) {
            this.titulo = titulo;
            this.local = endereco;
        }

        public Seminario(String titulo, Local endereco, Aluno[] alunos) {
            this.titulo = titulo;
            this.local = endereco;
            this.alunos = alunos;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public Local getLocal() {
            return local;
        }

        public void setLocal(Local local) {
            this.local = local;
        }

        public Aluno[] getAlunos() {
            return alunos;
        }

        public void setAlunos(Aluno[] alunos) {
            this.alunos = alunos;
        }
    }

    public static class Aluno {
        private String nome;
        private int idade;
        private Seminario seminario;

        public Aluno(String nome) {
            this.nome = nome;
        }

        public Aluno(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        public Aluno(String nome, int idade, Seminario seminario) {
            this.nome = nome;
            this.idade = idade;
            this.seminario = seminario;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        public Seminario getSeminario() {
            return seminario;
        }

        public void setSeminario(Seminario seminario) {
            this.seminario = seminario;
        }
    }

    public static class Local {
        private String endereco;

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public Local(String endereco) {
            this.endereco = endereco;
        }
    }

    public static class Professor {
        private String nome;
        private String especialidade;
        private Seminario[] seminarios;

        public Professor(String nome) {
            this.nome = nome;
        }

        public Professor(String nome, String especialidade) {
            this.nome = nome;
            this.especialidade = especialidade;
        }

        public Professor(String nome, String especialidade, Seminario[] seminarios) {
            this.nome = nome;
            this.especialidade = especialidade;
            this.seminarios = seminarios;
        }

        public void imprime() {
            System.out.println("-------------------------------");
            System.out.println("Professor: " + this.getNome() + ", especialidade: " + this.getEspecialidade());
            if (this.seminarios == null) return;
            System.out.println("##### Seminários cadastrados #####");
            for(Seminario seminario: this.seminarios) {
                System.out.println(seminario.getTitulo());
                System.out.println(seminario.getLocal().getEndereco());
                if(seminario.getAlunos() == null || this.seminarios.length == 0) continue;
                System.out.println("***** Alunos *****");
                for(Aluno aluno: seminario.alunos) {
                    System.out.println("Aluno: " + aluno.getNome() + ", idade: " + aluno.getIdade());
                }
            }
            System.out.println("-------------------------------");
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEspecialidade() {
            return especialidade;
        }

        public void setEspecialidade(String especialidade) {
            this.especialidade = especialidade;
        }

        public Seminario[] getSeminarios() {
            return seminarios;
        }

        public void setSeminarios(Seminario[] seminarios) {
            this.seminarios = seminarios;
        }
    }
}
