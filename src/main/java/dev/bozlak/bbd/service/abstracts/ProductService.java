package dev.bozlak.bbd.service.abstracts;

import dev.bozlak.bbd.dtos.product.AddProductRequestDto;

public interface ProductService {

    void add(AddProductRequestDto addProductRequestDto);
    boolean doesExistProductIdGivenNumber(Integer productId);
}
