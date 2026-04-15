package dev.bozlak.bbd.service.abstracts;

import dev.bozlak.bbd.dtos.product.requests.AddProductRequestDto;
import dev.bozlak.bbd.dtos.product.responses.ProductIdNameCodeAndPriceResponseDto;

import java.util.List;

public interface ProductService {

    void add(AddProductRequestDto addProductRequestDto);
    boolean doesExistProductIdGivenNumber(Integer productId);
    List<ProductIdNameCodeAndPriceResponseDto> getAllProductIdNameCodeAndPriceDto();
    Short getHowManyDaysAgoForRemovalByProductId(Integer productId);
}
