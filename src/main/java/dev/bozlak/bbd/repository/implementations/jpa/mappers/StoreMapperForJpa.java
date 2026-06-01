package dev.bozlak.bbd.repository.implementations.jpa.mappers;

import dev.bozlak.bbd.entities.Store;
import dev.bozlak.bbd.utilities.models.store.CreateStoreModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StoreMapperForJpa {

    Store fromStoreForJpaEntityToStoreEntity(
            dev.bozlak.bbd.repository.implementations.jpa.entities.Store storeForJpa
    );

    dev.bozlak.bbd.repository.implementations.jpa.entities.Store fromCreateStoreModelToStoreEntityForJpa(
            CreateStoreModel createStoreModel
    );
}
