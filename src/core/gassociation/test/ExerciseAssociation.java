package core.gassociation.test;

/* Obs.: Feito depois da exploração teórica sobre associação (21/05/2025).
Criar um sistema que gerencie seminários:
O sistema deverá cadastrar seminários, estudantes, professores e locais de realização.

Um aluno poderá estar em apenas um seminário;
Um seminário poderá ter nenhum ou vários alunos;
Um professor poderá ministrar vários seminários
Um seminário deve ter um local.

Campos básicos (excluindo relacionamento)
Seminário: título
Aluno: nome e idade
Professor: nome, especialidade
Local: endereço
 */

public class ExerciseAssociation {
    public static void main(String[] args) {

    }

    public class Seminary {
        private String title;
        private Professor teacher;
        private Local address;
        private Academic[] participants;

        public Seminary(String title, Professor teacher, Local address) {
            this.title = title;
            this.teacher = teacher;
            this.address = address;

            public void setSeminaries(Academic... participants) {
                this.participants = participants;
            }
        }
    }

    public class Professor {
        private String name;
        private String especialty;
        private Seminary[] seminaries;

        public Professor(String name, String especialty) {
            this.name = name;
            this.especialty = especialty;
        }

        public void setSeminaries(Seminary... seminaries) {
            this.seminaries = seminaries;
        }
    }
    // todo: criar classe Academic com seus campos. Pensar no funcionamento geral do cadastro.
}
