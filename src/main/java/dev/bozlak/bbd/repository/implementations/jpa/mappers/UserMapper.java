package dev.bozlak.bbd.repository.implementations.jpa.mappers;

import dev.bozlak.bbd.repository.implementations.jpa.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "storeId", target = "store.id")
    User fromCoreUserToJpaUser(dev.bozlak.bbd.entities.User user);

    @Mapping(source = "store.id", target = "storeId")
    dev.bozlak.bbd.entities.User fromJpaUserToCoreUser(User user);
}
