package core.qstrings.test;

public class StringPerformanceTest {
    public static void main(String[] args) {

        System.out.println("--------TESTE COM STRING--------");

        int numberOfOperations = 100000;
        long startOfExecution = System.currentTimeMillis();
        concatString(numberOfOperations);
        long timeOfExecution = System.currentTimeMillis() - startOfExecution;
        
        System.out.printf("Tempo de execução com %d operações: %d ms\n", numberOfOperations, timeOfExecution);
        double opsPerMilisec = 100D / timeOfExecution;
        System.out.println("Operações por milissegundo: " + opsPerMilisec);
        System.out.println("Operações por segundo: " + (opsPerMilisec * 1000));
        System.out.println("--------------------------------");
        
        System.out.println("-----TESTE COM STRINGBUILDER-----");
        
        // numberOfOperations = 100_000;
        startOfExecution = System.currentTimeMillis();
        concatStringBuilder(100_000);
        timeOfExecution = System.currentTimeMillis() - startOfExecution;
        
        // System.out.println("Tempo de execução: " + timeOfExecution + " ms");
        System.out.printf("Tempo de execução com %d operações: %d ms\n", numberOfOperations, timeOfExecution);
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
        
        // System.out.println("Tempo de execução: " + timeOfExecution + " ms");
        System.out.printf("Tempo de execução com %d operações: %d ms\n", numberOfOperations, timeOfExecution);
        opsPerMilisec = 100_000D / timeOfExecution;
        System.out.println("Operações por milissegundo: " + opsPerMilisec);
        System.out.println("Operações por segundo: " + (opsPerMilisec * 1000));
        System.out.println("Operações por segundo: " + ((long)opsPerMilisec * 1000));
        // System.out.println("--------------------------------");


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
}
