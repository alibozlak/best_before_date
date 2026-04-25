package dev.bozlak.bbd.repository.implementations.jpa.mappers;

import dev.bozlak.bbd.repository.implementations.jpa.entities.BbdRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BbdRecordMapperForJpa {

    @Mapping(target = "product.id", source = "productId")
    BbdRecord fromBbdRecordCoreEntityToBbdRecordForJpaEntity(dev.bozlak.bbd.entities.BbdRecord bbdRecord);
}
