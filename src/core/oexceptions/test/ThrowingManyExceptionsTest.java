package core.oexceptions.test;

import java.io.File;
import java.io.IOException;

public class ThrowingManyExceptionsTest {
    public static void main(String[] args) {
        throwAnyUncheckedException();
        try {
            throwAnyCheckedException();
        } catch (IOException e) {
            System.out.println("A exceção " + e.getClass() + " foi lançada.");
        } catch (InterruptedException e) {
            System.out.println("A exceção " + e.getClass() + " foi lançada.");
        }
    }

    private static void throwAnyUncheckedException() {
        try {
            throw new RuntimeException();
        } catch (IllegalArgumentException e) {
            System.out.println("A exceção " + e.getClass() + " foi lançada.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("A exceção " + e.getClass() + " foi lançada.");
        } catch (RuntimeException e) {
            System.out.println("A exceção " + e.getClass() + " foi lançada.");
        }
    }

    private static void throwAnyCheckedException()
            throws IOException, InterruptedException {
        if (!new File("").exists()) {
            throw new IOException();
        }
        throw new InterruptedException();
    }

}
