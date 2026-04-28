package dev.bozlak.bbd.repository.baseabstracts;

import dev.bozlak.bbd.entities.Store;

import java.util.List;

public interface StoreRepository {

    Store getStoreByStoreId(Integer storeId);
    List<Store> getStores();
}
