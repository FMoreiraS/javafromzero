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
    public static Seminary[] registeredSeminaries;
    static int arrayIndex;

    public static void main(String[] args) {
        Seminary metaphysicalView = new Seminary("Visão Metafísica da Realidade");
        Professor profGregorio = new Professor("Gregório Santana", "Metafísica");
        Academician carlos = new Academician("Carlos Braga", 22);
        Local auditorium = new Local("Auditório da Universidade");

        registerWithoutScanner(metaphysicalView, profGregorio, auditorium, carlos);
        registeredSeminaries[0].print();
    }
    // Evitei scanner para ganhar tempo.
    public static void registerWithoutScanner(Seminary seminary, Professor teacher, Local address, Academician... participants) {
//        Seminary metaphysicalView = new Seminary("Visão Metafísica da Realidade");
//        Professor profGregorio = new Professor("Gregório Santana", "Metafísica");
//        Academician carlos = new Academician("Carlos Braga", 22);
//        Local auditorium = new Local("Auditório da Universidade");

        teacher.setSeminaries(seminary);
        address.setSeminary(seminary);
        //carlos.setSeminary(metaphysicalView);

        seminary.setProfessor(teacher);
        seminary.setLocal(address);
        seminary.setParticipants(participants);

        incrementSeminaries(seminary);
    }
    public static void incrementSeminaries(Seminary seminary) {
        if(arrayIndex == 0) {
            registeredSeminaries[arrayIndex] = seminary;
            arrayIndex++;
            return;
        }
        registeredSeminaries[arrayIndex] = seminary;
    }
    // Por razões práticas, todas as entidades envolvidas estão aqui.
    public class Seminary {
        private String title;
        private Professor teacher;
        private Local address;
        private Academician[] participants;

        public Seminary(String title) {
            this.title = title;
        }

        public Seminary(String title, Professor teacher, Local address) {
            this.title = title;
            this.teacher = teacher;
            this.address = address;
        }

        public void print() {
            System.out.println("Seminário " + getTitle());
            System.out.print("ministrado pelo professor " + this.teacher.getName());
            System.out.println(", especialista em " + this.teacher.getSpecialty());
            System.out.println("Local: " + this.address.getAddress());
            System.out.println("Participantes:");
            for(int i = 0; i < this.participants.length; i++) {
                System.out.println((i+1) + this.participants[i].getName());
            }
        }

        public void setProfessor(Professor teacher) {
            this.teacher = teacher;
        }

        public void setLocal(Local address) {
            this.address = address;
        }

        public void setParticipants(Academician... participants) {
            this.participants = participants;
        }

        public String getTitle() {
            return title;
        }

        public Professor getTeacher() {
            return teacher;
        }

        public Local getAddress() {
            return address;
        }

        public Academician[] getParticipants() {
            return participants;
        }
    }

    public class Professor {
        private String name;
        private String specialty;
        private Seminary[] seminaries;

        public Professor(String name, String specialty) {
            this.name = name;
            this.specialty = specialty;
        }

        public void print() {
            System.out.println("Professor " + this.getName());
        }

        public void setSeminaries(Seminary... seminaries) {
            this.seminaries = seminaries;
        }

        public String getName() {
            return name;
        }

        public String getSpecialty() {
            return specialty;
        }

        public Seminary[] getSeminaries() {
            return seminaries;
        }
    }

    public class Local {
        private String address;
        private Seminary seminary;

        public Local(String address) {
            this.address = address;
        }

        public void setSeminary(Seminary seminary) {
            this.seminary = seminary;
        }

        public String getAddress() {
            return address;
        }

        public Seminary getSeminary() {
            return seminary;
        }
    }

    public class Academician {
        private String name;
        private int age;
        private Seminary seminary;

        public Academician(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Seminary getSeminary() {
            return seminary;
        }

        public void setSeminary(Seminary seminary) {
            this.seminary = seminary;
        }
    }
}