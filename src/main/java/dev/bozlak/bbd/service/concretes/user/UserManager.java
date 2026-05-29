package dev.bozlak.bbd.service.concretes.user;

import dev.bozlak.bbd.dtos.store.HomePageStoreResponseDto;
import dev.bozlak.bbd.dtos.user.*;
import dev.bozlak.bbd.entities.User;
import dev.bozlak.bbd.repository.baseabstracts.UserRepository;
import dev.bozlak.bbd.repository.implementations.jpa.dtos.UserIdStoreAndIsAdminModel;
import dev.bozlak.bbd.service.abstracts.UserHimselfActivityService;
import dev.bozlak.bbd.service.abstracts.UserService;
import dev.bozlak.bbd.utilities.exceptions.user.UserPasswordIncorrectException;
import dev.bozlak.bbd.utilities.mappers.UserMapper;
import dev.bozlak.bbd.utilities.models.userhimselactivity.AddUserHimselfActivityModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserHimselfActivityService userHimselfActivityService;

    @Override
    public void add(AddUserRequestDto addUserRequestDto) {
        User user = this.userMapper.toEntity(addUserRequestDto);
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        this.userRepository.add(user);
    }

    @Override
    public Integer getUserIdByUsername(String username) {
        return this.userRepository.findUserIdByUsername(username);
    }

    @Override
    public Integer getStoreIdByUserId(Integer userId) {
        return this.userRepository.findStoreIdByUserId(userId);
    }

    @Override
    public UserIdStoreAndIsAdminModel getUserIdStoreAndIsAdminModel(Integer userId) {
        return this.userRepository.getUserIdStoreAndIsAdminModel(userId);
    }

    @Override
    public HomePageStoreResponseDto getHomePageStoreResponseDto(Integer userId) {
        return this.userRepository.getHomePageStoreResponseDto(userId);
    }

    @Override
    @Transactional
    public void changePassword(ChangePasswordRequestDto changePasswordRequestDto) {
        String previousHashedPassword = this.userRepository.getHashedPasswordByUserId(
                changePasswordRequestDto.getUserId()
        );

        if (this.passwordEncoder.matches(changePasswordRequestDto.getPreviousPassword(), previousHashedPassword)){
            String newHashedPassword = this.passwordEncoder.encode(changePasswordRequestDto.getNewPassword());
            this.userRepository.changeUserPassword(changePasswordRequestDto.getUserId(), newHashedPassword);

            this.userHimselfActivityService.add(new AddUserHimselfActivityModel(
                    changePasswordRequestDto.getUserId(), changePasswordRequestDto.getActivityTypeId()
            ));
            return;
        }

        throw new UserPasswordIncorrectException();
    }

    @Override
    public IsBbdTrackerAndBbdTrackerResponseDto isUserBbdTracker(Integer userId) {
        return this.userRepository.isUserBbdTracker(userId);
    }

    @Override
    public List<UserIdAndCodeForAddUserByTrackerResponseDto> getUserIdAndCodeForAddUserByTrackerResponseDtoList() {
        return this.userRepository.getUserIdAndCodeForAddUserByTrackerResponseDtoList();
    }

    @Override
    @Transactional
    public void addStoreToUser(AddStoreToUserRequestDto addStoreToUserRequestDto) {

        this.userRepository.updateStoreIdToUser(
                addStoreToUserRequestDto.getUserId(),
                addStoreToUserRequestDto.getStoreId()
        );

        //ToDo : must adding to bbd_tracker_himself_activities table!!
        //..
    }

    @Override
    public List<UserIdAndCodeForAddUserByTrackerResponseDto> getUserIdAndCodeForAddUserByTrackerResponseDtoList(
            RequestDtoForListCoworkers requestDtoForListCoworkers
    ) {
        return this.userRepository.getUserIdAndCodeForAddUserByTrackerResponseDtoList(requestDtoForListCoworkers);
    }

    @Override
    @Transactional
    public void removeUserFromStoreByBbdTracker(AddStoreToUserRequestDto addStoreToUserRequestDto) {

        this.userRepository.removeUserFromStoreByBbdTracker(addStoreToUserRequestDto.getUserId());

        //ToDo : must adding to bbd_tracker_himself_activities table!!
        //..
    }
}
