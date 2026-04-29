package dev.bozlak.bbd.utilities.mappers;

import dev.bozlak.bbd.dtos.bbdrecord.requests.AddBbdRecordRequestDto;
import dev.bozlak.bbd.dtos.bbdrecord.requests.BbdPastComponentRequestDto;
import dev.bozlak.bbd.dtos.bbdrecord.requests.DeleteBbdRecordRequestDto;
import dev.bozlak.bbd.dtos.bbdrecord.requests.SaleProductRequestDto;
import dev.bozlak.bbd.entities.UserActivity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserActivityMapper {

    @Mapping(target = "quantity", source = "saledQuantity")
    UserActivity toUserActivityFromSaleProductRequestDto(SaleProductRequestDto saleProductRequestDto);

    UserActivity toUserActivityFromAddBbdRecordRequestDto(AddBbdRecordRequestDto addBbdRecordRequestDto);

    UserActivity toUserActivityFromDeleteBbdRecordRequestDto(DeleteBbdRecordRequestDto deleteBbdRecordRequestDto);

    @Mapping(target = "quantity", source = "deletedQuantity")
    UserActivity toUserActivityFromBbdPastComponentRequestDto(BbdPastComponentRequestDto bbdPastComponentRequestDto);
}
