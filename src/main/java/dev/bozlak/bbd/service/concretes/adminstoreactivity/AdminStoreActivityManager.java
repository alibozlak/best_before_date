package dev.bozlak.bbd.service.concretes.adminstoreactivity;

import dev.bozlak.bbd.repository.baseabstracts.AdminStoreActivityRepository;
import dev.bozlak.bbd.service.abstracts.AdminStoreActivityService;
import dev.bozlak.bbd.utilities.models.adminstoreactivity.AddAdminStoreActivityModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdminStoreActivityManager implements AdminStoreActivityService {

    private final AdminStoreActivityRepository adminStoreActivityRepository;


    @Override
    public void add(AddAdminStoreActivityModel addAdminStoreActivityModel) {
        this.adminStoreActivityRepository.add(addAdminStoreActivityModel);
    }
}
