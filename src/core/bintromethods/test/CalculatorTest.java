package core.bintromethods.test;

import core.bintromethods.domain.Calculator;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator somadora = new Calculator();
        Calculator subtratora = new Calculator();

        somadora.sums10w10();
        subtratora.subtracts2f10();
        // Assim fazemos objetos executarem os métodos criados.
        Calculator multiplicador = new Calculator();
        multiplicador.mutliplication(5, 6);

        Calculator divisora = new Calculator();

        double divisionResult = divisora.dividesTwoNumbers(30, 0);
        System.out.println(divisionResult); // O objeto poderia estar diretamente aqui.

        Calculator changer = new Calculator();

        int num1 = 1;
        int num2 = 2;
        System.out.println("Dentro do changesTwoNumbers");
        changer.changesTwoNumbers(num1, num2);
        System.out.println("Fora do changesTwoNumbers");
        System.out.println("num1 = " + num1 + " e num2 = " + num2);

        Calculator somadoraArray = new Calculator();
        int[] numeros = {1, 2, 3, 4, 5};

        somadoraArray.sumArray (numeros);

        Calculator somadoraVarArgs = new Calculator();

        somadoraVarArgs.sumVarArgs(1, 2, 3, 4, 5);
    }
}