package dev.bozlak.bbd.repository.implementations.jpa.user;


import dev.bozlak.bbd.entities.User;
import dev.bozlak.bbd.repository.baseabstracts.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FirstJpaUserRepository implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public Optional<User> findByUserName(String userName) {
        return this.jpaUserRepository.findByUserName(userName);
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
        this.jpaUserRepository.save(user);
    }

    @Override
    public boolean existsById(Integer userId) {
        return this.jpaUserRepository.existsById(userId);
    }
}
