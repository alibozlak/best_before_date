package dev.bozlak.bbd.repository.implementations.jpa.mappers;

import dev.bozlak.bbd.repository.implementations.jpa.entities.AdminStoreActivity;
import dev.bozlak.bbd.utilities.models.adminstoreactivity.AddAdminStoreActivityModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdminStoreActivityMapperForJpa {

    @Mapping(target = "admin.id", source = "adminId")
    @Mapping(target = "store.id", source = "storeId")
    @Mapping(target = "activityType.id", source = "activityTypeId")
    AdminStoreActivity toAdminStoreActivityForJpaFromAddAdminStoreActivityModel(
            AddAdminStoreActivityModel addAdminStoreActivityModel
    );

}
