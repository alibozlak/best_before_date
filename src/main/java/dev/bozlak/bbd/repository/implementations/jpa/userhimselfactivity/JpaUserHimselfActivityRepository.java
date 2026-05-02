package dev.bozlak.bbd.repository.implementations.jpa.userhimselfactivity;

import dev.bozlak.bbd.repository.implementations.jpa.entities.UserHimselfActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserHimselfActivityRepository extends JpaRepository<UserHimselfActivity, Long> {
}
