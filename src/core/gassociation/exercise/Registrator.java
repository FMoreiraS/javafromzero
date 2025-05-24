package core.gassociation.exercise;

import java.util.Scanner;

/* Obs.: Iniciado depois da exploração teórica sobre associação (21/05/2025).
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

public class Registrator {
    public static Seminary[] registeredSeminaries = new Seminary[5]; // Tamanhos para teste.
    static Professor[] registeredProfessors = new Professor[5];
    static Academician[] registeredAcademician = new Academician[200];
    static Local[] registeredLocals = new Local[5];
    static int seminaryIndex = 0;
    static int professorIndex = 0;
    static int participantIndex = 0;
    static int localIndex = 0;

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int menuState = 0;
        System.out.println("O que deseja cadastrar?");
        System.out.println("1. Seminário.");
        System.out.println("2. Professor.");
        System.out.println("3. Estudante.");
        System.out.println("4. Local.");
        System.out.println("5. Em breve...");
        /* Cadastro de
        1. Seminário
        2. Professor
        3. Estudante
        4. Local
        [5. Registro completo]
         */
        menuState = input.nextInt();
        switch (menuState) {
            case 1: registerSeminary2(); break;
            case 2: registerProfessor(); break;
            case 3: registerAcademician(); break;
            case 4: registerLocal(); break;
            default:
                System.out.println("Selecione uma opção de 1 a 4.");
        }

//        Seminary metaphysicalView = new Seminary("Visão Metafísica da Realidade");
//        Professor profGregorio = new Professor("Gregório Santana", "Metafísica");
//        Academician carlos = new Academician("Carlos Braga", 22);
//        Local auditorium = new Local("Auditório da Universidade");
//
//        registerWithoutScanner(metaphysicalView, profGregorio, auditorium, carlos);
        //registerSeminary();
        //registeredSeminaries[0].print();
        input.close();
    }

    public static void registerSeminary() {
        //Scanner input = new Scanner(System.in);
        System.out.println("Digite o título do Seminário:");
        Seminary seminary = new Seminary(input.nextLine());
        System.out.println("Digite o nome do professor responsável, tecle Enter e digite a especialidade.");
        Professor teacher = new Professor(input.nextLine(), input.nextLine());
        //Academician carlos = new Academician("Carlos Braga", 22);
        System.out.println("Digite o nome do endereço onde ocorrerá o seminário:");
        Local address = new Local(input.nextLine());

        teacher.setSeminaries(seminary);
        address.setSeminary(seminary);
        //carlos.setSeminary(metaphysicalView);

        seminary.setProfessor(teacher);
        seminary.setLocal(address);

        defineParticipants(seminary);
        incrementSeminaries(seminary);
        //input.close();
    }

    static void defineParticipants(Seminary seminary) {
        Academician[] participants = new Academician[registeredAcademician.length];
        int participantIndex = 0;
        System.out.println("Cadastro dos participantes");
        Scanner input = new Scanner(System.in);
        boolean registerMore = false;
        do {
            System.out.println("Digite o nome e o sobrenome do estudante, confirme e digite a idade:");
            Academician participant = new Academician(input.nextLine(), input.nextInt());
            //Seminary.setParticipant(seminary, participant, participantIndex);
            participants[participantIndex] = participant;
            participantIndex++;

            System.out.println("Deseja cadastrar mais?(s/n");
            char option = input.next().charAt(0);
            if(option == 's') {
                registerMore = true;
            }
        } while(registerMore);
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
        //seminary.setParticipant(participants);

        defineParticipants(seminary);
        incrementSeminaries(seminary);
    }

    public static void incrementSeminaries(Seminary seminary) {
        registeredSeminaries[seminaryIndex] = seminary;
        seminaryIndex++;
    }

    static void registerSeminary2() {
        System.out.println("Digite o título do seminário.");
        Seminary seminary = new Seminary("Seminário A");
        System.out.println("Indique o local onde ocorrerá.");
        Local address = new Local("Auditório");
        System.out.println("Indique o professor responsável.");
        Professor teacher = new Professor("Professor");
        System.out.println("Indique o professor responsável.");
        teacher.setSpecialty("Doutor em alguma coisa");
        seminary.setLocal(address);
        seminary.setProfessor(teacher);
        seminary.print();
        registeredSeminaries[seminaryIndex] = seminary;
        seminaryIndex++;
    }

    static void registerProfessor() {
        System.out.println("Digite o nome do Professor.");
        Professor teacher = new Professor("Professor");
        System.out.println("Indique a especialidade do professor. Exemplo: Doutor em Química Orgânica.");
        teacher.setSpecialty("Doutor");
        System.out.println("Indique qual seminário o professor ministrará.");
        // todo: verificar se é apenas um.
        teacher.setSeminaries(registeredSeminaries[seminaryIndex]);
        // verificar a nulidade no seminaryIndex.
        teacher.print();
        registeredProfessors[professorIndex] = teacher;
        professorIndex++;
    }

    static void registerAcademician() {
        System.out.println("Digite o nome do estudante.");
        Academician participant = new Academician("Estudante");
        System.out.println("Digite a idade do estudante.");
        participant.setAge(18);
        System.out.println("De qual seminário o estudante participará? (Pode ser apenas um)");
        // todo: listar seminários, para seleção. Se não houver nenhum, registerSeminary().
        Seminary seminary = new Seminary("Seminário de teste");
        participant.setSeminary(seminary);
        participant.print();
        registeredAcademician[participantIndex] = participant;
        participantIndex++;
    }

    static void registerLocal() {
        System.out.println("Indique o endereço.");
        Local address = new Local("Endereço");
        System.out.println("Indique qual seminário ocorrerá neste local.");
        // todo: listar seminários para seleção.
        address.setSeminary(registeredSeminaries[0]);
        address.print();
        registeredLocals[localIndex] = address;
        localIndex++;
    }
}