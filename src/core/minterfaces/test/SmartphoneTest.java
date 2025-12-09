package core.minterfaces.test;

import core.minterfaces.domain.Smartphone;

public class SmartphoneTest {

    public static void main(String[] args) {
        Smartphone myPhone = new Smartphone();

        myPhone.takePicture();
        myPhone.recordVideo();

        myPhone.play("Passacaglia in G minor by Heinrich Biber - lute arrangement");
        myPhone.stop();

        myPhone.makeCall("12345678");
        myPhone.answerCall();
    }

}
