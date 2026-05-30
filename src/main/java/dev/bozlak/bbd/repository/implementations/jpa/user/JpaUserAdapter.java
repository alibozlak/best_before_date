package dev.bozlak.bbd.repository.implementations.jpa.user;

import dev.bozlak.bbd.dtos.store.HomePageStoreResponseDto;
import dev.bozlak.bbd.dtos.user.IsBbdTrackerAndBbdTrackerResponseDto;
import dev.bozlak.bbd.dtos.user.RequestDtoForListCoworkers;
import dev.bozlak.bbd.dtos.user.UserIdAndCodeForAddUserByTrackerResponseDto;
import dev.bozlak.bbd.entities.User;
import dev.bozlak.bbd.repository.baseabstracts.BbdTrackerRepository;
import dev.bozlak.bbd.repository.baseabstracts.UserRepository;
import dev.bozlak.bbd.repository.implementations.jpa.dtos.UserIdStoreAndIsAdminModel;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.UserMapperForJpa;
import dev.bozlak.bbd.utilities.ProjectConstants;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class JpaUserAdapter implements UserRepository {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapperForJpa userMapperForJpa;
    private final BbdTrackerRepository bbdTrackerRepository;

    @Override
    public UserIdStoreAndIsAdminModel getUserIdStoreAndIsAdminModel(Integer userId) {
        return this.jpaUserRepository.getUserIdStoreAndIsAdminModel(userId);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        dev.bozlak.bbd.repository.implementations.jpa.entities.User userForJpa
                = this.jpaUserRepository.findByUserName(userName).orElseThrow();
        User user = this.userMapperForJpa.fromJpaUserToCoreUser(userForJpa);
        return Optional.of(user);
    }

    @Override
    public Integer findUserIdByUsername(String username) {
        return this.jpaUserRepository.findUserIdByUsername(username);
    }

    @Override
    public Integer findStoreIdByUserId(Integer userId) {
        return this.jpaUserRepository.findStoreIdByUserId(userId);
    }

    @Override
    public void add(User user) {
        dev.bozlak.bbd.repository.implementations.jpa.entities.User userForJpa
                = this.userMapperForJpa.fromCoreUserToJpaUser(user);
        this.jpaUserRepository.save(userForJpa);
    }

    @Override
    public HomePageStoreResponseDto getHomePageStoreResponseDto(Integer userId) {
        return this.jpaUserRepository.getHomePageStoreResponseDto(userId);
    }

    @Override
    public String getHashedPasswordByUserId(Integer userId) {
        return this.jpaUserRepository.getHashedPasswordByUserId(userId);
    }

    @Override
    public void changeUserPassword(Integer userId, String newHashedPassword) {
        this.jpaUserRepository.changeUserPassword(userId, newHashedPassword);
    }

    @Override
    public IsBbdTrackerAndBbdTrackerResponseDto isUserBbdTracker(Integer userId) {
        Boolean isUserBbdTracker = this.jpaUserRepository.findIsBbdTrackerById(userId);
        if (isUserBbdTracker){
            Integer bbdTrackerId = this.bbdTrackerRepository.getBbdTrackerIdByUserId(userId);
            return new IsBbdTrackerAndBbdTrackerResponseDto(isUserBbdTracker, bbdTrackerId);
        }

        return new IsBbdTrackerAndBbdTrackerResponseDto(false, 0);
    }

    @Override
    public List<UserIdAndCodeForAddUserByTrackerResponseDto> getUserIdAndCodeForAddUserByTrackerResponseDtoList() {
        return this.jpaUserRepository.getUserIdAndCodeForAddUserByTrackerResponseDtoList(
                ProjectConstants.Store.USER_DOESNT_HAVE_STORE_ID
        );
    }

    @Override
    public void updateStoreIdToUser(Integer userId, Integer storeId) {
        this.jpaUserRepository.updateStoreToUser(userId, storeId);
    }

    @Override
    public List<UserIdAndCodeForAddUserByTrackerResponseDto> getUserIdAndCodeForAddUserByTrackerResponseDtoList(
            RequestDtoForListCoworkers requestDtoForListCoworkers
    ) {
        return this.jpaUserRepository.getUserIdAndCodeForAddUserByTrackerResponseDtoList(
                requestDtoForListCoworkers.getStoreId(), requestDtoForListCoworkers.getUserId()
        );
    }

    @Override
    public void removeUserFromStoreByBbdTracker(Integer userId) {
        this.jpaUserRepository.updateStoreToUser(userId, ProjectConstants.Store.USER_DOESNT_HAVE_STORE_ID);
    }

    @Override
    public User getUserByUserId(Integer userId) {
        dev.bozlak.bbd.repository.implementations.jpa.entities.User user = this.jpaUserRepository.findById(userId).get();
        return this.userMapperForJpa.fromJpaUserToCoreEntityUser(user);
    }
}
