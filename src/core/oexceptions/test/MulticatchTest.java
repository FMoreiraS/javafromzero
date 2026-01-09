package core.oexceptions.test;

public class MulticatchTest {
    public static void main(String[] args) {
        mayThrowException();
    }

    static void mayThrowException() {
        try {
            int test = 45 / 0;
            System.out.println(test);
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Ocorreu uma exceção do tipo " +
                    e.getClass().getName());
            // Não seria possível incluir no catch a Runtime, por exemplo,
            // porque seria desnecessário. Mas por precaução podemos ainda
            // pegá-la em bloco dedicado.
        } catch (RuntimeException e) {
            System.out.println("Foi lançada uma RuntimeException.");
            // Note-se como é possível reatribuir o valor de "e".
            e = new IndexOutOfBoundsException();
        }
    }

}
