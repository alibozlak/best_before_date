package dev.bozlak.bbd.repository.implementations.jpa.mappers;

import dev.bozlak.bbd.repository.implementations.jpa.entities.UserActivity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserActivityMapperForJpa {

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "activityType.id", source = "activityTypeId")
    @Mapping(target = "bbdRecord.id", source = "bbdRecordId")
    UserActivity fromUserActivityCoreEntityToUserActivityForJpa(dev.bozlak.bbd.entities.UserActivity userActivity);
}
