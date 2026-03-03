package dev.bozlak.bbd.utilities.mappers;

import dev.bozlak.bbd.dtos.bbdrecord.AddBbdRecordRequestDto;
import dev.bozlak.bbd.entities.BbdRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BbdRecordMapper {

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "productId", target = "product.id")
    BbdRecord fromAddBbdRecordRequestDtoToBbdRecordEntity(AddBbdRecordRequestDto addBbdRecordRequestDto);
}
