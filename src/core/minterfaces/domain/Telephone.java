package core.minterfaces.domain;

public interface Telephone {

    default void makeCall(String phoneNumber) {
        System.out.println("Ligando para o número " + phoneNumber);
    }
    
    void answerCall();

}
