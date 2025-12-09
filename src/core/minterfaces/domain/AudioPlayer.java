package core.minterfaces.domain;

public interface AudioPlayer {

    default void play(String fileName) {
        System.out.println("Reproduzindo " + fileName + ".");
    }
    default void stop() {
        System.out.println("Interrompendo a reprodução");
    }

}
