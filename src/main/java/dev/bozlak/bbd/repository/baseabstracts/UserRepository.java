package dev.bozlak.bbd.repository.baseabstracts;

import dev.bozlak.bbd.entities.User;

import java.util.Optional;


public interface UserRepository {

    Optional<User> findByUserName(String userName);

    Integer findUserIdByUsername(String username);

    Integer findStoreIdByUserId(Integer userId);

    void deleteById(Integer id);

    void add(User user);

    boolean existsById(Integer userId);
}
