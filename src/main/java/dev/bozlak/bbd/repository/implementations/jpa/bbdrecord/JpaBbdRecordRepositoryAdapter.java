package dev.bozlak.bbd.repository.implementations.jpa.bbdrecord;

import dev.bozlak.bbd.dtos.bbdrecord.modelsforbackend.BbdRecordIdAndQuantityModel;
import dev.bozlak.bbd.entities.BbdRecord;
import dev.bozlak.bbd.repository.baseabstracts.BbdRecordRepository;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.BbdRecordMapperForJpa;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaBbdRecordRepositoryAdapter implements BbdRecordRepository {

    private final JpaBbdRecordRepository jpaBbdRecordRepository;
    private final BbdRecordMapperForJpa bbdRecordMapperForJpa;

    @Override
    public Long save(BbdRecord bbdRecord) {
        dev.bozlak.bbd.repository.implementations.jpa.entities.BbdRecord bbdRecordForJpa
                = this.bbdRecordMapperForJpa.fromBbdRecordCoreEntityToBbdRecordForJpaEntity(bbdRecord);

        return this.jpaBbdRecordRepository.save(bbdRecordForJpa).getId();
    }

    @Override
    public void saleProduct(BbdRecordIdAndQuantityModel bbdRecordIdAndQuantityModel) {
        this.jpaBbdRecordRepository.saleProduct(
                bbdRecordIdAndQuantityModel.getBbdRecordId(), bbdRecordIdAndQuantityModel.getNewQuantity()
        );
    }
}
