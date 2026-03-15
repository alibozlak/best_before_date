package dev.bozlak.bbd.repository;

import dev.bozlak.bbd.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String userName);

    @Query("SELECT u.id FROM User u WHERE u.userName = :username")
    Integer findUserIdByUsername(@Param("username") String username);
}
