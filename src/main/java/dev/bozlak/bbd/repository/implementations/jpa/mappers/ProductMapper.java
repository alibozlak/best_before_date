package dev.bozlak.bbd.repository.implementations.jpa.mappers;

import dev.bozlak.bbd.dtos.product.requests.AddProductRequestDto;
import dev.bozlak.bbd.repository.implementations.jpa.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product fromAddProductRequestDtoToProductEntityForJpa(AddProductRequestDto addProductRequestDto);
}
