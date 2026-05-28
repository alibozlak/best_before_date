package dev.bozlak.bbd.repository.implementations.jpa.productlog;

import dev.bozlak.bbd.repository.baseabstracts.ProductLogRepository;
import dev.bozlak.bbd.repository.implementations.jpa.entities.ProductLog;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.ProductLogMapperForJpa;
import dev.bozlak.bbd.utilities.models.productlog.AddProductLogModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaProductLogRepositoryAdapter implements ProductLogRepository {

    private final JpaProductLogRepository jpaProductLogRepository;
    private final ProductLogMapperForJpa productLogMapperForJpa;

    @Override
    public void add(AddProductLogModel addProductLogModel) {
        ProductLog productLog = productLogMapperForJpa.toProductLogJpaEntityFromAddProductLogModel(addProductLogModel);

        this.jpaProductLogRepository.save(productLog);
    }
}
