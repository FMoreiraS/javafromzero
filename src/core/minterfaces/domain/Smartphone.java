package core.minterfaces.domain;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Smartphone implements Camera, Telephone, AudioPlayer{

    @Override
    public void answerCall() {
        int callerNumber = ThreadLocalRandom.current().nextInt(0, 99999999);
        System.out.println("Ligação de " + callerNumber);
        System.out.println("Deseja atender?(S/N)");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().trim().equalsIgnoreCase("s")) {
            System.out.println("Chamada atendida.");
        }
        System.out.println("Chamada recusada");
    }

}
