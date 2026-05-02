package dev.bozlak.bbd.repository.implementations.jpa.user;

import dev.bozlak.bbd.dtos.store.HomePageStoreResponseDto;
import dev.bozlak.bbd.entities.Store;
import dev.bozlak.bbd.entities.User;
import dev.bozlak.bbd.repository.baseabstracts.UserRepository;
import dev.bozlak.bbd.repository.implementations.jpa.dtos.UserIdStoreAndIsAdminModel;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.UserMapperForJpa;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class JpaUserAdapter implements UserRepository {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapperForJpa userMapperForJpa;

    @Override
    public UserIdStoreAndIsAdminModel getUserIdStoreAndIsAdminModel(Integer userId) {
        UserIdStoreAndIsAdminModel userIdStoreAndIsAdminModel
                = this.jpaUserRepository.getUserIdStoreAndIsAdminModel(userId);
        //System.out.println(userIdStoreAndIsAdminModel);
        return userIdStoreAndIsAdminModel;
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
    public void deleteById(Integer id) {
        this.jpaUserRepository.deleteById(id);
    }

    @Override
    public void add(User user) {
        dev.bozlak.bbd.repository.implementations.jpa.entities.User userForJpa
                = this.userMapperForJpa.fromCoreUserToJpaUser(user);
        this.jpaUserRepository.save(userForJpa);
    }

    @Override
    public boolean existsById(Integer userId) {
        return this.jpaUserRepository.existsById(userId);
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
    public Boolean isUserBbdTracker(Integer userId) {
        return this.jpaUserRepository.findIsBbdTrackerById(userId);
    }
}
