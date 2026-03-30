package dev.bozlak.bbd.repository.implementations.jpa.mappers;

import dev.bozlak.bbd.entities.ActivityType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityTypeMapper {

    ActivityType fromJpaActivityTypeEntityToCoreActivityTypeEntity(
            dev.bozlak.bbd.repository.implementations.jpa.entities.ActivityType activityTypeEntityForJpa
    );
}
