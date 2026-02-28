package dev.bozlak.bbd.utilities.mappers;

import dev.bozlak.bbd.dtos.product.AddProductRequestDto;
import dev.bozlak.bbd.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(AddProductRequestDto addProductRequestDto);
}
