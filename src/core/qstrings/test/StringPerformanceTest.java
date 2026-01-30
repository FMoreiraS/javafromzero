package core.qstrings.test;

import java.util.ArrayList;
import java.util.List;

public class StringPerformanceTest {
    public static void main(String[] args) {
        // O teste ficou em formato de execução via terminal. O argumento 0
        // define a classe a ser testada e o argumento 1, o número de operações.
        // if(args[0].equalsIgnoreCase("test")) args = new String[]{"buffer", "100000"};
        // args = new String[]{"builder", "100000"};
        int numberOfIterations = 10;
        int numberOfOperations = 1000;
        double averageTime = 0;
        double averageOpsPerMs = 0;
        List<Long> executionTimes = new ArrayList<Long>();
        Long[] executionTimesArray = executionTimes.toArray(new Long[numberOfIterations]);
        
        String arg1 = args[0];
        int arg2 = Integer.valueOf(args[1]);
        
        if(arg2 > 0) {
            numberOfOperations = arg2;
        }

        if (arg1.equalsIgnoreCase("string")) {
            System.out.println("--------TESTE COM STRING--------");
            executionTimes = testConcatString(numberOfOperations, numberOfIterations);
            executionTimesArray = executionTimes.toArray(executionTimesArray);
            averageTime = calcAverageExecTime(executionTimesArray);
            averageOpsPerMs = calcAverageOpsPerMs(executionTimesArray, numberOfOperations);
            // System.out.printf(
                //     "Tempos de execução (ms) de %d operações em %d tentativas:\n\t %s\n" +
                //     "Tempo médio: %f\n" +
                //     "Ops. por milissegundo: %f\n" +
                //     "Ops. por segundo: %f\n",
                //     numberOfOperations, numberOfIterations,
                //     executionTimes.toString(),
                //     averageTime,
                //     averageOpsPerMs,
                //     averageOpsPerMs * 1000
                // );
        } else if(arg1.equalsIgnoreCase("builder")) {
            System.out.println("-----TESTE COM STRINGBUILDER-----");
            executionTimes = testConcatStringBuilder(numberOfOperations, numberOfIterations);
            executionTimesArray = executionTimes.toArray(executionTimesArray);
            averageTime = calcAverageExecTime(executionTimesArray);
            averageOpsPerMs = calcAverageOpsPerMs(executionTimes.toArray(executionTimesArray), numberOfOperations);
            // System.out.printf(
                //     "Tempos de execução (ms) de %d operações em %d tentativas:\n\t %s\n" +
                //     "Ops. per ms: %f\n" +
                //     "Ops. per second: %f\n",
                //     numberOfOperations, numberOfIterations,
                //     executionTimes.toString(),
                //     averageOpsPerMs,
                //     averageOpsPerMs * 1000
                // );
        } else {
            System.out.println("-----TESTE COM STRINGBUFFER-----");
            executionTimes = testConcatStringBuffer(numberOfOperations, numberOfIterations);
            executionTimesArray = executionTimes.toArray(executionTimesArray);
            averageTime = calcAverageExecTime(executionTimesArray);
            averageOpsPerMs = calcAverageOpsPerMs(executionTimes.toArray(executionTimesArray), numberOfOperations);
            // System.out.printf(
        //     "Tempos de execução (ms) de %d operações em %d tentativas:\n\t %s\n" +
        //     "Ops. per ms: %f\n" +
        //     "Ops. per second: %f\n",
        //     numberOfOperations, numberOfIterations,
        //     executionTimes.toString(),
        //     averageOpsPerMs,
        //     averageOpsPerMs * 1000
        // );
        }
        System.out.printf(
                "Tempos de execução (ms) de %d operações em %d tentativas:\n\t %s\n" +
                "Tempo médio: %f\n" +
                "Ops. por milissegundo: %f\n" +
                "Ops. por segundo: %f\n",
                numberOfOperations, numberOfIterations,
                executionTimes.toString(),
                averageTime,
                averageOpsPerMs,
                averageOpsPerMs * 1000
            );    

        /*
        System.out.println("--------TESTE COM STRING--------");
        numberOfOperations = 100_000;
        executionTimes = testConcatString(numberOfOperations, numberOfIterations);
        averageOpsPerMs = calcAverageOpsPerMs(executionTimes.toArray(executionTimesArray), numberOfOperations);

        System.out.printf(
            "Tempos de execução (ms) de %d operações em %d tentativas:\n\t %s\n" +
            "Ops. per ms: %f\n" +
            "Ops. per second: %f\n",
            numberOfOperations, numberOfIterations,
            executionTimes.toString(),
            averageOpsPerMs,
            averageOpsPerMs * 1000
        );

        System.out.println("-----TESTE COM STRINGBUILDER-----");
        executionTimes = testConcatStringBuilder(numberOfOperations, numberOfIterations);
        averageOpsPerMs = calcAverageOpsPerMs(executionTimes.toArray(executionTimesArray), numberOfOperations);
        System.out.printf(
            "Tempos de execução (ms) de %d operações em %d tentativas:\n\t %s\n" +
            "Ops. per ms: %f\n" +
            "Ops. per second: %f\n",
            numberOfOperations, numberOfIterations,
            executionTimes.toString(),
            averageOpsPerMs,
            averageOpsPerMs * 1000
        );

        System.out.println("-----TESTE COM STRINGBUFFER-----");
        executionTimes = testConcatStringBuffer(numberOfOperations, numberOfIterations);
        averageOpsPerMs = calcAverageOpsPerMs(executionTimes.toArray(executionTimesArray), numberOfOperations);
        System.out.printf(
            "Tempos de execução (ms) de %d operações em %d tentativas:\n\t %s\n" +
            "Ops. per ms: %f\n" +
            "Ops. per second: %f\n",
            numberOfOperations, numberOfIterations,
            executionTimes.toString(),
            averageOpsPerMs,
            averageOpsPerMs * 1000
        );

        
        Testes originais
        System.out.println("--------TESTE COM STRING--------");
        
        int numberOfOperations = 100000;
        long startOfExecution = System.currentTimeMillis();
        concatString(numberOfOperations);
        long timeOfExecution = System.currentTimeMillis() - startOfExecution;
        
        System.out.printf("Tempo de execução (ms) com %d operações: %d ms\n", numberOfOperations, timeOfExecution);
        double opsPerMilisec = 100D / timeOfExecution;
        System.out.println("Operações por milissegundo: " + opsPerMilisec);
        System.out.println("Operações por segundo: " + (opsPerMilisec * 1000));
        System.out.println("--------------------------------");
        
        System.out.println("-----TESTE COM STRINGBUILDER-----");
        
        // numberOfOperations = 100_000;
        startOfExecution = System.currentTimeMillis();
        concatStringBuilder(100_000);
        timeOfExecution = System.currentTimeMillis() - startOfExecution;
        
        // System.out.println("Tempo de execução (ms): " + timeOfExecution + " ms");
        System.out.printf("Tempo de execução (ms) com %d operações: %d ms\n", numberOfOperations, timeOfExecution);
        opsPerMilisec = 100_000D / timeOfExecution;
        System.out.println("Operações por milissegundo: " + opsPerMilisec);
        System.out.println("Operações por segundo: " + (opsPerMilisec * 1000));
        System.out.println("Operações por segundo: " + ((long)opsPerMilisec * 1000));
        System.out.println("--------------------------------");
        
        
        System.out.println("-----TESTE COM STRINGBUFFER-----");
        
        // numberOfOperations = 100_000;
        startOfExecution = System.currentTimeMillis();
        concatStringBuilder(100_000);
        timeOfExecution = System.currentTimeMillis() - startOfExecution;
        
        // System.out.println("Tempo de execução (ms): " + timeOfExecution + " ms");
        System.out.printf("Tempo de execução (ms) com %d operações: %d ms\n", numberOfOperations, timeOfExecution);
        opsPerMilisec = 100_000D / timeOfExecution;
        System.out.println("Operações por milissegundo: " + opsPerMilisec);
        System.out.println("Operações por segundo: " + (opsPerMilisec * 1000));
        System.out.println("Operações por segundo: " + ((long)opsPerMilisec * 1000));
        // System.out.println("--------------------------------");
        
        */

    }

