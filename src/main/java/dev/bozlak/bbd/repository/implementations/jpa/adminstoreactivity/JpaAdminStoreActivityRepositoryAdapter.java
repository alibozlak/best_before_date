package dev.bozlak.bbd.repository.implementations.jpa.adminstoreactivity;

import dev.bozlak.bbd.repository.baseabstracts.AdminStoreActivityRepository;
import dev.bozlak.bbd.repository.implementations.jpa.entities.AdminStoreActivity;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.AdminStoreActivityMapperForJpa;
import dev.bozlak.bbd.utilities.models.adminstoreactivity.AddAdminStoreActivityModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaAdminStoreActivityRepositoryAdapter implements AdminStoreActivityRepository {

    private final JpaAdminStoreActivityRepository jpaAdminStoreActivityRepository;
    private final AdminStoreActivityMapperForJpa adminStoreActivityMapperForJpa;

    @Override
    public void add(AddAdminStoreActivityModel addAdminStoreActivityModel) {
        AdminStoreActivity adminStoreActivity =  this.adminStoreActivityMapperForJpa
                .toAdminStoreActivityForJpaFromAddAdminStoreActivityModel(addAdminStoreActivityModel);

        this.jpaAdminStoreActivityRepository.save(adminStoreActivity);
    }
}
