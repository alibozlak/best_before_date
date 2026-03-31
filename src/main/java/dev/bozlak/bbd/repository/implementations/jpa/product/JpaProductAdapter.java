package dev.bozlak.bbd.repository.implementations.jpa.product;

import dev.bozlak.bbd.dtos.product.requests.AddProductRequestDto;
import dev.bozlak.bbd.dtos.product.responses.ProductIdNameCodeAndPriceResponseDto;
import dev.bozlak.bbd.repository.baseabstracts.ProductRepository;
import dev.bozlak.bbd.repository.implementations.jpa.entities.Product;
import dev.bozlak.bbd.repository.implementations.jpa.mappers.ProductMapperForJpa;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class JpaProductAdapter implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;
    private final ProductMapperForJpa productMapperForJpa;

    @Override
    public List<ProductIdNameCodeAndPriceResponseDto> getAllProductIdNameCodeAndPriceDto() {
        return this.jpaProductRepository.getAllProductIdNameCodeAndPriceDto();
    }

    @Override
    public void save(AddProductRequestDto addProductRequestDto) {
        Product productForJpa
                = this.productMapperForJpa.fromAddProductRequestDtoToProductEntityForJpa(addProductRequestDto);

        this.jpaProductRepository.save(productForJpa);
    }

    @Override
    public boolean existsById(Integer productId) {
        return this.jpaProductRepository.existsById(productId);
    }
}
