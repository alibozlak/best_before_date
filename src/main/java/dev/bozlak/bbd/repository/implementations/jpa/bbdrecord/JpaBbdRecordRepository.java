package dev.bozlak.bbd.repository.implementations.jpa.bbdrecord;

import dev.bozlak.bbd.repository.implementations.jpa.entities.BbdRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBbdRecordRepository extends JpaRepository<BbdRecord, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE BbdRecord bbd SET bbd.quantity = :newQuantity WHERE bbd.id = :bbdRecordId")
    void saleProduct(@Param("bbdRecordId") Long bbdRecordId, @Param("newQuantity") Short newQuantity);
}
