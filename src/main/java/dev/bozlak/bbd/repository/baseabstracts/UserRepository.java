package dev.bozlak.bbd.repository.baseabstracts;

import dev.bozlak.bbd.dtos.store.HomePageStoreResponseDto;
import dev.bozlak.bbd.dtos.user.RequestDtoForListCoworkers;
import dev.bozlak.bbd.dtos.user.UserIdAndCodeForAddUserByTrackerResponseDto;
import dev.bozlak.bbd.entities.User;
import dev.bozlak.bbd.repository.implementations.jpa.dtos.UserIdStoreAndIsAdminModel;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UserRepository {

    UserIdStoreAndIsAdminModel getUserIdStoreAndIsAdminModel(Integer userId);

    Optional<User> findByUserName(String userName);

    Integer findUserIdByUsername(String username);

    Integer findStoreIdByUserId(Integer userId);

    void add(User user);

    HomePageStoreResponseDto getHomePageStoreResponseDto(Integer userId);

    String getHashedPasswordByUserId(Integer userId);

    void changeUserPassword(Integer userId, String newHashedPassword);

    Boolean isUserBbdTracker(Integer userId);

    List<UserIdAndCodeForAddUserByTrackerResponseDto> getUserIdAndCodeForAddUserByTrackerResponseDtoList();

    void updateStoreIdToUser(Integer userId, Integer storeId);

    List<UserIdAndCodeForAddUserByTrackerResponseDto> getUserIdAndCodeForAddUserByTrackerResponseDtoList(
            RequestDtoForListCoworkers requestDtoForListCoworkers
    );

    void removeUserFromStoreByBbdTracker(Integer userId);
}
