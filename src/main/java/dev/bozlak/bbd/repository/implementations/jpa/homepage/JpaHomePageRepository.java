package dev.bozlak.bbd.repository.implementations.jpa.homepage;

import dev.bozlak.bbd.repository.implementations.jpa.entities.BbdRecord;
import dev.bozlak.bbd.repository.implementations.jpa.dtos.RemovalDateSectionForSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JpaHomePageRepository extends JpaRepository<BbdRecord, Long> {

    @Query("SELECT new dev.bozlak.bbd.repository.implementations.jpa.dtos.RemovalDateSectionForSql(" +
            "bbd.removalDate, " +
            "bbd.id, " +
            "bbd.product.productCode, " +
            "bbd.product.productName, " +
            "bbd.quantity, " +
            "bbd.bestBeforeDate, " +
            "bbd.product.price, " +
            "bbd.product.tax) " +
            "FROM BbdRecord bbd WHERE bbd.bestBeforeDate >= :today AND bbd.storeId = :storeId AND " +
            "bbd.quantity > 0 " +
            "ORDER BY bbd.removalDate")
    List<RemovalDateSectionForSql> getCurrentBbdList(
            @Param("today") LocalDate today, @Param("storeId") Integer storeId
    );

    @Query("SELECT new dev.bozlak.bbd.repository.implementations.jpa.dtos.RemovalDateSectionForSql(" +
            "bbd.removalDate, " +
            "bbd.id, " +
            "bbd.product.productCode, " +
            "bbd.product.productName, " +
            "bbd.quantity, " +
            "bbd.bestBeforeDate, " +
            "bbd.product.price, " +
            "bbd.product.tax) " +
            "FROM BbdRecord bbd WHERE bbd.storeId = :storeId AND " +
            "bbd.quantity > 0 " +
            "ORDER BY bbd.removalDate")
    List<RemovalDateSectionForSql> getCurrentBbdList(@Param("storeId") Integer storeId);
}
