package dev.bozlak.bbd.repository.baseabstracts;

import dev.bozlak.bbd.dtos.product.requests.AddProductRequestDto;
import dev.bozlak.bbd.dtos.product.responses.ProductIdNameCodeAndPriceResponseDto;

import java.util.List;

public interface ProductRepository {

    List<ProductIdNameCodeAndPriceResponseDto> getAllProductIdNameCodeAndPriceDto();
    void save(AddProductRequestDto addProductRequestDto);
    boolean existsById(Integer productId);
    Short getHowManyDaysAgoForRemovalByProductId(Integer productId);
}
