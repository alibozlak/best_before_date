package dev.bozlak.bbd.utilities.mappers;

import dev.bozlak.bbd.dtos.store.CreateStoreRequestDto;
import dev.bozlak.bbd.utilities.models.store.CreateStoreModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StoreMapper {

    CreateStoreModel toCreateStoreModelFromCreateStoreRequestDto(CreateStoreRequestDto createStoreRequestDto);
}
