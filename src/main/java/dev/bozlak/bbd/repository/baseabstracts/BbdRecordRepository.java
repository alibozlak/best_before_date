package dev.bozlak.bbd.repository.baseabstracts;

import dev.bozlak.bbd.entities.BbdRecord;

public interface BbdRecordRepository {

    void save(BbdRecord bbdRecord);
}
