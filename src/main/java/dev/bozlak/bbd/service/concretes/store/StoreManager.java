package dev.bozlak.bbd.service.concretes.store;

import dev.bozlak.bbd.dtos.store.CreateStoreRequestDto;
import dev.bozlak.bbd.entities.Store;
import dev.bozlak.bbd.repository.baseabstracts.StoreRepository;
import dev.bozlak.bbd.service.abstracts.AdminStoreActivityService;
import dev.bozlak.bbd.service.abstracts.StoreService;
import dev.bozlak.bbd.utilities.mappers.StoreMapper;
import dev.bozlak.bbd.utilities.models.adminstoreactivity.AddAdminStoreActivityModel;
import dev.bozlak.bbd.utilities.models.store.CreateStoreModel;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public class StoreManager implements StoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;
    private final AdminStoreActivityService adminStoreActivityService;

    @Override
    public Store getStoreByStoreId(Integer storeId) {
        return this.storeRepository.getStoreByStoreId(storeId);
    }

    @Override
    public List<Store> getStoreList() {
        return this.storeRepository.getStores();
    }

    @Override
    @Transactional
    public void createStore(CreateStoreRequestDto createStoreRequestDto) {
        CreateStoreModel createStoreModel = this.storeMapper
                .toCreateStoreModelFromCreateStoreRequestDto(createStoreRequestDto);
        Integer storeId = this.storeRepository.createStore(createStoreModel);

        AddAdminStoreActivityModel addAdminStoreActivityModel = new AddAdminStoreActivityModel();
        addAdminStoreActivityModel.setAdminId(createStoreRequestDto.adminId());
        addAdminStoreActivityModel.setStoreId(storeId);
        final Byte addStoreActivityTypeId = 13;
        addAdminStoreActivityModel.setActivityTypeId(addStoreActivityTypeId);
        this.adminStoreActivityService.add(addAdminStoreActivityModel);
    }
}
