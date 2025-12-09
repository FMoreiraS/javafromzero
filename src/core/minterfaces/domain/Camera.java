package core.minterfaces.domain;

public interface Camera {

    default void takePicture() {
        System.out.println("Tirando fotografia");
    }
    default void recordVideo() {
        System.out.println("Tirando fotografia");
    }

}
