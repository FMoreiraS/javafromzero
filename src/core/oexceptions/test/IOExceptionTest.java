package core.oexceptions.test;

import java.io.File;
import java.io.IOException;

public class IOExceptionTest {
    public static void main(String[] args) {
        createNewFile("test");
    }

    private static void createNewFile(String name) {
        File file = new File(name + ".txt");
        // Isso apenas prepara a criação dum arquivo, por um método próprio.
        // Como o método lança a checked exception IOException, só
        // podemos usá-lo dentro dum bloco try.
        try {
            file.createNewFile();
            // Para causar uma exceção aqui, basta alterar a permissão
            // do diretório, proibindo a escrita. O meio varia entre SOs,
            // mas pode ser feito em um explorador de arquivos com GUI.
            System.out.println("Teste de código não executado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
