package core.qstrings.test;

public class StringPerformanceTest {
    public static void main(String[] args) {
        // Teste com String
        long startOfExecution = System.currentTimeMillis();
        
        concatString(10_000);
        
        long timeOfExecution = System.currentTimeMillis() - startOfExecution;
        System.out.println("Tempo de execução com String: " + timeOfExecution + " ms");
        
        // Teste com StringBuilder
        startOfExecution = System.currentTimeMillis();
        
        concatStringBuilder(100_000);
        
        timeOfExecution = System.currentTimeMillis() - startOfExecution;
        System.out.println("Tempo de execução com StringBuilder: " + timeOfExecution + " ms");
        
        // Teste com StringBuffer
        startOfExecution = System.currentTimeMillis();

        concatStringBuffer(100_000);

        timeOfExecution = System.currentTimeMillis() - startOfExecution;
        System.out.println("Tempo de execução com StringBuffer: " + timeOfExecution + " ms");


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
