package dev.bozlak.bbd.repository.implementations.jpa.mappers;

import dev.bozlak.bbd.repository.implementations.jpa.entities.ProductLog;
import dev.bozlak.bbd.utilities.models.productlog.AddProductLogModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductLogMapperForJpa {

    @Mapping(target = "bbdTracker.id", source = "bbdTrackerId")
    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "activityType.id", source = "activityTypeId")
    ProductLog toProductLogJpaEntityFromAddProductLogModel(AddProductLogModel addProductLogModel);
}
