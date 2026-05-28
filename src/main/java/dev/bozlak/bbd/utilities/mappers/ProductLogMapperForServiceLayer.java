package dev.bozlak.bbd.utilities.mappers;

import dev.bozlak.bbd.dtos.product.requests.AddProductRequestDto;
import dev.bozlak.bbd.utilities.models.productlog.AddProductLogModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductLogMapperForServiceLayer {

    AddProductLogModel toProductLogModelFromAddProductRequestDto(AddProductRequestDto addProductRequestDto);
}
