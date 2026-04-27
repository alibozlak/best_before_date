package dev.bozlak.bbd.service.abstracts;

import dev.bozlak.bbd.dtos.bbdrecord.requests.AddBbdRecordRequestDto;
import dev.bozlak.bbd.dtos.bbdrecord.requests.DeleteBbdRecordRequestDto;
import dev.bozlak.bbd.dtos.bbdrecord.requests.SaleProductRequestDto;
import dev.bozlak.bbd.dtos.bbdrecord.requests.UpdateBbdRecordRequestDto;
import dev.bozlak.bbd.dtos.bbdrecord.responses.EditBbdRecordPageResponseDto;
import dev.bozlak.bbd.dtos.forupdatebbdrecordpage.UpdateBbdRecordPageResponseDto;

public interface BbdRecordService {

    void add(AddBbdRecordRequestDto addBbdRecordRequestDto);

    EditBbdRecordPageResponseDto getEditBbdRecordPageResponse(Long bbdRecordId);

    void saleProduct(SaleProductRequestDto saleProductRequestDto);

    UpdateBbdRecordPageResponseDto getUpdateBbdRecordPageDto(Long bbdRecordId);

    Long updateBbdRecord(UpdateBbdRecordRequestDto updateBbdRecordRequestDto);

    Boolean deleteBbdRecordById(DeleteBbdRecordRequestDto deleteBbdRecordRequestDto);
}
