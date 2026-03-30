package dev.bozlak.bbd.service.concretes.store;

import dev.bozlak.bbd.entities.Store;
import dev.bozlak.bbd.repository.baseabstracts.StoreRepository;
import dev.bozlak.bbd.service.abstracts.StoreService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StoreManager implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public Store getStoreByStoreId(Integer storeId) {
        return this.storeRepository.getStoreByStoreId(storeId);
    }
}
