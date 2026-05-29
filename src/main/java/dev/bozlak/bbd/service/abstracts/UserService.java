package dev.bozlak.bbd.service.abstracts;

import dev.bozlak.bbd.dtos.store.HomePageStoreResponseDto;
import dev.bozlak.bbd.dtos.user.*;
import dev.bozlak.bbd.repository.implementations.jpa.dtos.UserIdStoreAndIsAdminModel;

import java.util.List;

public interface UserService {

    void add(AddUserRequestDto addUserRequestDto);
    Integer getUserIdByUsername(String username);
    Integer getStoreIdByUserId(Integer userId);
    UserIdStoreAndIsAdminModel getUserIdStoreAndIsAdminModel(Integer userId);
    HomePageStoreResponseDto getHomePageStoreResponseDto(Integer userId);
    void changePassword(ChangePasswordRequestDto changePasswordRequestDto);
    IsBbdTrackerAndBbdTrackerResponseDto isUserBbdTracker(Integer userId);
    List<UserIdAndCodeForAddUserByTrackerResponseDto> getUserIdAndCodeForAddUserByTrackerResponseDtoList();
    void addStoreToUser(AddStoreToUserRequestDto addStoreToUserRequestDto);

    List<UserIdAndCodeForAddUserByTrackerResponseDto> getUserIdAndCodeForAddUserByTrackerResponseDtoList(
            RequestDtoForListCoworkers requestDtoForListCoworkers
    );

    void removeUserFromStoreByBbdTracker(AddStoreToUserRequestDto addStoreToUserRequestDto);
}
