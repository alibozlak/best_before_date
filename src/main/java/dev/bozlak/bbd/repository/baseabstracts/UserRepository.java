package dev.bozlak.bbd.repository.baseabstracts;

import dev.bozlak.bbd.dtos.store.HomePageStoreResponseDto;
import dev.bozlak.bbd.entities.User;
import dev.bozlak.bbd.repository.implementations.jpa.dtos.UserIdStoreAndIsAdminModel;

import java.util.Optional;


public interface UserRepository {

    UserIdStoreAndIsAdminModel getUserIdStoreAndIsAdminModel(Integer userId);

    Optional<User> findByUserName(String userName);

    Integer findUserIdByUsername(String username);

    Integer findStoreIdByUserId(Integer userId);

    void deleteById(Integer id);

    void add(User user);

    boolean existsById(Integer userId);

    HomePageStoreResponseDto getHomePageStoreResponseDto(Integer userId);

    String getHashedPasswordByUserId(Integer userId);

    void changeUserPassword(Integer userId, String newHashedPassword);

    Boolean isUserBbdTracker(Integer userId);
}
