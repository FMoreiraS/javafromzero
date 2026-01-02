package core.oexceptions.test;

import java.io.File;
import java.io.IOException;

public class ThrowingCheckedExceptionsTest {
    public static void main(String[] args) {
        try {
            createNewFile("exception");
        } catch (IOException e) {
            System.out.println("Ocorreu exceção, o arquivo não foi criado");
        }
    }

    // Um exemplo do "tratamento parcial" ou "solução híbrida"
    private static void createNewFile(String name) throws IOException{
        File file = new File(name + ".txt");
        
        try {
            file.createNewFile();
            System.out.println("Não ocorreu exceção.");
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
            // O método responsabiliza-se por imprimir a stack trace, mas
            // obriga quem o chamou a dar o tratamento propriamente dito.
        }
    }
}
