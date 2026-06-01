package dev.bozlak.bbd.service.abstracts;

import dev.bozlak.bbd.dtos.store.CreateStoreRequestDto;
import dev.bozlak.bbd.entities.Store;

import java.util.List;

public interface StoreService {

    Store getStoreByStoreId(Integer storeId);
    List<Store> getStoreList();
    void createStore(CreateStoreRequestDto createStoreRequestDto);
}
