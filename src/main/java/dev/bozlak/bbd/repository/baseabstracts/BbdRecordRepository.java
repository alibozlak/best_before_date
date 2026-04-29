package dev.bozlak.bbd.repository.baseabstracts;

import dev.bozlak.bbd.dtos.bbdrecord.modelsforbackend.BbdRecordIdAndQuantityModel;
import dev.bozlak.bbd.dtos.bbdrecord.responses.BbdPastComponentReponseDto;
import dev.bozlak.bbd.dtos.bbdrecord.responses.BbdRecordWithoutRemovalDateResponse;
import dev.bozlak.bbd.entities.BbdRecord;

public interface BbdRecordRepository {

    Long save(BbdRecord bbdRecord);

    void saleProduct(BbdRecordIdAndQuantityModel bbdRecordIdAndQuantityModel);

    BbdRecordWithoutRemovalDateResponse getBbdRecordWithoutRemovalDateResponseDtoByBbdRecordId(Long bbdRecordId);

    Long updateBbdRecord(BbdRecord bbdRecord);

    Boolean deleteBbdRecordById(Long bbdRecordId);

    BbdPastComponentReponseDto getBbdPastComponentResponseDto(Long bbdRecordId);

    void setQuantityColumnZeroInBbdListTable(Long bbdRecordId);
}
