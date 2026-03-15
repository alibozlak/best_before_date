package dev.bozlak.bbd.repository;

import dev.bozlak.bbd.entities.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityTypeRepository extends JpaRepository<ActivityType, Byte> {
}
