package dev.bozlak.bbd.repository.implementations.jpa.bbdrecord;

import dev.bozlak.bbd.dtos.bbdrecord.responses.BbdPastComponentReponseDto;
import dev.bozlak.bbd.dtos.bbdrecord.responses.BbdRecordWithoutRemovalDateResponse;
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

    @Query("SELECT new dev.bozlak.bbd.dtos.bbdrecord.responses.BbdRecordWithoutRemovalDateResponse(" +
            "bbd.id," +
            "bbd.product.id, " +
            "bbd.bestBeforeDate, " +
            "bbd.quantity" +
            ") FROM BbdRecord bbd WHERE bbd.id = :bbdRecordId")
    BbdRecordWithoutRemovalDateResponse getBbdRecordWithoutRemovalDateResponseDtoByBbdRecordId(
            @Param("bbdRecordId") Long bbdRecordId
    );

    @Modifying(clearAutomatically = true)
    @Query("UPDATE BbdRecord bbd SET bbd.quantity = 0 WHERE bbd.id = :bbdRecordId")
    void setQuantityColumnZeroInBbdRecordsTable(@Param("bbdRecordId") Long bbdRecordId);

    @Query("SELECT new dev.bozlak.bbd.dtos.bbdrecord.responses.BbdPastComponentReponseDto(" +
            "bbd.id, " +
            "bbd.product.productName, " +
            "bbd.product.productCode, " +
            "bbd.quantity, " +
            "bbd.bestBeforeDate" +
            ") FROM BbdRecord bbd WHERE bbd.id = :bbdRecordId")
    BbdPastComponentReponseDto getBbdPastComponentResponseDto(@Param("bbdRecordId") Long bbdRecordId);
}
