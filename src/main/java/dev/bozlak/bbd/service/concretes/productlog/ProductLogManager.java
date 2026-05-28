package dev.bozlak.bbd.service.concretes.productlog;

import dev.bozlak.bbd.repository.baseabstracts.ProductLogRepository;
import dev.bozlak.bbd.service.abstracts.ProductLogService;
import dev.bozlak.bbd.utilities.models.productlog.AddProductLogModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductLogManager implements ProductLogService {

    private final ProductLogRepository productLogRepository;

    @Override
    public void add(AddProductLogModel addProductLogModel) {
        this.productLogRepository.add(addProductLogModel);
    }
}
