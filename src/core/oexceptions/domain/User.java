package core.oexceptions.domain;

import java.io.IOException;

public class User {

    public void createAccount() throws UserRegistrationException, IOException {
        System.out.println("Conta de usuário criada.");
    }

}
