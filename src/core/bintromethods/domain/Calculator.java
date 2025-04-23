package core.bintromethods.domain;

public class Calculator {
    public void sums10w10() {
        System.out.println(10 + 10);
    }

    public void subtracts2f10() {
        System.out.println(10 - 2);
    }

    public void mutliplication(int num1, int num2) {
        System.out.println(num1 * num2);
    }

    public double dividesTwoNumbers(double num1, double num2) {
        if (num2 == 0) {
            return 0;
        }
        return num1/num2;
    }

    public void dividesTwoNumbers2(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Não existe divisão por zero!");
        }
        System.out.println(num1 / num2);
    }
    public void dividesTwoNumbers3(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Não existe divisão por zero!");
            return;
        }
        System.out.println(num1 / num2);
    }

    public void changesTwoNumbers(int num1, int num2) {
        num1 = 7;
        num2 = 12;
        System.out.println ("num1 = " + num1);
        System.out.println ("num2 = " + num2);
    }

    public void sumArray(int[] numeros) {
        int sum = 0;
        for (int num : numeros) {
            sum += num;
        }
        System.out.println(sum);
    }

    public void sumVarArgs(int... numeros) {
        int sum = 0;
        for (int num : numeros) {
            sum += num;
        }
        System.out.println(sum);
    }
}