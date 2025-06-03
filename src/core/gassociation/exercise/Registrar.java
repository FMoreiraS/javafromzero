package core.gassociation.exercise;

import java.util.Scanner;

/* Obs.: Iniciado depois da exploração teórica sobre associação (21/05/2025);
tomei a liberdade de fazer alguns recursos além do sugerido, para exercitar.

Criar um sistema que gerencie seminários:
O sistema deverá cadastrar seminários, estudantes, professores e locais de realização.

Um aluno poderá estar em apenas um seminário;
Um seminário poderá ter nenhum ou vários alunos;
Um professor poderá ministrar vários seminários
Um seminário deve ter um local.

OBS.: esses são os relacionamentos, ir além disso sai dos requisitos.

Campos básicos (excluindo relacionamento)
Seminário: título
Aluno: nome e idade
Professor: nome, especialidade
local: endereço
 */

public class Registrar {
    static Seminary[] registeredSeminaries = new Seminary[5]; // Tamanhos para teste.
    static Professor[] registeredProfessors = new Professor[5];
    static Academician[] registeredAcademician = new Academician[200];
    static Place[] registeredPlaces = new Place[5];
    static int seminaryIndex = 0;
    static int professorIndex = 0;
    static int participantIndex = 0;
    static int placeIndex = 0;

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int menuState = 0;

        while(menuState == 0) {
            System.out.println("O que deseja?");
            System.out.println("1. Cadastrar seminário.");
            System.out.println("2. Cadastrar professor.");
            System.out.println("3. Cadastrar estudante.");
            System.out.println("4. Cadastrar place.");
            System.out.println("5. Cadastrar seminário com professor, place e participantes.");
            System.out.println("6. Listar seminários.");
            System.out.println("7. Listar professores.");
            System.out.println("8. Listar estudantes.");
            System.out.println("9. Listar locais.");
            System.out.println("10. Sair.");

            menuState = input.nextInt();
            switch (menuState) {
                case 1:
                    registerSeminary();
                    menuState = 0;
                    break;
                case 2:
                    registerProfessor();
                    menuState = 0;
                    break;
                case 3:
                    registerAcademician();
                    menuState = 0;
                    break;
                case 4:
                    registerPlace();
                    menuState = 0;
                    break;
                case 5:
                    registerAll();
                    menuState = 0;
                    break;
                case 6:
                    showSeminaries();
                    menuState = 0;
                    break;
                case 7:
                    showProfessors();
                    menuState = 0;
                    break;
                case 8:
                    showAcademicians();
                    menuState = 0;
                    break;
                case 9:
                    showPlaces();
                    menuState = 0;
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Selecione uma opção de 1 a 10.");
                }
        }
        input.close();
    }


    public static void registerWithoutScanner(Seminary seminary, Professor teacher, Place address, Academician... participants) {
//        Seminary metaphysicalView = new Seminary("Visão Metafísica da Realidade");
//        Professor profGregorio = new Professor("Gregório Santana", "Metafísica");
//        Academician carlos = new Academician("Carlos Braga", 22);
//        place auditorium = new place("Auditório da Universidade");

        teacher.setSeminaries(seminary);
        address.setSeminary(seminary);
        //carlos.setSeminary(metaphysicalView);

        seminary.setProfessor(teacher);
        seminary.setPlace(address);
        //seminary.setParticipant(participants);

        defineParticipants(seminary);
        incrementSeminaries(seminary);
    }

    static void registerSeminary() {
        System.out.println("Digite o título do seminário.");
        Seminary seminary = new Seminary("Teste A");
        System.out.println("Indique o place onde ocorrerá.");
        Place address = new Place("Auditório");
        System.out.println("Indique o professor responsável.");
        Professor teacher = new Professor("Fulano");
        System.out.println("Indique a especialidade do professor.");
        teacher.setSpecialty("Doutor em alguma coisa");

        seminary.setPlace(address);
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
        // Não parece interessante agora listar seminários para escolha, sai muito do foco.
        System.out.println("De qual seminário o estudante participará? (Pode ser apenas um)");
        Seminary seminary = new Seminary("Seminário de teste");
        participant.setSeminary(seminary);
        participant.print();
        registeredAcademician[participantIndex] = participant;
        participantIndex++;
    }

    static void registerPlace() {
        System.out.println("Indique o endereço.");
        Place address = new Place("Endereço");
        System.out.println("Indique qual seminário ocorrerá neste local.");
        showSeminaries();
        address.setSeminary(registeredSeminaries[0]);
        address.print();
        registeredPlaces[placeIndex] = address;
        placeIndex++;
    }

    public static void registerAll() {
        //Scanner input = new Scanner(System.in);
        System.out.println("Digite o título do Seminário:");
        Seminary seminary = new Seminary(input.nextLine());
        System.out.println("Digite o nome do professor responsável, tecle Enter e digite a especialidade.");
        Professor teacher = new Professor(input.nextLine(), input.nextLine());
        //Academician carlos = new Academician("Carlos Braga", 22);
        System.out.println("Digite o nome do endereço onde ocorrerá o seminário:");
        Place address = new Place(input.nextLine());

        teacher.setSeminaries(seminary);
        address.setSeminary(seminary);
        //carlos.setSeminary(metaphysicalView);

        seminary.setProfessor(teacher);
        seminary.setPlace(address);

        defineParticipants(seminary);
        incrementSeminaries(seminary);
    }

    static void defineParticipants(Seminary seminary) {
        Academician[] participants = new Academician[registeredAcademician.length];
        int participantIndex = 0;
        System.out.println("Cadastro dos participantes");
        boolean registerMore = false;
        do {
            System.out.println("Digite o nome e o sobrenome do estudante, confirme e digite a idade:");
            Academician participant = new Academician(input.nextLine(), input.nextInt());
            participants[participantIndex] = participant;

            participantIndex++;

            System.out.println("Deseja cadastrar mais?(s/n)");
            char option = input.next().charAt(0);
            if(option == 's') {
                registerMore = true;
            }
        } while(registerMore);
        seminary.participants = participants;
    }

    public static void incrementSeminaries(Seminary seminary) {
        registeredSeminaries[seminaryIndex] = seminary;
        seminaryIndex++;
    }

    static void showSeminaries() {
        if(registeredSeminaries[0] == null) {
            System.out.println("Não há seminários cadastrados.");
            return;
        }
        System.out.println("Seminários cadastrados");
        for(int i = 0; i < registeredSeminaries.length; i++) {
            registeredSeminaries[i].show((i+1));
        }
    }

    static void showProfessors() {
        if(registeredProfessors[0] == null) {
            System.out.println("Não há professores cadastrados.");
            return;
        }
        System.out.println("Professores cadastrados");
        for(int i = 0; i < registeredProfessors.length; i++) {
            registeredProfessors[i].show((i+1));
        }
    }

    static void showAcademicians() {
        if(registeredAcademician[0] == null) {
            System.out.println("Não há estudantes cadastrados.");
            return;
        }
        System.out.println("Estudantes cadastrados");
        for(int i = 0; i < registeredAcademician.length; i++) {
            registeredProfessors[i].show((i+1));
        }
    }

    static void showPlaces() {
        if(registeredPlaces[0] == null) {
            System.out.println("Não há locais cadastrados.");
            return;
        }
        System.out.println("Locais cadastrados");
        for(int i = 0; i < registeredPlaces.length; i++) {
            registeredProfessors[i].show((i+1));
        }
    }
}