package core.oexceptions.domain;

import java.util.InputMismatchException;

public class Employee extends User {

    public void createAccount() throws UserRegistrationException, InputMismatchException {
        System.out.println("Conta de funcionário criada.");
    }

}
