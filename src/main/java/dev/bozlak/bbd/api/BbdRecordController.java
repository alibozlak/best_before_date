package dev.bozlak.bbd.api;

import dev.bozlak.bbd.dtos.bbdrecord.requests.*;
import dev.bozlak.bbd.dtos.bbdrecord.responses.BbdPastComponentReponseDto;
import dev.bozlak.bbd.dtos.bbdrecord.responses.EditBbdRecordPageResponseDto;
import dev.bozlak.bbd.dtos.forupdatebbdrecordpage.UpdateBbdRecordPageResponseDto;
import dev.bozlak.bbd.service.abstracts.BbdRecordService;
import dev.bozlak.core.responses.ResponseBody;
import dev.bozlak.core.responses.ResponseBodyWithObject;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bbdrecords")
@RequiredArgsConstructor
public class BbdRecordController {

    private final BbdRecordService bbdRecordService;

    @PostMapping
    public ResponseEntity<ResponseBody> add(@RequestBody @Valid AddBbdRecordRequestDto addBbdRecordRequestDto){
        this.bbdRecordService.add(addBbdRecordRequestDto);
        return new ResponseEntity<>(
                new ResponseBody(true),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/get-update-bbd-record-page-model")
    public ResponseEntity<ResponseBodyWithObject<EditBbdRecordPageResponseDto>> getEditBbdRecordPageResponse(
            @RequestBody Long bbdRecordId
    ){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.bbdRecordService.getEditBbdRecordPageResponse(bbdRecordId)),
                HttpStatus.OK
        );
    }

    @PostMapping("/sale-product")
    public ResponseEntity<ResponseBody> saleProduct(@RequestBody SaleProductRequestDto saleProductRequestDto){
        this.bbdRecordService.saleProduct(saleProductRequestDto);
        return new ResponseEntity<>(
                new ResponseBody(true),
                HttpStatus.OK
        );
    }

    @PostMapping("/get-update-bbd-record-page-dto")
    public ResponseEntity<ResponseBodyWithObject<UpdateBbdRecordPageResponseDto>> getUpdateBbdRecordPageDto(
            @RequestBody Long bbdRecordId
    ){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.bbdRecordService.getUpdateBbdRecordPageDto(bbdRecordId)),
                HttpStatus.OK
        );
    }

    @PutMapping
    public ResponseEntity<ResponseBodyWithObject<Long>> updateBbdRecord(
            @RequestBody UpdateBbdRecordRequestDto updateBbdRecordRequestDto
    ){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.bbdRecordService.updateBbdRecord(updateBbdRecordRequestDto)),
                HttpStatus.OK
        );
    }

    @PutMapping("/soft-delete")
    public ResponseEntity<ResponseBody> deleteBbdRecordById(
            @RequestBody DeleteBbdRecordRequestDto deleteBbdRecordRequestDto
    ){
        this.bbdRecordService.deleteBbdRecordById(deleteBbdRecordRequestDto);
        return new ResponseEntity<>(
                new ResponseBody(true),
                HttpStatus.OK
        );
    }

    @GetMapping("/get-bbd-past-record-dto/{bbdRecordId}")
    public ResponseEntity<ResponseBodyWithObject<BbdPastComponentReponseDto>> getBbdPastComponentResponseDto(
            @PathVariable("bbdRecordId") Long bbdRecordId
    ){
        return new ResponseEntity<>(
                new ResponseBodyWithObject<>(this.bbdRecordService.getBbdPastComponentResponseDto(bbdRecordId)),
                HttpStatus.OK
        );
    }

    @PutMapping("/update-for-bbd-past")
    public ResponseEntity<ResponseBody> doOperationBbdPastComponentRequestDto(
            @RequestBody BbdPastComponentRequestDto bbdPastComponentRequestDto
    ){
        this.bbdRecordService.doOperationBbdPastComponentRequestDto(bbdPastComponentRequestDto);
        return new ResponseEntity<>(
                new ResponseBody(true),
                HttpStatus.OK
        );
    }
}
