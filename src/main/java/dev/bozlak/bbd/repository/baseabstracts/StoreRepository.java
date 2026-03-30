package dev.bozlak.bbd.repository.baseabstracts;

import dev.bozlak.bbd.entities.Store;

public interface StoreRepository {

    Store getStoreByStoreId(Integer storeId);
}
