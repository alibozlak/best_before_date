package dev.bozlak.bbd.service.concretes.product;

import dev.bozlak.bbd.dtos.product.requests.AddProductRequestDto;
import dev.bozlak.bbd.dtos.product.responses.ProductIdNameCodeAndPriceResponseDto;
import dev.bozlak.bbd.entities.Product;
import dev.bozlak.bbd.repository.ProductRepository;
import dev.bozlak.bbd.service.abstracts.ProductService;
import dev.bozlak.bbd.utilities.mappers.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FirstProductService implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public void add(AddProductRequestDto addProductRequestDto) {
        Product product = this.productMapper.toProduct(addProductRequestDto);
        this.productRepository.save(product);
    }

    @Override
    public boolean doesExistProductIdGivenNumber(Integer productId) {
        return this.productRepository.existsById(productId);
    }

    @Override
    public List<ProductIdNameCodeAndPriceResponseDto> getAllProductIdNameCodeAndPriceDto() {
        return this.productRepository.getAllProductIdNameCodeAndPriceDto();
    }
}
