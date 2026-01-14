package core.oexceptions.test;

import java.util.Scanner;

import core.oexceptions.domain.UserRegistrationException;

public class CustomizedExceptionTest {
    public static void main(String[] args) {
        try {
            registerUser();
        } catch (UserRegistrationException e) {
            e.printStackTrace();
        }
    }

    static void registerUser() throws UserRegistrationException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite abaixo o nome de usuário:");
        String username = scanner.nextLine();
        System.out.println("Digite abaixo uma senha:");
        String password = scanner.nextLine();
        scanner.close();

        if (username.isBlank() || username.isEmpty()) {
            throw new UserRegistrationException("Nome de usuário não contém caracteres válidos.");
        }
        if (password.isBlank() || password.isEmpty()) {
            throw new UserRegistrationException("Senha não contém caracteres válidos.");
        }

        System.out.println("Usuário cadastrado.");
    }

}
