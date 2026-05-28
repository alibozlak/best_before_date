package dev.bozlak.bbd.repository.implementations.jpa.productlog;

import dev.bozlak.bbd.repository.implementations.jpa.entities.ProductLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductLogRepository extends JpaRepository<ProductLog, Long> {
}
