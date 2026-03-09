package dev.bozlak.bbd.utilities.exceptions.user;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Integer userId) {
        super("User not found!! User ID : " + userId);
    }
}
