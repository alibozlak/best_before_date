package dev.bozlak.bbd.repository.implementations.jpa.store;

import dev.bozlak.bbd.entities.Store;
import dev.bozlak.bbd.repository.baseabstracts.StoreRepository;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.StoreMapperForJpa;
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
                .stream().map(s -> this.storeMapperForJpa.fromStoreForJpaEntityToStoreEntity(s)).toList();
    }
}
