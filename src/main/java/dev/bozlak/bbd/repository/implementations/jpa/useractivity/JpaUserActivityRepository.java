package dev.bozlak.bbd.repository.implementations.jpa.useractivity;

import dev.bozlak.bbd.repository.implementations.jpa.entities.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserActivityRepository extends JpaRepository<UserActivity, Long> {
}
