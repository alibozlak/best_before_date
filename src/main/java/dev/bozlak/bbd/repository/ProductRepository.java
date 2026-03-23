package dev.bozlak.bbd.repository;

import dev.bozlak.bbd.dtos.product.responses.ProductIdNameCodeAndPriceResponseDto;
import dev.bozlak.bbd.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT new dev.bozlak.bbd.dtos.product.responses.ProductIdNameCodeAndPriceResponseDto(" +
            "p.id, " +
            "p.productName, " +
            "p.productCode, " +
            "p.price) " +
            "FROM Product p ORDER BY p.productCode")
    List<ProductIdNameCodeAndPriceResponseDto> getAllProductIdNameCodeAndPriceDto();
}
