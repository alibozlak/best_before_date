package dev.bozlak.bbd.repository.implementations.jpa.mappers;

import dev.bozlak.bbd.entities.Store;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StoreMapper {

    Store fromStoreForJpaEntityToStoreEntity(
            dev.bozlak.bbd.repository.implementations.jpa.entities.Store storeForJpa
    );
}
