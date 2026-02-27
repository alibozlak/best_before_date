package dev.bozlak.bbd.utilities.mappers;

import dev.bozlak.bbd.dtos.user.AddUserRequestDto;
import dev.bozlak.bbd.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "storeId", target = "store.id")
    User toEntity(AddUserRequestDto addUserRequestDto);
}