    static void concatString(int length) {
        String generatedString = "";
        for (int i = 0; i < length; i++) {
            generatedString += i;
            // System.out.println(generatedString);
        }
    }

    static void concatStringBuilder(int length) {
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(i);
            // System.out.println(stringBuilder);
        }
    }

    static void concatStringBuffer(int length) {
        StringBuffer stringBuffer = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            stringBuffer.append(i);
            // System.out.println(stringBuffer);
        }
    }

    static ArrayList<Long> testConcatString(int operations, int iterations) {
        long startOfExecution;
        ArrayList<Long> executionTimes = new ArrayList<Long>();
        long timeOfExecution;

        for (int i = iterations; i > 0; i--) {
            startOfExecution = System.currentTimeMillis();
            concatString(operations);
            timeOfExecution = System.currentTimeMillis() - startOfExecution;
            executionTimes.add(timeOfExecution);
        }
        return executionTimes;
    }

    static ArrayList<Long> testConcatStringBuilder(int operations, int iterations) {
        long startOfExecution;
        ArrayList<Long> executionTimes = new ArrayList<Long>();
        long timeOfExecution;

        for (int i = iterations; i > 0; i--) {
            startOfExecution = System.currentTimeMillis();
            concatStringBuilder(operations);
            timeOfExecution = System.currentTimeMillis() - startOfExecution;
            executionTimes.add(timeOfExecution);
        }
        return executionTimes;
    }

    static ArrayList<Long> testConcatStringBuffer(int operations, int iterations) {
        long startOfExecution;
        ArrayList<Long> executionTimes = new ArrayList<Long>();
        long timeOfExecution;

        for (int i = iterations; i > 0; i--) {
            startOfExecution = System.currentTimeMillis();
            concatStringBuffer(operations);
            timeOfExecution = System.currentTimeMillis() - startOfExecution;
            executionTimes.add(timeOfExecution);
        }
        return executionTimes;
    }

    static double calcAverageOpsPerMs(Long[] dataArray, int operations) {
        double sum = 0;
        
        for (int i = 0; i < dataArray.length; i++) {
            double numberOfOps = operations / (double) dataArray[i];
            sum += numberOfOps;
        }

        return sum / dataArray.length;
    }

    static double calcAverageExecTime(Long[] execTimesArray) {
        double totalTime = 0;

        for (int i = 0; i < execTimesArray.length; i++) {
            totalTime += (double)execTimesArray[i];
        }

        return totalTime / execTimesArray.length;
    }
    // static void testConcatString
    // static void testConcatString
}