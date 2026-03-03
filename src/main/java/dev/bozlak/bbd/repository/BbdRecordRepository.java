package dev.bozlak.bbd.repository;

import dev.bozlak.bbd.entities.BbdRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BbdRecordRepository extends JpaRepository<BbdRecord, Long> {
}
