package dev.bozlak.bbd.repository.implementations.jpa.mappers;

import dev.bozlak.bbd.repository.implementations.jpa.entities.UserHimselfActivity;
import dev.bozlak.bbd.utilities.models.userhimselactivity.AddUserHimselfActivityModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserHimselfActivityMapperForJpa {

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "activityType.id", source = "activityTypeId")
    UserHimselfActivity toUserHimselfActivityFromItsAddModel(AddUserHimselfActivityModel addUserHimselfActivityModel);
}
