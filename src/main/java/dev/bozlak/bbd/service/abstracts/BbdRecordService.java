package dev.bozlak.bbd.service.abstracts;

import dev.bozlak.bbd.dtos.bbdrecord.requests.AddBbdRecordRequestDto;
import dev.bozlak.bbd.dtos.bbdrecord.requests.SaleProductRequestDto;

public interface BbdRecordService {

    void add(AddBbdRecordRequestDto addBbdRecordRequestDto);

    void saleProduct(SaleProductRequestDto saleProductRequestDto);
}
