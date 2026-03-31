package dev.bozlak.bbd.repository.implementations.jpa.bbdrecord;

import dev.bozlak.bbd.repository.implementations.jpa.entities.BbdRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBbdRecordRepository extends JpaRepository<BbdRecord, Long> {
}
