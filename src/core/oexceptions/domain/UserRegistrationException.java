package core.oexceptions.domain;

public class UserRegistrationException extends Exception {

    public UserRegistrationException() {
        super("O nome de usuário ou a senha é inválida.");
        // O construtor padrão pode ter uma mensagem genérica
    }

    public UserRegistrationException(String message) {
        super(message);
    }

}