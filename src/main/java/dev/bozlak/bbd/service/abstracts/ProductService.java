package dev.bozlak.bbd.service.abstracts;

import dev.bozlak.bbd.dtos.product.requests.AddProductRequestDto;
import dev.bozlak.bbd.dtos.product.responses.ProductIdNameCodeAndPriceResponseDto;

import java.util.List;

public interface ProductService {

    void add(AddProductRequestDto addProductRequestDto);
    List<ProductIdNameCodeAndPriceResponseDto> getAllProductIdNameCodeAndPriceDto();
    String getProductNameByProductId(Integer productId);
    Short getHowManyDaysAgoForRemovalByProductId(Integer productId);
}
