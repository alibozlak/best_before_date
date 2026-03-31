package dev.bozlak.bbd.repository.implementations.jpa.bbdrecord;

import dev.bozlak.bbd.entities.BbdRecord;
import dev.bozlak.bbd.repository.baseabstracts.BbdRecordRepository;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.BbdRecordMapperForJpa;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaBbdRecordRepositoryAdapter implements BbdRecordRepository {

    private final JpaBbdRecordRepository jpaBbdRecordRepository;
    private final BbdRecordMapperForJpa bbdRecordMapperForJpa;

    @Override
    public void save(BbdRecord bbdRecord) {
        dev.bozlak.bbd.repository.implementations.jpa.entities.BbdRecord bbdRecordForJpa
                = this.bbdRecordMapperForJpa.fromBbdRecordCoreEntityToBbdRecordForJpaEntity(bbdRecord);

        this.jpaBbdRecordRepository.save(bbdRecordForJpa);
    }
}
