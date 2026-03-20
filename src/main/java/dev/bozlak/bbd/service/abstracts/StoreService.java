package dev.bozlak.bbd.service.abstracts;

import dev.bozlak.bbd.entities.Store;

public interface StoreService {

    Store getStoreByStoreId(Integer storeId);
}
