package dev.bozlak.bbd.repository.implementations.jpa.user;

import dev.bozlak.bbd.dtos.store.HomePageStoreResponseDto;
import dev.bozlak.bbd.dtos.user.UserIdAndCodeForAddUserByTrackerResponseDto;
import dev.bozlak.bbd.repository.implementations.jpa.dtos.UserIdStoreAndIsAdminModel;
import dev.bozlak.bbd.repository.implementations.jpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT new dev.bozlak.bbd.repository.implementations.jpa.dtos.UserIdStoreAndIsAdminModel(" +
            "u.id, " +
            "u.store, " +
            "u.isAdmin" +
            ") FROM User u WHERE u.id = :userId")
    UserIdStoreAndIsAdminModel getUserIdStoreAndIsAdminModel(@Param("userId") Integer userId);

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

    @Query("SELECT u.password FROM User u WHERE u.id = :userId")
    String getHashedPasswordByUserId(@Param("userId") Integer userId);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.password = :newHashedPassword WHERE u.id = :userId")
    void changeUserPassword(@Param("userId") Integer userId, @Param("newHashedPassword") String newHashedPassword);

    @Query("SELECT u.isBbdTracker FROM User u WHERE u.id = :userId")
    Boolean findIsBbdTrackerById(@Param("userId") Integer userId);

    @Query("SELECT new dev.bozlak.bbd.dtos.user.UserIdAndCodeForAddUserByTrackerResponseDto(" +
            "u.id, " +
            "u.userName" +
            ") FROM User u WHERE u.store.id = :numberOfStoreIdForUserDoesntHaveStore" +
            " ORDER BY u.userName")
    List<UserIdAndCodeForAddUserByTrackerResponseDto> getUserIdAndCodeForAddUserByTrackerResponseDtoList(
            @Param("numberOfStoreIdForUserDoesntHaveStore") Integer numberOfStoreIdForUserDoesntHaveStore
    );

    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.store.id = :storeId WHERE u.id = :userId")
    void updateStoreToUser(@Param("userId") Integer userId, @Param("storeId") Integer storeId);

    @Query("SELECT new dev.bozlak.bbd.dtos.user.UserIdAndCodeForAddUserByTrackerResponseDto(" +
            "u.id, " +
            "u.userName" +
            ") FROM User u WHERE u.store.id = :storeId AND u.id <> :userId" +
            " ORDER BY u.userName")
    List<UserIdAndCodeForAddUserByTrackerResponseDto> getUserIdAndCodeForAddUserByTrackerResponseDtoList(
            @Param("storeId") Integer storeId, @Param("userId") Integer userId
    );

}
