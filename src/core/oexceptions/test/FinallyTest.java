package core.oexceptions.test;

public class FinallyTest {

    public static void main(String[] args) {
        createFicticiousFile("notes");
        createFicticiousFile("my-notes");
    }

    private static void createFicticiousFile(String name){        
        try {
            System.out.println("Execução do try");
            System.out.println("Abrindo recurso do SO...");
            if (name.contains("-")) {
                throw new IllegalArgumentException("O nome não pode ter \"-\"");
            } 
            System.out.printf("O arquivo %s.txt foi criado.\n", name);
            System.out.println("Não ocorreu exceção.");
        } catch (RuntimeException e) {
            System.out.println("Execução do catch");
            throw new RuntimeException("A exceção foi lançada.");
        } finally {
            System.out.println("Execução do finally.");
            System.out.println("Fechando recurso...");
        }
    }
}
