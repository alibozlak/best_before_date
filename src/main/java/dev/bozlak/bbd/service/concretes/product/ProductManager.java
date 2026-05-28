package dev.bozlak.bbd.service.concretes.product;

import dev.bozlak.bbd.dtos.product.requests.AddProductRequestDto;
import dev.bozlak.bbd.dtos.product.responses.ProductIdNameCodeAndPriceResponseDto;
import dev.bozlak.bbd.repository.baseabstracts.ProductRepository;
import dev.bozlak.bbd.service.abstracts.ProductLogService;
import dev.bozlak.bbd.service.abstracts.ProductService;
import dev.bozlak.bbd.utilities.mappers.ProductLogMapperForServiceLayer;
import dev.bozlak.bbd.utilities.models.productlog.AddProductLogModel;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;
    private final ProductLogService productLogService;
    private final ProductLogMapperForServiceLayer productLogMapperForServiceLayer;

    @Override
    @Transactional
    public void add(AddProductRequestDto addProductRequestDto) {
        this.productRepository.save(addProductRequestDto);

        AddProductLogModel addProductLogModel
                = this.productLogMapperForServiceLayer.toProductLogModelFromAddProductRequestDto(addProductRequestDto);
        this.productLogService.add(addProductLogModel);
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
