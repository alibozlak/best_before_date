package dev.bozlak.bbd.repository.implementations.jpa.store;

import dev.bozlak.bbd.entities.Store;
import dev.bozlak.bbd.repository.baseabstracts.StoreRepository;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.StoreMapperForJpa;
import dev.bozlak.bbd.utilities.models.store.CreateStoreModel;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class JpaStoreAdapter implements StoreRepository {

    private final JpaStoreRepository jpaStoreRepository;
    private final StoreMapperForJpa storeMapperForJpa;

    @Override
    public Store getStoreByStoreId(Integer storeId) {
        dev.bozlak.bbd.repository.implementations.jpa.entities.Store storeForJpa
                = this.jpaStoreRepository.findStoreById(storeId);

        return this.storeMapperForJpa.fromStoreForJpaEntityToStoreEntity(storeForJpa);
    }

    @Override
    public List<Store> getStores() {
        return this.jpaStoreRepository.findAll()
                .stream().map(this.storeMapperForJpa::fromStoreForJpaEntityToStoreEntity).toList();
    }

    @Override
    public Integer createStore(CreateStoreModel createStoreModel) {
        dev.bozlak.bbd.repository.implementations.jpa.entities.Store storeForJpa
                = this.storeMapperForJpa.fromCreateStoreModelToStoreEntityForJpa(createStoreModel);

        return this.jpaStoreRepository.save(storeForJpa).getId();
    }
}
