package dev.bozlak.bbd.utilities.exceptions.user;

public class UserPasswordIncorrectException extends RuntimeException {

    public UserPasswordIncorrectException() {
        super("Şifreniz Yanlış! İşlem gerçekleşmedi!");
    }
}
