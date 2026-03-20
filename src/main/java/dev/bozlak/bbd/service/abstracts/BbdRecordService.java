package dev.bozlak.bbd.service.abstracts;

import dev.bozlak.bbd.dtos.bbdrecord.requests.AddBbdRecordRequestDto;

public interface BbdRecordService {

    void add(AddBbdRecordRequestDto addBbdRecordRequestDto);
}
