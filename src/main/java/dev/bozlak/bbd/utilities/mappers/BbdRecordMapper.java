package dev.bozlak.bbd.utilities.mappers;

import dev.bozlak.bbd.dtos.bbdrecord.requests.AddBbdRecordRequestDto;
import dev.bozlak.bbd.entities.BbdRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BbdRecordMapper {

    BbdRecord fromAddBbdRecordRequestDtoToBbdRecordEntity(AddBbdRecordRequestDto addBbdRecordRequestDto);
}
