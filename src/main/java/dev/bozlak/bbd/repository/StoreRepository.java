package dev.bozlak.bbd.repository;

import dev.bozlak.bbd.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

    @Query("FROM Store s WHERE s.id = :storeId")
    Store getStoreByStoreId(@Param("storeId") Integer storeId);
}
