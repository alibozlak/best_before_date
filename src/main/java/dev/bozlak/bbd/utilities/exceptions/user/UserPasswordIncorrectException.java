package dev.bozlak.bbd.utilities.exceptions.user;

public class UserPasswordIncorrectException extends RuntimeException {

    public UserPasswordIncorrectException() {
        super("Incorrect password! Operation failed.");
    }
}
