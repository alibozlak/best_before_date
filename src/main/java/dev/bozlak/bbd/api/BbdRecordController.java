package dev.bozlak.bbd.api;

import dev.bozlak.bbd.dtos.bbdrecord.requests.AddBbdRecordRequestDto;
import dev.bozlak.bbd.dtos.bbdrecord.requests.SaleProductRequestDto;
import dev.bozlak.bbd.dtos.bbdrecord.requests.UpdateBbdRecordRequestDto;
import dev.bozlak.bbd.dtos.bbdrecord.responses.EditBbdRecordPageResponseDto;
import dev.bozlak.bbd.dtos.forupdatebbdrecordpage.UpdateBbdRecordPageResponseDto;
import dev.bozlak.bbd.service.abstracts.BbdRecordService;
import dev.bozlak.core.responses.ResponseBody;
import dev.bozlak.core.responses.ResponseBodyWithObject;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bbdrecords")
@RequiredArgsConstructor
public class BbdRecordController {

    private final BbdRecordService bbdRecordService;

    @PostMapping
    public ResponseBody add(@RequestBody @Valid AddBbdRecordRequestDto addBbdRecordRequestDto){
        this.bbdRecordService.add(addBbdRecordRequestDto);
        return new ResponseBody(true);
    }

    @PostMapping("/get-update-bbd-record-page-model")
    public ResponseBodyWithObject<EditBbdRecordPageResponseDto> getEditBbdRecordPageResponse(
            @RequestBody Long bbdRecordId
    ){
        return new ResponseBodyWithObject<>(this.bbdRecordService.getEditBbdRecordPageResponse(bbdRecordId));
    }

    @PostMapping("/sale-product")
    public ResponseBody saleProduct(@RequestBody SaleProductRequestDto saleProductRequestDto){
        this.bbdRecordService.saleProduct(saleProductRequestDto);
        return new ResponseBody(true);
    }

    @PostMapping("/get-update-bbd-record-page-dto")
    public ResponseBodyWithObject<UpdateBbdRecordPageResponseDto> getUpdateBbdRecordPageDto(
            @RequestBody Long bbdRecordId
    ){
        return new ResponseBodyWithObject<>(this.bbdRecordService.getUpdateBbdRecordPageDto(bbdRecordId));
    }

    @PutMapping
    public ResponseBodyWithObject<Long> updateBbdRecord(
            @RequestBody UpdateBbdRecordRequestDto updateBbdRecordRequestDto
    ){
        return new ResponseBodyWithObject<>(this.bbdRecordService.updateBbdRecord(updateBbdRecordRequestDto));
    }
}
