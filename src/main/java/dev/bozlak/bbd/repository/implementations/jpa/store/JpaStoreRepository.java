package dev.bozlak.bbd.repository.implementations.jpa.store;

import dev.bozlak.bbd.repository.implementations.jpa.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaStoreRepository extends JpaRepository<Store, Integer> {

    Store findStoreById(Integer id);
}
