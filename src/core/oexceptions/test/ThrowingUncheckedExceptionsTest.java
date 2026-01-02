package core.oexceptions.test;

public class ThrowingUncheckedExceptionsTest {
    public static void main(String[] args) {
        System.out.println(divideTwoNumbers(1, 0));
        System.out.println(divideTwoNumbers(1, 2));
    }
    
    // Testamos o throw com um método para calcular divisões.
    private static int divideTwoNumbers(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException(
                "O segundo argumento é o denominador e não pode ser zero.");
        }
        return num1/num2;
        // Isso é melhor que usar try e catch, porque desobriga retornar
        // um valor insatisfatório.
    }
}