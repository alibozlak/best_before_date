package dev.bozlak.bbd.repository.implementations.jpa.activitytype;

import dev.bozlak.bbd.repository.implementations.jpa.entities.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaActivityTypeRepository extends JpaRepository<ActivityType, Byte> {
}
