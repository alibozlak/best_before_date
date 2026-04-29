package dev.bozlak.bbd.repository.implementations.jpa.user;

import dev.bozlak.bbd.dtos.store.HomePageStoreResponseDto;
import dev.bozlak.bbd.repository.implementations.jpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u.store.id FROM User u WHERE u.id = :userId")
    Integer findStoreIdByUserId(@Param("userId") Integer userId);

    @Query("SELECT u.id FROM User u WHERE u.userName = :username")
    Integer findUserIdByUsername(@Param("username") String username);

    @Query("FROM User u WHERE u.userName = :username")
    Optional<User> findByUserName(@Param("username") String username);

    @Query("SELECT new dev.bozlak.bbd.dtos.store.HomePageStoreResponseDto(" +
            "u.store.id, " +
            "u.store.storeName, " +
            "u.store.storeCode" +
            ") FROM User u " +
            "WHERE u.id = :userId")
    HomePageStoreResponseDto getHomePageStoreResponseDto(@Param("userId") Integer userId);
}
