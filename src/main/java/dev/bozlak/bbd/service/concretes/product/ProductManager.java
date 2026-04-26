package dev.bozlak.bbd.service.concretes.product;

import dev.bozlak.bbd.dtos.product.requests.AddProductRequestDto;
import dev.bozlak.bbd.dtos.product.responses.ProductIdNameCodeAndPriceResponseDto;
import dev.bozlak.bbd.repository.baseabstracts.ProductRepository;
import dev.bozlak.bbd.service.abstracts.ProductService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void add(AddProductRequestDto addProductRequestDto) {
        this.productRepository.save(addProductRequestDto);
    }

    @Override
    public List<ProductIdNameCodeAndPriceResponseDto> getAllProductIdNameCodeAndPriceDto() {
        return this.productRepository.getAllProductIdNameCodeAndPriceDto();
    }

    @Override
    public String getProductNameByProductId(Integer productId) {
        return this.productRepository.getProductNameByProductId(productId);
    }

    @Override
    public Short getHowManyDaysAgoForRemovalByProductId(Integer productId) {
        return this.productRepository.getHowManyDaysAgoForRemovalByProductId(productId);
    }
}
