package core.oexceptions.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TryWithResourcesTest {
    public static void main(String[] args) {

    }

    static void testTry() {
        Reader reader = null;
        // É preciso criar aqui para ser acessível no try dentro do finally.
        try {
            reader = new BufferedReader(new FileReader("test.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("close() gerou exceção.");
            }
        }
    }

    static void testTryWithResources() {
        try (Reader reader = new BufferedReader(new FileReader("test.txt"));) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        // O próprio try realiza o close(), e se der algo errado,
        // pegamos com catch.
    }

}
